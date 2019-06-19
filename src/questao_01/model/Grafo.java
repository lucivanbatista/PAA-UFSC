package questao_01.model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	public List<Vertice> V;
	public List<Arco> A;
	
	public Grafo() {
		this.V = new ArrayList<>();
		this.A = new ArrayList<>();
	}
	
	public Grafo(List<Vertice> v, List<Arco> a) {
		this.V = v;
		this.A = a;
	}

	public void addVertice(Vertice v) {
		this.V.add(v);
	}

	public void addAresta(Arco a) {
		this.A.add(a);
	} 
	
	
	
}
