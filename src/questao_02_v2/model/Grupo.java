package questao_02_v2.model;

import java.util.HashSet;
import java.util.Set;

public class Grupo {
	
	public int id;
	public Set<Vertice> h = new HashSet<Vertice>();

	public Grupo(int id) {
		this.id = id;
	}
	
	public Grupo(int id, Vertice h) {
		this(id);
		add(h);
	}

	public void add(Vertice h) {
		this.h.add(h);
	}
	
	public void union(Grupo g) {
		for (Vertice v : g.h) {
			v.grupo = this;
			this.h.add(v);
		}
	}

}
