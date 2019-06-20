package questao_03.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import questao_03.model.Caminhao;
import questao_03.model.Item;

public class MultiplasMochilas {

	public MultiplasMochilas() {
		
	}
	
	public List<Item> problemaMochila(List<Caminhao> T, List<Item> G) {
		// Ordenar os caminhoes de T baseado nas suas cargas
		Collections.sort(T);
		// Ordenar os itens de G baseado nos seus valores (lucro)
		Collections.sort(G);
		
		List<Item> melhorCaso = new ArrayList<>();
		
		int n = G.size();
		// Se não houver itens...
		if(n == 0){
	        return melhorCaso; // retorne nada
		}
		
	    // PesoLivre é referente a capacidade maxima do caminhao atual
	    // OBSERVAOCAO ESTOU PEGANDO SÓ O 1º PARA TESTE
	    double pesoLivre = T.get(0).cargaMaxima;
	    int melhorValor = 0;
	    
	    for(Item g : G){
	        if(g.peso <= pesoLivre){
	            pesoLivre -= g.peso;
	            melhorValor += g.valor;
	            melhorCaso.add(g);
	        }
	    }
	    
	    System.out.println("peso melhor para este caminhao: " + melhorValor);
	    int sum = 0;
	    for(Item g : melhorCaso) {
	    	System.out.println(g);
	    	sum += g.valor;
	    }
	    // esse valor tem que ser igual ao primeiro!
	    System.out.println("peso melhor na lsita para este caminhao: " + sum);
	    return melhorCaso;
	}
}
