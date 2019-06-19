package questao_01_bfs.model;

public class Arco {

	public Vertice verticeInicio;
	public Vertice verticeDestino;
	public double custo;
	
	
	public Arco(Vertice verticeInicio, Vertice verticeDestino, double custo) {
		this.verticeInicio = verticeInicio;
		this.verticeDestino = verticeDestino;
		this.custo = custo;
	}
	
	public double custo(double preco, double autonomia) {
		return ((this.custo / autonomia) *  preco) + this.verticeDestino.pedagio;
	}
}