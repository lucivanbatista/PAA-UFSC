package questao_03.logic;

import java.util.ArrayList;
import java.util.List;

import questao_03.model.Caminhao;
import questao_03.model.Item;

public class Main {

	public static List<Caminhao> criarCaminhoes() {
//		Caminhao a = new Caminhao(1, 10);
//		Caminhao b = new Caminhao(2, 15);
//		Caminhao c = new Caminhao(3, 8);
		Caminhao d = new Caminhao(4, 3);
		
		List<Caminhao> T = new ArrayList<>();
//		T.add(a);
//		T.add(b);
//		T.add(c);
		T.add(d);
		
		return T;
	}
	
	public static List<Item> criarItens() {
		Item x = new Item("tenis", 2, 20);
		Item y = new Item("bola", 4, 3);
		Item z = new Item("camisa", 5, 10);
		
		List<Item> G = new ArrayList<>();
		G.add(x);
		G.add(y);
		G.add(z);
		
		return G;
	}
	
	public static void main(String[] args) {
		List<Caminhao> T = criarCaminhoes();
		List<Item> G = criarItens();
		
		MultiplasMochilas m = new MultiplasMochilas();
		m.problemaMochila(T, G);
		
}

}
