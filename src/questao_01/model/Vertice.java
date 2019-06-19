package questao_01.model;

public class Vertice implements Comparable<Vertice>{

	public int id;
	public double estimativa;
	public double pedagio;
	public Vertice antecessor;
	public boolean visitar;
	
	public Vertice() {
		this.estimativa = 0;
	}
	
	public Vertice(int id, double pedagio){
		this.estimativa = 0;
		this.pedagio = pedagio;
		this.id = id;
	}
	
	public int compareTo(Vertice v) {
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