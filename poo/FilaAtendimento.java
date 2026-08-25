public class FilaAtendimento {
    private int qtdClientes;

    public FilaAtendimento() {
        qtdClientes = 0;
    }

    public void adicionarCliente() {
        qtdClientes++;
    }

    public void atenderCliente() {
        qtdClientes--;
    }

    public int getQtdClientes() {
        return qtdClientes;
    }

    public boolean verificarFilaVazia() {
        return qtdClientes == 0;
    }

    public void imprimeTamanhoFila() {
        System.out.println("Quantidade de clientes na fila: " + qtdClientes);
    }
}