public class TestePedido {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        pedido.adicionarItem(5.40, 4);
        pedido.imprimirResumoConta();

        System.out.println();

        pedido.adicionarItem(19.30, 1);
        pedido.imprimirResumoConta();

        System.out.println();

        pedido.adicionarItem(12.10, 3);
        pedido.imprimirResumoConta();
    }
}