package questao_01.logic;

import java.util.ArrayList;
import java.util.List;

import questao_01.model.Arco;
import questao_01.model.Grafo;
import questao_01.model.Vertice;

public class BellmanFord {

	private static double infinity = Double.POSITIVE_INFINITY;

	public BellmanFord() {

	}

	public List<Vertice> bellmanFord(Grafo G, Vertice origem, Vertice destino, double preco, double autonomia) {
		inicializacao(G, origem);

		for (int i = 1; i < G.V.size(); i++) { // Para o total de vertices - 1
			for (Arco a : G.A) { // Para cada aresta
				Vertice u = a.verticeInicio;
				double uEstimativa = u.estimativa;
				Vertice v = a.verticeDestino;
				double vEstimativa = v.estimativa;
				double custoa = a.custo(preco, autonomia);
				if (vEstimativa > (uEstimativa + custoa)) {
					v.estimativa = uEstimativa + custoa;
					v.antecessor = u;
				}
			} 
		}
		// Sera retornado a menor estimativa da distancia ate o idDestino
		return returnPath(G.V, destino);
	}

	public void inicializacao(Grafo G, Vertice origem) {
		for (Vertice v : G.V) {
			v.estimativa = infinity;
			v.antecessor = null;
		}
		origem.estimativa = 0.0;
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
