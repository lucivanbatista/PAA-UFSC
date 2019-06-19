package questao_01_bfs.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import questao_01.model.Arco;
import questao_01.model.Grafo;
import questao_01.model.Vertice;

public class CaminhoMinimoBFS {

	private static double infinity = Double.POSITIVE_INFINITY;

	public CaminhoMinimoBFS() {

	}

	// Abordagem de Caminho Minimo utilizando Busca em Largura (Breadth-First Search, BFS)
	public List<Vertice> caminhoMinimoBFS(Grafo G, Vertice origem, Vertice destino, double preco, double autonomia) {
		inicializacao(G, origem);

		// Fila de Prioridade (Maior prioridade = menor custo)
		PriorityQueue<Vertice> fila = new PriorityQueue<>(); // Fila de Prioridade (Maior prioridade = menor custo)
		fila.add(origem);

		// Enquanto a fila de prioridade nao estiver vazia, faca
		while (!fila.isEmpty()) {
			// Ele ira remover o vertice que esta no comeco da fila e ira armazenar no vertice u
			Vertice u = fila.poll();

			// Se ainda nao foi visitado, entao visitaremos
			if (u.visitar == false) {
				// Depois nao sera mais usado
				u.visitar = true;
				// Ira pegar a distancia do u e armazenar na estimativa para calcular a estimativa para seus vizinhos
				double uEstimativa = u.estimativa;

				// Para cada aresta a que possui o vertice u, entao ira...
				for (Arco a : getArcoByVertice(G, u)) {
					// pegar o outro vertice da outra ponta da aresta e ira comparar a estimativa com o u
					Vertice v = a.verticeDestino;
					// Estimativa do vertice da ponta 2
					double vEstimativa = v.estimativa;

					double custoa = a.custo(preco, autonomia);
					// Se a estimativa do vertice da outra ponta, for maior que a estimativa do vertice u
					if (vEstimativa > (uEstimativa + custoa)) {
						v.estimativa = uEstimativa + custoa;
						v.antecessor = u;
						// Adicionando na fila de prioridades o vertice da outra ponta
						fila.add(v);
					}
				} // O while vai se repetir ate todos os vertices conectados com a origem possuam uma estimativa
			}
		}
		// Sera retornado a menor estimativa da distancia ate o idDestino
		return returnPath(G.V, destino);
	}

	public void inicializacao(Grafo G, Vertice origem) {
		for (Vertice v : G.V) {
			v.estimativa = infinity;
			v.antecessor = null;
			v.visitar = false;
		}
		origem.estimativa = 0.0;
	}

	public List<Arco> getArcoByVertice(Grafo G, Vertice u) { // Dentro dos arcos, ele ira procurar as arestas que
																// possuem esse vertice
		List<Arco> arestaComIdVertice = new ArrayList<>();// Lista de arcos que possuem esse vertice
		for (Arco a : G.A) {
			if (a.verticeInicio.equals(u)) {
				arestaComIdVertice.add(a);
			}
		}
		return arestaComIdVertice;
	}

	public List<Vertice> returnPath(List<Vertice> V, Vertice destino) {
		List<Vertice> caminhoMinimo = new ArrayList<>();
		if (destino.estimativa == infinity) {
			return null;
		} else {
			return getAntecessor(caminhoMinimo, destino);
		}
	}

	public List<Vertice> getAntecessor(List<Vertice> caminhoMinimo, Vertice v) {
		if (v != null) {
			getAntecessor(caminhoMinimo, v.antecessor);
			caminhoMinimo.add(v);
			return caminhoMinimo;
		}
		return null;
	}
}
