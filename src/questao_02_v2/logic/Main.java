package questao_02_v2.logic;

import java.util.List;

import questao_02_v2.model.*;

public class Main {

	public static Grafo criacaoGrafoTeste(){
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
		
		return G;
	}
		
	public static void main(String[] args) {
		Grafo G = criacaoGrafoTeste();
		Kruskal k = new Kruskal();
		
		List<Aresta> MST = k.kruskalAdaptado(G);
		System.out.println("* Arvore Geradora Minima - Linhas de transmissao de menor custo: ");
		k.showVerticesArvoreGeradoraMinima(MST);
		
		System.out.println("* Custo Minimo das linhas de transmissao: \n	" + k.custoMinimo);
		
		System.out.println("* Cidades com mais de 3 linhas de transmissao: ");
		k.getArestasAdjacentes();
	}

}
