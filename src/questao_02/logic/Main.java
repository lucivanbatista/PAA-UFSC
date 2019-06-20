package questao_02.logic;

import questao_02.model.Aresta;
import questao_02.model.Grafo;
import questao_02.model.Vertice;

public class Main {

	public static void teste1(){
		Grafo G = new Grafo();
		Vertice a = new Vertice(1);
		Vertice b = new Vertice(2);
		Vertice c = new Vertice(3);
		Vertice d = new Vertice(4);
		Vertice e = new Vertice(5);
		Vertice f = new Vertice(6);
		
		G.addVertice(a);
		G.addVertice(b);
		G.addVertice(c);
		G.addVertice(d);
		G.addVertice(e);
		G.addVertice(f);
		
		G.addAresta(new Aresta(a, b, 3));
		G.addAresta(new Aresta(b, c, 2.5));
		G.addAresta(new Aresta(c, d, 4));
		G.addAresta(new Aresta(d, e, 1));
		G.addAresta(new Aresta(e, a, 9));
		G.addAresta(new Aresta(b, e, 2));
		G.addAresta(new Aresta(b, f, 4));
		
		new Kruskal().execucaoKruskal(G);
	}
		
	public static void main(String[] args) {
		teste1();
	}

}
