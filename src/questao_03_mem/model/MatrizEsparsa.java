package questao_03_mem.model;

import java.util.HashMap;

/**
 * Nessa Implementacao de Matriz Esparsa (ixj), utilizamos Generics do Java para 
 * permitir que os indices <I, J> e o valor V sejam de qualquer tipo de dados.
 * A Tupla representa os indices i e j na matriz de duas dimensoes.
 * Esta classe define um valor default que nunca e armazenado, na pratica
 * funciona como um valor de inicializacao e nunca sera armazenado na memoria.  
 * 
 * @author Tarlis Portela 
 * @author Lucivan Batista
 *
 * @param <I> Classe de objeto do indice "i"
 * @param <J> Classe de objeto do indice "j"
 * @param <V> Classe de objeto valor (das celulas da matriz)
 */
public class MatrizEsparsa<I,J,V> extends HashMap<Tupla<I,J>, V> {

	private static final long serialVersionUID = -232567318161202729L;
	private V defaultValue = null;
	
	public MatrizEsparsa(V defaultValue) {
		this.defaultValue = defaultValue;
	}

	public V get(I i, J j) {
		Tupla<I,J> t = new Tupla<I,J>(i,j);
		if (!super.containsKey(t))
			return this.defaultValue;
		return super.get(t);
	}
	
	public V set(I i, J j, V v) {
		if (v != null && !v.equals(this.defaultValue)) {	
			Tupla<I,J> t = new Tupla<I,J>(i,j);
			return super.put(t, v);
		}
		return v;
	}
	
	public boolean isEmpty(I i, J j) {
		return super.containsKey(new Tupla<I,J>(i,j));
	}
	
	public V getDefaultValue() {
		return defaultValue;
	}
	
	public void setDefaultValue(V defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void print() {
		for (Entry<Tupla<I,J>, V> e : this.entrySet()) {
			System.out.println("I: " + e.getKey().lin + " // " + e.getKey().col+ " >> Val: " + e.getValue());
		}
	}

}
