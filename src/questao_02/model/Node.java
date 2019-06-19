package questao_02.model;

public class Node<T> implements Comparable<Node>{

	public int id;
	public T element;
	public Node ancestor;
	public boolean visit;
	
	public Node() {
		this.visit = false;
	}
	
	public Node(int id, T element){
		this.visit = false;
		this.element = element;
		this.id = id;
	}
	
	public int compareTo(Node v) {
		if (this.id < v.id) {
            return -1;
        }
        if (this.id > v.id) {
            return 1;
        }
        return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Integer)
			return this.id == (Integer) obj;
		return super.equals(obj);
	}
}