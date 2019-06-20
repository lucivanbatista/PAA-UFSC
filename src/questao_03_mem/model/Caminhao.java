package questao_03_mem.model;

import java.util.ArrayList;
import java.util.List;

public class Caminhao implements Comparable<Caminhao>{

	public int id;
	public double cargaMaxima;
	public double capacidadeAtual; // Peso que ainda cabe neste caminhao
	public List<Item> itensNaCarga;
	public int valorItensNaCarga;
	
	public Caminhao(int id, double cargaMaxima) {
		this.id = id;
		this.cargaMaxima = cargaMaxima;
		this.itensNaCarga = new ArrayList<>();
		this.valorItensNaCarga = 0;
		this.capacidadeAtual = cargaMaxima;
	}
	
	public void addItem(Item i) {
		this.itensNaCarga.add(i);
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
		return "id = " + this.id + "; cargaMaxima = " + this.cargaMaxima + "; capacidade restante: " + this.capacidadeAtual + "; valor dos itens: " + this.valorItensNaCarga;
	}
}