package questao_03.logic;

import java.util.ArrayList;
import java.util.List;

import questao_03.model.Caminhao;
import questao_03.model.Item;

public class Main {

	public static List<Caminhao> criarCaminhoes() {
		Caminhao a = new Caminhao(1, 10);
		Caminhao b = new Caminhao(2, 15);
		Caminhao c = new Caminhao(3, 8);
		Caminhao d = new Caminhao(4, 100);
		
		List<Caminhao> T = new ArrayList<>();
		T.add(a);
		T.add(b);
		T.add(c);
		T.add(d);
		
		return T;
	}
	
	public static List<Item> criarItens() {
		Item t = new Item("Bicicleta", 9, 100);
		Item u = new Item("Livro", 2, 0);
		Item v = new Item("Churrasqueira", 200, 1000);
		Item w = new Item("Geladeira", 100, 600);
		Item x = new Item("Tenis", 2, 20);
		Item y = new Item("Bola", 4, 3);
		Item z = new Item("Camisa", 5, 10);
		
		
		List<Item> G = new ArrayList<>();
		G.add(t);
		G.add(u);
		G.add(v);
		G.add(w);
		G.add(x);
		G.add(y);
		G.add(z);
		
		return G;
	}
	
	public static void main(String[] args) {
		List<Caminhao> T = criarCaminhoes();
		List<Item> G = criarItens();
		
		// Execucao do Algoritmo
		MochilaMultiplaGulosaAdaptado m = new MochilaMultiplaGulosaAdaptado();
		m.mochilaMultiplaAdaptado(T, G);
		
		// Apos a execucao do Algoritmo
		m.getInformacaoCaminhoesAtual(T);
		m.getItensNaoEntregues(G);
	}

}
