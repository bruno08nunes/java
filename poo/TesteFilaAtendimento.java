public class TesteFilaAtendimento {
    public static void main(String[] args) {
        FilaAtendimento fila = new FilaAtendimento();

        fila.adicionarCliente();
        fila.adicionarCliente();

        fila.imprimeTamanhoFila();

        fila.atenderCliente();

        fila.imprimeTamanhoFila();

        fila.adicionarCliente();
        fila.atenderCliente();
        fila.adicionarCliente();

        System.out.println("A fila está vazia? " + fila.verificarFilaVazia());
    }
}