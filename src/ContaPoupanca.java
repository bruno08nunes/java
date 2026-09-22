
public class ContaPoupanca extends ContaBancaria {
	public ContaPoupanca(Cliente cliente, double saldoInicial, int diaAniversario) {
		super(cliente, saldoInicial);
		this.diaAniversario = diaAniversario;
	}

	private int diaAniversario;

	public void movimenta(Operacao op) {
		if (op.getTipo() == 'D') {
			super.movimenta(op);
		} else if (op.getTipo() == 'S') {
			if (op.getValor() <= getSaldoAtual()) {
				super.movimenta(op);
			} else {
				System.out.println("Saque recusado! Poupança não possui limite de crédito.");
			}
		} else if (op.getTipo() == 'J') {
			super.movimenta(op);
		}
	}

	public int getDiaAniversario() {
		return diaAniversario;
	}
}
