package questao_03_mem.model;

/**
 * Clase para representar uma tupla de dois elementos genéricos.
 * 
 * @author Tarlis Portela 
 * @author Lucivan Batista
 * 
 */
public class Tupla<I,J> {
	
	public I lin;
	public J col;
	
	public Tupla(I i, J j) {
		this.lin = i;
		this.col = j;
	}
	
	@Override
	public int hashCode() {
		return 1; // Pra forçar o HashMap usar o equals.
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Tupla && this.lin != null && this.col != null) {
			return this.lin.equals(((Tupla<?, ?>) obj).lin) &&
				   this.col.equals(((Tupla<?, ?>) obj).col);
		}
		return super.equals(obj);
	}
	
}