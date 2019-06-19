package questao_01.logic;

import java.util.List;

import questao_01.model.Arco;
import questao_01.model.Grafo;
import questao_01.model.Vertice;

public class Main {
	
	public static void teste1(){ // Teste para Dijkstra
		Grafo G = new Grafo();
		Vertice a = new Vertice(1, 0);
		Vertice b = new Vertice(2, 0);
		Vertice c = new Vertice(3, 0);
		Vertice d = new Vertice(4, 0);
		Vertice e = new Vertice(5, 0);
		Vertice f = new Vertice(6, 0);
		Vertice g = new Vertice(7, 0);
		Vertice h = new Vertice(8, 0);
		
		G.addVertice(a);
		G.addVertice(b);
		G.addVertice(c);
		G.addVertice(d);
		G.addVertice(e);
		G.addVertice(f);
		G.addVertice(g);
		G.addVertice(h);
		
		G.addAresta(new Arco(a, b, 2));
		G.addAresta(new Arco(b, c, 3));
		G.addAresta(new Arco(a, c, 4));
		G.addAresta(new Arco(c, d, 1));
		G.addAresta(new Arco(b, d, 8));
		G.addAresta(new Arco(c, e, 3));
		G.addAresta(new Arco(d, f, 6));
		G.addAresta(new Arco(h, e, 10));
		G.addAresta(new Arco(e, f, 3));
		G.addAresta(new Arco(g, f, 4));
		G.addAresta(new Arco(b, g, 5));
		G.addAresta(new Arco(f, b, 10));
		G.addAresta(new Arco(g, a, 8));
		
		double preco = 10;
		double autonomia = 10;
		
		Dijkstra dijkstra = new Dijkstra();
		List<Vertice> caminhoMinimo = dijkstra.dijkstra(G, f, e, preco, autonomia);
		
		System.out.println("Caminho M�nimo: ");
		if(caminhoMinimo == null) {
			System.out.println("N�o tem caminho!");
			System.out.println("Custo M�nimo: " + Double.POSITIVE_INFINITY);
		}else {
			for (Vertice v: caminhoMinimo) {
				System.out.print(v.id + " ");
			}
			System.out.println("\nCusto M�nimo: " + caminhoMinimo.get(caminhoMinimo.size() - 1).estimativa);
		}
	}
		
	public static void main(String[] args) {
		teste1();
	}
}
