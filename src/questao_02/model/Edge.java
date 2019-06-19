package questao_02.model;

public class Edge<T> {

	public Node startNode;
	public Node endNode;
	public T element;
	
	
	public Edge(Node startNode, Node endNode, T element) {
		this.startNode = startNode;
		this.endNode = endNode;
		this.element = element;
	}	
	
}