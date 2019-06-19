package questao_02.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	public List<Node> V;
	public List<Edge> A;
	
	public Graph() {
		this.V = new ArrayList<>();
		this.A = new ArrayList<>();
	}
	
	public Graph(List<Node> v, List<Edge> a) {
		this.V = v;
		this.A = a;
	}

	public void addNode(Node v) {
		this.V.add(v);
	}

	public void addEdge(Edge a) {
		this.A.add(a);
	} 
	
	
	
}
