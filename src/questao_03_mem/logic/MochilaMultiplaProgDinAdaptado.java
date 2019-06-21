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
		// Ordenar os itens de G baseado nos seus pesos de forma decrescente
		Collections.sort(G);

		// Para cada caminhao com menor capacidade, faca
		for(Caminhao t : T) {
			// Validacao para conjuntos de itens vazios
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
		MatrizEsparsa<Item, Long, Integer> M = new MatrizEsparsa<Item, Long, Integer>(0);
		
		// Representacao do item anterior 
		// (linha acima da atual na matrix, pois o indice J representa o objeto Item)
		Item iAnterior = null;
		// Para cada item:
		for(Item i : G){
			// Para cada capacidade possivel da mochila (indice J)
			long cargaMaxima = (long) t.cargaMaxima;
			for (long j = 1; j <= cargaMaxima; j++) {
				if (j < i.peso) {
					// se nao couber, usa o valor da coluna anterior 
					M.set(i, j, M.get(iAnterior, j));
				} else {
					// escolhe a melhor solucao entre: a anterior calculada ou com  adicao do item
					M.set(i, j, max(M.get(iAnterior, j), 1 + M.get(iAnterior, j - i.peso)));
				}
			}
			// Atualiza o indice J (objeto)
			iAnterior = i;
		}

		// Extrai os itens da solucao otima (OPT)
		List<Item> melhorCaso = getOPT(t, G, M);
		
		// Calcula o melhor valor (lucro) 
		int melhorValor = 0;
		for (Item i : melhorCaso) {
			melhorValor += i.valor;
		}
		
		return new Tupla<List<Item>, Integer>(melhorCaso, melhorValor);
	}

	private List<Item> getOPT(Caminhao t, List<Item> G, MatrizEsparsa<Item, Long, Integer> M) {
		List<Item> melhorCaso = new ArrayList<>();
		long j = (long) t.cargaMaxima;
		for (int k = G.size() - 1; k >= 0; k--) {
			Item iAnterior = (k - 1) >= 0? G.get(k - 1) : null;
			Item i = G.get(k);
			if (M.get(i, j) - M.get(iAnterior, j) > 0) {
				melhorCaso.add(i);
				t.capacidadeAtual -= i.peso;
				j = j - i.peso;
			}
		}
		return melhorCaso;
	}
	
	private int max(int x, int y) {
		return x > y? x : y;
	}
	
}
