package questao_02.model;

import questao_02.model.Vertice;

public class Aresta implements Comparable<Aresta>{

	public Vertice verticeA;
	public Vertice verticeB;
	public double peso;
	
	public Aresta(Vertice verticeA, Vertice verticeB, double peso) {
		this.verticeA = verticeA;
		this.verticeB = verticeB;
		this.peso = peso;
	}
	
	@Override
	public int compareTo(Aresta e) {
		if (this.peso < e.peso) {
            return -1;
        }
        if (this.peso > e.peso) {
            return 1;
        }
        return 0;
	}
}