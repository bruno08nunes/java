
public class Movimentacao {
	private int quantidade;
	private double valorTotal;
	
	public void addQuantidade() {
		this.quantidade++;
	}
	public void addValorTotal(double valor) {
		this.valorTotal += valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getValorTotal() {
		return valorTotal;
	}

}
