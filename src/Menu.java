import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static ContaBancaria contaBancaria;
	static boolean hasConta = false;
	static String tipoDeConta;

	public static void main(String[] args) {
		int input = 0;

		do {
			System.out.println("Menu inicial");
			System.out.println("Escolha sua operação: ");

			if (hasConta == false)
				System.out.println("1. Abrir conta");
			else {
				System.out.println("2. Realizar depósito");
				System.out.println("3. Realizar saque");
				System.out.println("4. Aplicar juros");
				System.out.println("5. Extrato");
				System.out.println("6. Nome dos integrantes");
			}
			System.out.println("7. Sair");
			input = sc.nextInt();

			switch (input) {
			case 1:
				if (hasConta == false) {
					AbrirConta();
				}
				break;
			case 2:
				if (hasConta == true) {
					double valorDeposito = lerDouble("Digite o valor do deposito");
					
					if (valorDeposito > 0) {
						Operacao operacaoDeposito = new Operacao('D', valorDeposito);
						contaBancaria.movimenta(operacaoDeposito);
					}
					else
						System.out.println("Valor deve ser maior que 0");
				}
				break;
			case 3:
				if (hasConta == true) {
					if (tipoDeConta.equals("I")){
						System.out.println("Função não disponível em Conta Investimento");
						break;
					} else {
						double saque = lerDouble("Valor a ser sacado: ");

						if (saque > 0) {
							Operacao operacaoSaque = new Operacao('S', saque);

							contaBancaria.movimenta(operacaoSaque);

						} else {
							System.out.println("Valor solicitado deve ser maior que 0(zero)");
							break;
						}
					}
				}
				break;
			case 4:
				if (hasConta == true) {
					if (tipoDeConta.equals("C")) {
						System.out.println("Operação indisponível para Conta Corrente. Apenas disponível para Poupança e Investimento.");
					} else {
						double taxa = lerDouble("Informe a taxa de juros percentual (%): ");

						if (taxa > 0) {
							Operacao operacaoJuros = new Operacao('J', taxa);
							contaBancaria.movimenta(operacaoJuros);
						} else {
							System.out.println("A taxa de juros deve ser estritamente maior que zero.");
						}
					}
				}
				break;
			case 5:
				if (hasConta == true) {
					extrato();
				}
				break;
			case 6:
				if (hasConta == true) {
					System.out.println("Amanda Trevisol");
					System.out.println("Bernardo Kellermann");
					System.out.println("Bruno Nunes");
					System.out.println("Cristian Schmidt");
					System.out.println("Leonardo Falcão");
				}
				break;
			case 7:
				System.out.println("Programa Encerrado.");
				break;
			default:
				System.out.println("Valor Inválido");
				break;
			}
		} while (input != 7);

		sc.close();
	}

	public static double lerDouble(String mensagem) {
		while (true) {
			System.out.print(mensagem + " ");
			if (sc.hasNextDouble()) {
				double valor = sc.nextDouble();
				sc.nextLine();
				return valor;
			}
			System.out.println("Digite um valor numérico.");
			sc.nextLine();
		}
	}

	public static void AbrirConta() {
		System.out.println("Nome: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.println("CPF: ");
		String cpf = sc.next();
		System.out.println("Dia de Nascimento: ");
		int dia = sc.nextInt();
		System.out.println("Mês de Nascimento: ");
		int mes = sc.nextInt();
		System.out.println("Ano de Nascimento: ");
		int ano = sc.nextInt();

		System.out.println("Tipo de Conta (C, P ou I): ");
		tipoDeConta = sc.next();

		System.out.println("Saldo Inicial: ");
		double saldoInicial = sc.nextDouble();

		Data data = new Data(dia, mes, ano);
		Cliente cliente = new Cliente(nome, cpf, data);

		if (tipoDeConta.equals("C")) {
			System.out.println("Limite de Crédito: ");
			double limiteCredito = sc.nextDouble();

			contaBancaria = new ContaCorrente(cliente, saldoInicial, limiteCredito);
		} else if (tipoDeConta.equals("P")) {
			System.out.println("Data do Aniversário: ");
			int diaAniversario = sc.nextInt();

			contaBancaria = new ContaPoupanca(cliente, saldoInicial, diaAniversario);
		} else if (tipoDeConta.equals("I")) {
			System.out.println("Dia do Vencimento: ");
			int diaVencimento = sc.nextInt();
			System.out.println("Mês de Vencimento: ");
			int mesVencimento = sc.nextInt();
			System.out.println("Ano de Vencimento: ");
			int anoVencimento = sc.nextInt();

			Data vencimento = new Data(diaVencimento, mesVencimento, anoVencimento);
			contaBancaria = new ContaInvestimento(cliente, saldoInicial, vencimento);
		} else {
			return;
		}

		hasConta = true;
		System.out.println("Conta criada com sucesso!");
	}

	public static void extrato() {
		System.out.println("\n========== EXTRATO ==========");

		Cliente cliente = contaBancaria.getCliente();

		System.out.println("----- Dados do cliente -----");
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("Nascimento: " + cliente.getNascimento().dataBarra());

		System.out.println("\n----- Dados da conta -----");

		if (contaBancaria instanceof ContaCorrente) {
			ContaCorrente conta = (ContaCorrente) contaBancaria;
			System.out.println("Tipo: Conta Corrente");
			System.out.printf("Limite de crédito: R$ %.2f%n", conta.getLimiteCredito());

		} else if (contaBancaria instanceof ContaPoupanca) {
			ContaPoupanca conta = (ContaPoupanca) contaBancaria;
			System.out.println("Tipo: Conta Poupança");
			System.out.println("Dia de aniversário: " + conta.getDiaAniversario());

		} else if (contaBancaria instanceof ContaInvestimento) {
			ContaInvestimento conta = (ContaInvestimento) contaBancaria;
			System.out.println("Tipo: Conta Investimento");
			System.out.println("Vencimento: " + conta.getVencimento().dataBarra());
		}

		System.out.println("\n----- Saldos -----");
		System.out.printf("Saldo inicial: R$ %.2f%n", contaBancaria.getSaldoInicial());
		System.out.printf("Saldo atual: R$ %.2f%n", contaBancaria.getSaldoAtual());

		System.out.println("\n----- Depósitos -----");
		System.out.println("Quantidade: " + contaBancaria.getDepositos().getQuantidade());
		System.out.printf("Valor total: R$ %.2f%n", contaBancaria.getDepositos().getValorTotal());

		System.out.println("\n----- Saques -----");
		System.out.println("Quantidade: " + contaBancaria.getSaques().getQuantidade());
		System.out.printf("Valor total: R$ %.2f%n", contaBancaria.getSaques().getValorTotal());

		System.out.println("\n----- Juros -----");
		System.out.println("Quantidade: " + contaBancaria.getJuros().getQuantidade());
		System.out.printf("Valor total: R$ %.2f%n", contaBancaria.getJuros().getValorTotal());

		System.out.println("\n----- Saldos mínimo e máximo -----");
		System.out.printf("Saldo mínimo: R$ %.2f%n", contaBancaria.getSaldoMinimo());
		System.out.printf("Saldo máximo: R$ %.2f%n", contaBancaria.getSaldoMaximo());

		System.out.println("==============================\n");
	}
}
