package questao_01.logic;

import java.util.ArrayList;
import java.util.List;

import questao_01.model.Arco;
import questao_01.model.Grafo;
import questao_01.model.Vertice;

public class BellmanFord {
	private static double infinity = Double.POSITIVE_INFINITY;

	public List<Vertice> bellmanFordAdaptado(Grafo G, Vertice s, Vertice t, double precoCombustivel, double autonomia) {
		inicializacao(G, s);

		for (int i = 1; i < G.V.size(); i++) { // Para o total de vertices - 1
			for (Arco a : G.A) { // Para cada arco
				Vertice u = a.verticeInicio;
				Vertice v = a.verticeDestino;
				double uEstimativa = u.estimativa;
				double vEstimativa = v.estimativa;
				// Calculo do custo do arco a para o vertice v
				double custoa = a.custo(precoCombustivel, autonomia);
				// Relaxamento
				if (vEstimativa > (uEstimativa + custoa)) {
					v.estimativa = uEstimativa + custoa;
					v.antecessor = u;
				}
			} 
		}
		// Retorno do caminho minimo ate o vertice de destino t
		return caminhoMinimo(G.V, t);
	}

	// Inicializacao dos atributos
	public void inicializacao(Grafo G, Vertice origem) {
		for (Vertice v : G.V) {
			v.estimativa = infinity;
			v.antecessor = null;
		}
		origem.estimativa = 0.0;
	}

	// Retorna o Caminho Minimo
	public List<Vertice> caminhoMinimo(List<Vertice> V, Vertice t) {
		List<Vertice> caminhoMinimo = new ArrayList<>();
		if (t.estimativa == infinity) {
			return null;
		} else {
			return getAntecessores(caminhoMinimo, t);
		}
	}

	// Metodo recursivo para adicionar o antecessor a uma lista
	public List<Vertice> getAntecessores(List<Vertice> caminhoMinimo, Vertice v) {
		if (v != null) {
			getAntecessores(caminhoMinimo, v.antecessor);
			caminhoMinimo.add(v);
			return caminhoMinimo;
		}
		return null;
	}
}
