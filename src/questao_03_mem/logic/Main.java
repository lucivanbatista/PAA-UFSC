package questao_03_mem.logic;

import java.util.ArrayList;
import java.util.List;

import questao_03_mem.model.Caminhao;
import questao_03_mem.model.Item;

public class Main {

	public static List<Caminhao> criarCaminhoes() {
		Caminhao a = new Caminhao(1, 10);
		Caminhao b = new Caminhao(2, 15);
		Caminhao c = new Caminhao(3, 8);
		
		List<Caminhao> T = new ArrayList<>();
		T.add(a);
		T.add(b);
		T.add(c);
		
		return T;
	}
	
	public static List<Item> criarItens() {
		Item x = new Item("tenis", 0, 20);
		Item y = new Item("bola", 4, 0);
		Item z = new Item("camisa", 5, 10);
		Item k = new Item("geladeira", 100, 300);
		
		List<Item> G = new ArrayList<>();
		G.add(x);
		G.add(y);
		G.add(z);
		G.add(k);
		
		return G;
	}

	public static void main(String[] args) {
		List<Caminhao> T = criarCaminhoes();
		List<Item> G = criarItens();

		MochilaMultiplaProgDinAdaptado m = new MochilaMultiplaProgDinAdaptado();
		// O resultado sera armazenado nas estruturas T e G
		m.multiplaCarga(T, G);
		
		// Imprimira o resultado
		printInformacaoCaminhoesAtual(T);
		printItensNaoEntregues(G);
	}

	public static void printInformacaoCaminhoesAtual(List<Caminhao> T) {
		System.out.println("Informacoes sobre os caminhoes: ");
		for(Caminhao t : T) {
			System.out.println("	Caminhao " + t);
			System.out.println("		Itens no caminhao: ");
			for(Item g : t.itensNaCarga) {
				System.out.println("			" + g);
			}
		}		
	}
	
	public static void printItensNaoEntregues(List<Item> G) {
		System.out.println("\nItens que nao foram entregues: ");
		int lucroPerdido = 0;
		for(Item g : G) {
			System.out.println("	" + g);
			lucroPerdido += g.valor;
		}
		System.out.println("\nLucro Total Perdido: " + lucroPerdido);
	}

}
