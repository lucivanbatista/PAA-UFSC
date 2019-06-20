package questao_03.logic;

import java.util.Collections;
import java.util.List;

import questao_03.model.Caminhao;
import questao_03.model.Item;

public class MochilaMultiplaGulosaAdaptado {

	public void mochilaMultiplaAdaptado(List<Caminhao> T, List<Item> G) {
		// Ordenar os caminhoes de T baseado nas suas cargas de forma crescente
		Collections.sort(T);
		// Ordenar os itens de G baseado nos seus valores (lucro) de forma decrescente
		Collections.sort(G);

		// Para cada caminhao com menor capacidade, faca
		for(Caminhao t : T) {
		    // Para cada item mais valioso, faca
		    for(Item g : G){
		    	// Se consigo colocar esse item dentro da capacidade disponivel do caminhao, entao
		        if(g.peso <= t.capacidadeAtual){
		            t.capacidadeAtual -= g.peso; // capacidade atual do caminhao sera reduzida
		            t.addItem(g); // adicionando esse item ao caminhao
		            t.valorItensNaCarga += g.valor; // o valor total dos itens que estao neste caminhao
		        }
		    }
		    // Um item nao pode estar em 2 caminhoes, entao iremos remover os itens adicionados a este caminhao de G
		    G.removeAll(t.itensNaCarga);
		}
	}
	
	public void getInformacaoCaminhoesAtual(List<Caminhao> T) {
		System.out.println("Informacoes sobre os caminhoes: ");
		for(Caminhao t : T) {
			System.out.println("	Caminhao " + t);
			System.out.println("		Itens no caminhao: ");
			for(Item g : t.itensNaCarga) {
				System.out.println("			" + g);
			}
		}		
	}
	
	public void getItensNaoEntregues(List<Item> G) {
		System.out.println("\nItens que nao foram entregues: ");
		int lucroPerdido = 0;
		for(Item g : G) {
			System.out.println("	" + g);
			lucroPerdido += g.valor;
		}
		System.out.println("\nLucro Total Perdido: " + lucroPerdido);
	}
}
