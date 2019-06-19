package questao_01.logic;

import java.util.List;

import questao_01.model.Arco;
import questao_01.model.Grafo;
import questao_01.model.Vertice;

public class Main {
	
	public static void teste1(){
		Grafo G = new Grafo();
		Vertice a = new Vertice(1, 0);
		Vertice b = new Vertice(2, 0);
		Vertice c = new Vertice(3, 0);
		Vertice d = new Vertice(4, 0);
		Vertice t = new Vertice(5, 0);
		Vertice s = new Vertice(6, 0);
		Vertice g = new Vertice(7, 0);
		Vertice h = new Vertice(8, 0);
		
		G.addVertice(a);
		G.addVertice(b);
		G.addVertice(c);
		G.addVertice(d);
		G.addVertice(t);
		G.addVertice(s);
		G.addVertice(g);
		G.addVertice(h);
		
		G.addAresta(new Arco(a, b, 2));
		G.addAresta(new Arco(b, c, 3));
		G.addAresta(new Arco(a, c, 4));
		G.addAresta(new Arco(c, d, 1));
		G.addAresta(new Arco(b, d, 8));
		G.addAresta(new Arco(c, t, 3));
		G.addAresta(new Arco(d, s, 6));
		G.addAresta(new Arco(h, t, 10));
		G.addAresta(new Arco(t, s, 3));
		G.addAresta(new Arco(g, s, 4));
		G.addAresta(new Arco(b, g, 5));
		G.addAresta(new Arco(s, b, 10));
		G.addAresta(new Arco(g, a, 8));
		
		double precoCombustivel = 10;
		double autonomia = 10;
		
		// Execucao do BellmanFord e retorno de uma lista de vertices representando o caminho minimo
		// O custo e feito atraves da estivamitva do vertice t 
		List<Vertice> caminhoMinimo = new BellmanFord().bellmanFordAdaptado(G, s, t, precoCombustivel, autonomia);
		
		System.out.println("Caminho Minimo: ");
		if(caminhoMinimo == null) {
			System.out.println("Nao tem caminho!");
			System.out.println("Custo Minimo: " + Double.POSITIVE_INFINITY);
		}else {
			for (Vertice v: caminhoMinimo) {
				System.out.print(v.id + " ");
			}
			System.out.println("\nCusto Minimo: " + caminhoMinimo.get(caminhoMinimo.size() - 1).estimativa);
		}
	}
		
	public static void main(String[] args) {
		teste1();
	}
}
