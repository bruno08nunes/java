
public class ContaBancaria {
	public ContaBancaria(Cliente cliente, double saldoInicial) {
		this.cliente = cliente;
		this.saldoInicial = saldoInicial;
		this.saldoAtual = saldoInicial;
		this.saldoMinimo = saldoInicial;
		this.saldoMaximo = saldoInicial;
		this.depositos = new Movimentacao();
		this.saques = new Movimentacao();
		this.juros = new Movimentacao();
	}

	private Cliente cliente;
	private double saldoInicial;
	private double saldoAtual;
	private double saldoMinimo;
	private double saldoMaximo;
	private Movimentacao depositos;
	private Movimentacao saques;
	private Movimentacao juros;

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public double getSaldoMinimo() {
		return saldoMinimo;
	}

	public double getSaldoMaximo() {
		return saldoMaximo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Movimentacao getDepositos() {
		return depositos;
	}

	public Movimentacao getSaques() {
		return saques;
	}

	public Movimentacao getJuros() {
		return juros;
	}

	public void movimenta(Operacao op) {
		if (op.getTipo() == 'D') {
			double valorDeposito = op.getValor();
			this.saldoAtual += valorDeposito;
			this.depositos.addQuantidade();
			this.depositos.addValorTotal(valorDeposito);
			atualizaSaldos();
			System.out.printf("Novo saldo: R$ %.2f\n", this.saldoAtual);
		} 
		else if (op.getTipo() == 'S') {
			double valorSaque = op.getValor();

			int valorRestante = (int) valorSaque;
			int notas100 = valorRestante / 100;
			valorRestante %= 100;
			int notas50 = valorRestante / 50;
			valorRestante %= 50;
			int notas20 = valorRestante / 20;
			valorRestante %= 20;
			int notas10 = valorRestante / 10;
			valorRestante %= 10;
			int notas5 = valorRestante / 5;
			valorRestante %= 5;
			int notas2 = valorRestante / 2;
			valorRestante %= 2;

			if (valorSaque != Math.floor(valorSaque)) {
				System.out.println("Saque recusado! O caixa possui somente notas inteiras.");
				return;
			}

			if (valorRestante > 0) {
				int[] notas = new int[6];
				if (!encontraNotas((int) valorSaque, new int[] {100, 50, 20, 10, 5, 2}, notas, 0)) {
					System.out.println("Saque recusado! Não é possível formar o valor solicitado com as notas disponíveis.");
					return;
				}
				notas100 = notas[0];
				notas50 = notas[1];
				notas20 = notas[2];
				notas10 = notas[3];
				notas5 = notas[4];
				notas2 = notas[5];
			}

			this.saldoAtual -= valorSaque;
			this.saques.addQuantidade();
			this.saques.addValorTotal(valorSaque);
			atualizaSaldos();

			System.out.println("===Notas=Liberadas===");
			if (notas100 > 0)
				System.out.printf("R$100: %d%n", notas100);
			if (notas50 > 0)
				System.out.printf("R$50: %d%n", notas50);
			if (notas20 > 0)
				System.out.printf("R$20: %d%n", notas20);
			if (notas10 > 0)
				System.out.printf("R$10: %d%n", notas10);
			if (notas5 > 0)
				System.out.printf("R$5: %d%n", notas5);
			if (notas2 > 0)
				System.out.printf("R$2: %d%n", notas2);

			System.out.printf("Valor Sacado: R$ %.2f%n", valorSaque);
			System.out.printf("Saldo Restante na Conta: R$ %.2f%n", this.saldoAtual);
		} 
		else if (op.getTipo() == 'J') {
			double taxa = op.getValor();
			double valorJuros = this.saldoAtual * (taxa / 100.0);
			this.saldoAtual += valorJuros;
			this.juros.addQuantidade();
			this.juros.addValorTotal(valorJuros);
			atualizaSaldos();

			System.out.printf("Juros de %.2f%% aplicados com sucesso! (R$ %.2f adicionados)%n", taxa, valorJuros);
			System.out.printf("Novo Saldo: R$ %.2f%n", this.saldoAtual);
		}

	}

	private void atualizaSaldos() {
		if (saldoAtual < saldoMinimo)
			saldoMinimo = saldoAtual;
		if (saldoAtual > saldoMaximo)
			saldoMaximo = saldoAtual;
	}

	private boolean encontraNotas(int valor, int[] notasDisponiveis, int[] quantidade, int posicao) {
		if (valor == 0)
			return true;
		if (posicao == notasDisponiveis.length)
			return false;

		int nota = notasDisponiveis[posicao];
		for (int qtd = valor / nota; qtd >= 0; qtd--) {
			quantidade[posicao] = qtd;
			if (encontraNotas(valor - qtd * nota, notasDisponiveis, quantidade, posicao + 1))
				return true;
		}

		quantidade[posicao] = 0;
		return false;
	}
}
