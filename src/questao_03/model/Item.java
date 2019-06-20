package questao_03.model;

public class Item implements Comparable<Item>{

	public String descricao;
	public int peso;
	public int valor;
	
	public Item() {
		
	}
	
	public Item(String descricao, int peso, int valor) {
		this.descricao = descricao;
		this.peso = peso;
		this.valor = valor;
	}	
	
	@Override
	public int compareTo(Item i) {
		if (this.valor < i.valor) {
            return -1;
        }
        if (this.valor > i.valor) {
            return 1;
        }
        return 0;
	}
	
	@Override
	public String toString() {
		return "descricao = " + this.descricao + "; peso = " + this.peso + "; valor = " + this.valor;
	}
}
