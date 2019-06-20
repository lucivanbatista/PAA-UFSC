package questao_02.model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	public List<Vertice> H;
	public List<Aresta> E;
	
	public Grafo() {
		this.H = new ArrayList<>();
		this.E = new ArrayList<>();
	}
	
	public Grafo(List<Vertice> h, List<Aresta> e) {
		this.H = h;
		this.E = e;
	}

	public void addVertice(Vertice h) {
		this.H.add(h);
	}

	public void addAresta(Aresta e) {
		this.E.add(e);
	} 
}
