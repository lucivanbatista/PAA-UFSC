package questao_03_mem.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import questao_03_mem.model.Caminhao;
import questao_03_mem.model.Item;
import questao_03_mem.model.MatrizEsparsa;
import questao_03_mem.model.Tupla;

public class MochilaMultipla {

	public void multiplaCarga(List<Caminhao> T, List<Item> G) {
		// Ordenar os caminhoes de T baseado nas suas cargas de forma crescente
		Collections.sort(T);
		// Ordenar os itens de G baseado nos seus pesos de forma crescente
		Collections.sort(G);

		// Para cada caminhao com menor capacidade, faca
		for(Caminhao t : T) {
			// Validação para conjuntos de itens vazios
			if(G.size() == 0) break;
		    // Buscar a melhor solução:
			Tupla<List<Item>, Integer> opt = mochila(t, G);
			t.itensNaCarga = opt.lin;
			t.valorItensNaCarga = opt.col;
		    // Um item nao pode estar em 2 caminhoes, entao iremos remover 
			// os itens adicionados a este caminhao de G
		    G.removeAll(t.itensNaCarga);
		}
	}
	
	public Tupla<List<Item>, Integer> mochila(Caminhao t, List<Item> G) {
		// Implementação de uma Matriz Esparsa - baseada em HashMap 
		// (futuramente poderia ser outra implementação mais eficiente)
		MatrizEsparsa<Long, Item, Integer> M = new MatrizEsparsa<Long, Item, Integer>(0);
		
		// Representação do item anterior 
		// (linha acima da atual na matrix, pois o índice J é o objeto Item)
		Item anterior = null;
		// Para cada item:
		for(Item g : G){
			// Para cada capacidade possível da mochila (índice I)
			for (long i = 1; i <= t.cargaMaxima; i++) {
				if (i < g.peso) {
					// se não couber, usa o valor da linha de cima encontrado 
					M.set(i, g, M.get(i, anterior));
				} else {
					// escolhe a melhor solução entre: a anterior calculada ou com  adição do item
					M.set(i, g, max(M.get(i, anterior), g.valor + M.get(i - g.peso, anterior)));
				}
			}
			// Atualiza o índice J (objeto)
			anterior = g;
		}

		// Extrai o melhor valor (lucro) -> última posição da matriz 
		int melhorValor = M.get((long) t.cargaMaxima, anterior);
		// Extrai os itens da solução ótima (OPT)
		List<Item> melhorCaso = getOPT(t, G, M);
		
		return new Tupla<List<Item>, Integer>(melhorCaso, melhorValor);
	}

	private List<Item> getOPT(Caminhao t, List<Item> G, MatrizEsparsa<Long, Item, Integer> M) {
		List<Item> melhorCaso = new ArrayList<>();
		long i = (long) t.cargaMaxima;
		for (int k = G.size() - 1; k > 0; k--) {
			Item anterior = G.get(k - 1);
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
