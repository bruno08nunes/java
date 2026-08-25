public class Pedido {
    private double valorTotal;
    private int totalItens;

    public Pedido() {
        valorTotal = 0;
        totalItens = 0;
    }

    public void adicionarItem(double valorUnitario, int qtd) {
        valorTotal += valorUnitario * qtd;
        totalItens += qtd;
    }

    public void imprimirResumoConta() {
        System.out.println("Valor total: R$ " + String.format("%.2f", valorTotal));
        System.out.println("Total itens: " + totalItens);
    }
}