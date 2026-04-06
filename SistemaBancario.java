import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class SistemaBancario {
    static Scanner sc = new Scanner(System.in);

    // Formatação em Real (Brasil)
    static Locale brasil = Locale.forLanguageTag("pt-BR");
    static NumberFormat moeda = NumberFormat.getCurrencyInstance(brasil);

    // Dados da conta
    static boolean contaAberta = false;
    static String nomeCliente = "";
    static double saldoInicial = 0;
    static double saldoAtual = 0;

    // Controle de operações
    static int qtdDepositos = 0;
    static double totalDepositos = 0;

    static int qtdSaques = 0;
    static double totalSaques = 0;

    static double totalJuros = 0;

    static double saldoMin = Double.MAX_VALUE;
    static double saldoMax = Double.MIN_VALUE;

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();
            opcao = lerInt();

            switch (opcao) {
                case 1:
                    abrirConta();
                    break;
                case 2:
                    if (contaAberta) deposito();
                    else System.out.println("Abra uma conta primeiro!");
                    break;
                case 3:
                    if (contaAberta) saque();
                    else System.out.println("Abra uma conta primeiro!");
                    break;
                case 4:
                    if (contaAberta) aplicarJuros();
                    else System.out.println("Abra uma conta primeiro!");
                    break;
                case 5:
                    if (contaAberta) simularEmprestimo();
                    else System.out.println("Abra uma conta primeiro!");
                    break;
                case 6:
                    if (contaAberta) extrato();
                    else System.out.println("Abra uma conta primeiro!");
                    break;
                case 7:
                    integrantes();
                    break;
                case 8:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 8);
    }

    public static void mostrarMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Abrir conta");
        System.out.println("2 - Depósito");
        System.out.println("3 - Saque");
        System.out.println("4 - Aplicar juros");
        System.out.println("5 - Simular empréstimo");
        System.out.println("6 - Extrato");
        System.out.println("7 - Integrantes");
        System.out.println("8 - Sair");
        System.out.print("Escolha: ");
    }

    public static void abrirConta() {
        if (contaAberta) {
            System.out.println("Conta já foi aberta!");
            return;
        }

        sc.nextLine();
        System.out.print("Nome do cliente: ");
        nomeCliente = sc.nextLine();

        System.out.print("Saldo inicial: ");
        saldoInicial = formatar(lerDouble());

        if (saldoInicial < 0) {
            System.out.println("Saldo inválido!");
            return;
        }

        saldoAtual = saldoInicial;
        saldoMin = saldoAtual;
        saldoMax = saldoAtual;
        contaAberta = true;

        System.out.println("Conta criada com sucesso!");
    }

    public static void deposito() {
        System.out.print("Valor do depósito: ");
        double valor = formatar(lerDouble());

        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return;
        }

        saldoAtual = formatar(saldoAtual + valor);
        qtdDepositos++;
        totalDepositos = formatar(totalDepositos + valor);

        atualizarMinMax();

        System.out.println("Depósito realizado! Novo saldo: " + formatarReal(saldoAtual));
    }

    public static void saque() {
        System.out.print("Valor do saque: ");
        int valor = lerInt();

        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return;
        }

        if (valor > saldoAtual) {
            System.out.println("Saldo insuficiente!");
            return;
        }

        int restante = valor;

        int n100 = restante / 100;
        restante %= 100;

        int n50 = restante / 50;
        restante %= 50;

        int n20 = restante / 20;
        restante %= 20;

        int n10 = restante / 10;
        restante %= 10;

        int n5 = restante / 5;
        restante %= 5;

        int n2 = restante / 2;
        restante %= 2;

        if (restante != 0) {
            System.out.println("Não é possível sacar este valor com as notas disponíveis!");
            return;
        }

        saldoAtual = formatar(saldoAtual - valor);
        qtdSaques++;
        totalSaques = formatar(totalSaques + valor);

        atualizarMinMax();

        System.out.println("Notas entregues:");
        if (n100 > 0) System.out.println("100: " + n100);
        if (n50 > 0) System.out.println("50: " + n50);
        if (n20 > 0) System.out.println("20: " + n20);
        if (n10 > 0) System.out.println("10: " + n10);
        if (n5 > 0) System.out.println("5: " + n5);
        if (n2 > 0) System.out.println("2: " + n2);

        System.out.println("Novo saldo: " + formatarReal(saldoAtual));
    }

    public static void aplicarJuros() {
        System.out.print("Taxa de juros (%): ");
        double taxa = lerDouble();

        if (taxa <= 0) {
            System.out.println("Taxa inválida!");
            return;
        }

        double juros = formatar(saldoAtual * (taxa / 100));
        saldoAtual = formatar(saldoAtual + juros);
        totalJuros = formatar(totalJuros + juros);

        atualizarMinMax();

        System.out.println("Juros: " + formatarReal(juros));
        System.out.println("Novo saldo: " + formatarReal(saldoAtual));
    }

    public static void simularEmprestimo() {
        System.out.print("Valor do empréstimo: ");
        double valor = lerDouble();

        System.out.print("Taxa mensal (%): ");
        double taxa = lerDouble();

        System.out.print("Parcelas: ");
        int parcelas = lerInt();

        if (valor <= 0 || taxa <= 0 || parcelas <= 0) {
            System.out.println("Dados inválidos!");
            return;
        }

        double juros = formatar(valor * (taxa / 100) * parcelas);
        double total = formatar(valor + juros);
        double parcela = formatar(total / parcelas);

        System.out.println("Parcela: " + formatarReal(parcela));
        System.out.println("Total de juros: " + formatarReal(juros));
        System.out.println("Total a pagar: " + formatarReal(total));
    }

    public static void extrato() {
        System.out.println("\n===== EXTRATO =====");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Saldo inicial: " + formatarReal(saldoInicial));
        System.out.println("Saldo atual: " + formatarReal(saldoAtual));
        System.out.println("Depósitos: " + qtdDepositos + " | Total: " + formatarReal(totalDepositos));
        System.out.println("Saques: " + qtdSaques + " | Total: " + formatarReal(totalSaques));
        System.out.println("Juros recebidos: " + formatarReal(totalJuros));
        System.out.println("Saldo mínimo: " + formatarReal(saldoMin));
        System.out.println("Saldo máximo: " + formatarReal(saldoMax));
    }

    public static void integrantes() {
        System.out.println("Integrantes do grupo:");
        System.out.println("Bruno Nunes");
        System.out.println("Leonardo Falcão");
    }

    public static void atualizarMinMax() {
        if (saldoAtual < saldoMin) saldoMin = saldoAtual;
        if (saldoAtual > saldoMax) saldoMax = saldoAtual;
    }

    // Funções auxiliares

    public static double formatar(double valor) {
        return Math.floor(valor * 100.0) / 100.0;
    }

    public static String formatarReal(double valor) {
        return moeda.format(valor);
    }

    public static int lerInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Entrada inválida! Digite um número inteiro: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public static double lerDouble() {
        while (!sc.hasNextDouble()) {
            System.out.print("Entrada inválida! Digite um número: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}