
public class ContaInvestimento extends ContaBancaria {
	public ContaInvestimento(Cliente cliente, double saldoInicial, Data vencimento) {
		super(cliente, saldoInicial);
		this.vencimento = vencimento;
	}

	private Data vencimento;

	public void movimenta(Operacao op) {
		
		if (op.getTipo() == 'D') {
			super.movimenta(op);
		} else if (op.getTipo() == 'S') {
			System.out.println("Saque recusado! Operação disponível apenas para conta-corrente e poupança.");
		} else if (op.getTipo() == 'J') {
			super.movimenta(op);
		}
	}

	public Data getVencimento() {
		return vencimento;
	}
}
