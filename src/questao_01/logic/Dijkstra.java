package questao_01.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import questao_01.model.Arco;
import questao_01.model.Grafo;
import questao_01.model.Vertice;

public class Dijkstra {

	private static double infinity = Double.POSITIVE_INFINITY;
	
	public Dijkstra() {

	}
	
	public List<Vertice> dijkstra(Grafo G, Vertice origem, Vertice destino, double preco, double autonomia){
		inicializacao(G, origem);

		PriorityQueue<Vertice> fila = new PriorityQueue<>(); //Fila de Prioridade (Maior prioridade = menor custo)
		fila.add(origem);
		
		while(!fila.isEmpty()){ //Enquanto a fila de prioridade n�o estiver vazia, fa�a
			Vertice u = fila.poll(); // Ele ir� remover o head da fila e ir� armazenar no v�rtice u
			
			if(u.visitar == false){ // Se ainda n�o foi visitado, ent�o visitaremos
				u.visitar = true; // Depois n�o ser� mais usado
				double uEstimativa = u.estimativa; // Irei pegar a distancia do u e armazenar na estimativa
				
				for(Arco a : getArcoByVertice(G, u)){ // Para cada aresta que possui o u, ent�o irei...
					Vertice v = a.verticeDestino; // pegar o outro vertice da ponta 2 da aresta e irei comparar a estimativa com o u (ponta 1)
					double vEstimativa = v.estimativa; // Estimativa do vertice da ponta 2
					
					double custoa = a.custo(preco, autonomia);
					if(vEstimativa > (uEstimativa + custoa)){ // Se a estimativa do vertice da ponta 2, for maior que a estimativa do vertice u (ponta 1)
						v.estimativa = uEstimativa + custoa; //com o custo da aresta, ent�o a estimativa da ponta 2, ser� a soma da ponta 1 + o custo da aresta;
						v.antecessor = u;
						fila.add(v); // Adicionando na fila de prioridades
					} 
				} // O while vai se repetir at� todos os v�rtices possuirem uma estimativa
			}
		}
		return returnPath(G.V, destino); // Ser� retornado a menor estimativa da distancia at� o idDestino
	}
	
	public void inicializacao(Grafo G, Vertice origem){
		for(Vertice v : G.V){
			v.estimativa = infinity;
			v.antecessor = null;
			v.visitar = false;
		}
		origem.estimativa = 0.0;
	}	
	
	public List<Arco> getArcoByVertice(Grafo G, Vertice u){ // Dentro dos arcos, ele ir� procurar as arestas que possuem esse v�rtice
		List<Arco> arestaComIdVertice = new ArrayList<>();// Lista de arcos que possuem esse v�rtice
		for(Arco a : G.A){
			if(a.verticeInicio.equals(u)){
				arestaComIdVertice.add(a);
			}
		}
		return arestaComIdVertice;
	}
	
	public List<Vertice> returnPath(List<Vertice> V, Vertice destino) {
		List<Vertice> caminhoMinimo = new ArrayList<>();
		if(destino.estimativa == infinity) {
			return null;
		}else {
			return getAntecessor(caminhoMinimo, destino);
		}
	}
	
	public List<Vertice> getAntecessor(List<Vertice> caminhoMinimo, Vertice v) {
		if(v != null) {
			getAntecessor(caminhoMinimo, v.antecessor);
			caminhoMinimo.add(v);
			return caminhoMinimo;
		}
		return null;
	}
}
