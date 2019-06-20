package questao_02_v2.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import questao_02_v2.model.*;

public class Kruskal {
	List<Aresta> MST; // Arvore Geradora Minima
	double custoMinimo; // Custo Minimo da Arvore
    Map<Vertice,Integer> countArestas; // Contador dos vertices presentes na Arvore
	
	public Kruskal() {
		this.custoMinimo = 0;
		this.MST = new ArrayList<>();
		countArestas = new HashMap<Vertice,Integer>();
	}

	public List<Aresta> kruskalAdaptado(Grafo G){
		// Contador dos grupos
		int i = 1;
		// Criar grupos para cada vertice
		for (Vertice h : G.H) {
			h.grupo = new Grupo(i, h);
			i++;
			this.countArestas.put(h, 0);
		}

		// Lista com as arestas em ordem crescente dos pesos
		List<Aresta> ESorted = new ArrayList<>(G.E);
		Collections.sort(ESorted);
		
		// Para cada aresta na lista ordenada, faca
		for(Aresta e : ESorted) {
			// Se os vertices forem de grupos diferentes, entao
			if(e.verticeA.grupo.id != e.verticeB.grupo.id) {
				// Adicionar na Arvore Geradora Minima
				this.MST.add(e);
				// Incrementar no contador dos vertices a aresta selecionada
				this.countArestas.put(e.verticeA, this.countArestas.get(e.verticeA) + 1);
				this.countArestas.put(e.verticeB, this.countArestas.get(e.verticeB) + 1);
				// Somar o novo valor ao Custo Minimo
				this.custoMinimo += e.peso;
				// Juntar em um novo grupo todos os vertices do mesmo grupo de A
				// e todos os vertices do mesmo grupo de B
				e.verticeA.grupo.union(e.verticeB.grupo);
			}
		}
		return MST;
	}
	
	// Mostrar Vertices e Peso da Arvore Geradora Minima
	public void showVerticesArvoreGeradoraMinima(List<Aresta> MST) {
		for(Aresta ar : MST) {
			System.out.println("	Vertice A: " + ar.verticeA +
					"  Vertice B: " + ar.verticeB + "  Peso Aresta: " + ar.peso);
		}
	}
	
	public void getArestasAdjacentes() {
		for(Vertice h : this.countArestas.keySet()) {
			if(this.countArestas.get(h) > 3) {
				System.out.println("	" + h.id);
			}
		}
	}
}
