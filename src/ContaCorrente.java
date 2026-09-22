
public class ContaCorrente extends ContaBancaria {
	public ContaCorrente(Cliente cliente, double saldoInicial, double limiteCredito) {
		super(cliente, saldoInicial);
		this.limiteCredito = limiteCredito;
	}

	private double limiteCredito;

	public void movimenta(Operacao op) {
		if (op.getTipo() == 'S') {
            double saldoDisponivelTotal = getSaldoAtual() + this.limiteCredito;

            if (op.getValor() <= saldoDisponivelTotal) {
                super.movimenta(op);
            } else {
                System.out.printf("Saque recusado! Excede o saldo + limite de crédito (Disponível: R$ %.2f)%n", saldoDisponivelTotal);
            }
        } else {
            super.movimenta(op);
        }
	}

    public double getLimiteCredito() {
		return limiteCredito;
	}

}
