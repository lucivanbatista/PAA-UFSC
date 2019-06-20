package questao_02_v2.model;

public class Vertice{

	public int id;
	public Grupo grupo;
	
	public Vertice() {
		
	}
	
	public Vertice(int id){
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.valueOf(id);
	}
	
}