package questao_03_mem.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import questao_03_mem.model.Caminhao;
import questao_03_mem.model.Item;
import questao_03_mem.model.MatrizEsparsa;
import questao_03_mem.model.Tupla;

public class MochilaMultiplaProgDinAdaptado {

	public void multiplaCarga(List<Caminhao> T, List<Item> G) {
		// Ordenar os caminhoes de T baseado nas suas cargas de forma crescente
		Collections.sort(T);
		// Ordenar os itens de G baseado nos seus pesos de forma crescente
		Collections.sort(G);

		// Para cada caminhao com menor capacidade, faca
		for(Caminhao t : T) {
			// Validação para conjuntos de itens vazios
			if(G.size() == 0) break;
		    // Buscar a melhor solucao:
			Tupla<List<Item>, Integer> opt = mochilaProgDinAdaptado(t, G);
			t.itensNaCarga.addAll(opt.lin);
			t.valorItensNaCarga = opt.col;
		    // Um item nao pode estar em 2 caminhoes, entao iremos remover 
			// os itens adicionados a este caminhao de G
		    G.removeAll(t.itensNaCarga);
		}
	}
	
	public Tupla<List<Item>, Integer> mochilaProgDinAdaptado(Caminhao t, List<Item> G) {
		// Implementacao de uma Matriz Esparsa - baseada em HashMap 
		// (futuramente poderia ser outra implementacao mais eficiente)
		MatrizEsparsa<Long, Item, Integer> M = new MatrizEsparsa<Long, Item, Integer>(0);
		
		// Representacao do item anterior 
		// (linha acima da atual na matrix, pois o indice J representa o objeto Item)
		Item anterior = null;
		// Para cada item:
		for(Item g : G){
			// Para cada capacidade possivel da mochila (indice I)
			long cargaMaxima = (long) t.cargaMaxima;
			for (long i = 1; i <= cargaMaxima; i++) {
				if (i < g.peso) {
					// se nao couber, usa o valor da linha de cima encontrado 
					M.set(i, g, M.get(i, anterior));
				} else {
					// escolhe a melhor solucao entre: a anterior calculada ou com  adicao do item
					M.set(i, g, max(M.get(i, anterior), g.valor + M.get(i - g.peso, anterior)));
				}
			}
			// Atualiza o indice J (objeto)
			anterior = g;
		}

		// Extrai o melhor valor (lucro) -> ultima posicao da matriz 
		int melhorValor = M.get((long) t.cargaMaxima, anterior);
		// Extrai os itens da solucao otima (OPT)
		List<Item> melhorCaso = getOPT(t, G, M);
		
		return new Tupla<List<Item>, Integer>(melhorCaso, melhorValor);
	}

	private List<Item> getOPT(Caminhao t, List<Item> G, MatrizEsparsa<Long, Item, Integer> M) {
		List<Item> melhorCaso = new ArrayList<>();
		long i = (long) t.cargaMaxima;
		for (int k = G.size() - 1; k >= 0; k--) {
			Item anterior = (k - 1) >= 0? G.get(k - 1) : null;
			Item g = G.get(k);
			if (M.get(i, g) - M.get(i, anterior) > 0) {
				melhorCaso.add(g);
				t.capacidadeAtual -= g.peso;
				i = i - g.peso;
			}
		}
		return melhorCaso;
	}
	
	private int max(int x, int y) {
		return x > y? x : y;
	}
	
}
