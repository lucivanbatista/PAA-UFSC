package questao_03.model;

public class Caminhao implements Comparable<Caminhao>{

	public int id;
	public double cargaMaxima;
	
	public Caminhao() {
		
	}
	
	public Caminhao(int id, double cargaMaxima) {
		this.id = id;
		this.cargaMaxima = cargaMaxima;
	}
	
	@Override
	public int compareTo(Caminhao c) {
		if (this.cargaMaxima < c.cargaMaxima) {
            return -1;
        }
        if (this.cargaMaxima > c.cargaMaxima) {
            return 1;
        }
        return 0;
	}
	
	@Override
	public String toString() {
		return "id = " + this.id + "; cargaMaxima = " + this.cargaMaxima;
	}
}
