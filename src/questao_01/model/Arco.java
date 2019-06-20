package questao_01.model;

public class Arco {

	public Vertice verticeInicio;
	public Vertice verticeDestino;
	public double peso;
	
	
	public Arco(Vertice verticeInicio, Vertice verticeDestino, double peso) {
		this.verticeInicio = verticeInicio;
		this.verticeDestino = verticeDestino;
		this.peso = peso;
	}
	
	public double custo(double preco, double autonomia) {
		return ((this.peso / autonomia) *  preco) + this.verticeDestino.pedagio;
	}
}