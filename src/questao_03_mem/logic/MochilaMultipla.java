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
		
		if(G.size() == 0){
	        return new Tupla<List<Item>, Integer>(null, 0); // retorna nada
		}
		
		MatrizEsparsa<Long, Item, Integer> M = new MatrizEsparsa<Long, Item, Integer>(0);
		
		Item anterior = null;
		for(Item g : G){
			for (long i = 1; i <= t.cargaMaxima; i++) {
				if (i < g.peso) {
					M.set(i, g, M.get(i, anterior));
				} else {
					M.set(i, g, max(M.get(i, anterior), g.valor + M.get(i - g.peso, anterior)));
				}
			}
			anterior = g;
		}

		int melhorValor = M.get((long) t.cargaMaxima, anterior);
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
