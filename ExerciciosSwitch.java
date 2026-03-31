import java.util.Scanner;

public class ExerciciosSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // =========================
        // 1. Dia da semana
        // =========================
        System.out.print("1) Digite um número (1 a 7): ");
        int dia = sc.nextInt();

        switch (dia) {
            case 1:
                System.out.println("Domingo - Fim de semana");
                break;
            case 2:
                System.out.println("Segunda-feira - Dia útil");
                break;
            case 3:
                System.out.println("Terça-feira - Dia útil");
                break;
            case 4:
                System.out.println("Quarta-feira - Dia útil");
                break;
            case 5:
                System.out.println("Quinta-feira - Dia útil");
                break;
            case 6:
                System.out.println("Sexta-feira - Dia útil");
                break;
            case 7:
                System.out.println("Sábado - Fim de semana");
                break;
            default:
                System.out.println("Dia inválido");
        }

        // =========================
        // 2. Informações do mês
        // =========================
        System.out.print("\n2) Digite um número do mês (1 a 12): ");
        int mes = sc.nextInt();

        String nomeMes = "";
        int dias = 0;
        String semestre = "";
        String estacao = "";

        switch (mes) {
            case 1:
                nomeMes = "Janeiro"; dias = 31; estacao = "Verão"; break;
            case 2:
                nomeMes = "Fevereiro"; dias = 28; estacao = "Verão"; break;
            case 3:
                nomeMes = "Março"; dias = 31; estacao = "Outono"; break;
            case 4:
                nomeMes = "Abril"; dias = 30; estacao = "Outono"; break;
            case 5:
                nomeMes = "Maio"; dias = 31; estacao = "Outono"; break;
            case 6:
                nomeMes = "Junho"; dias = 30; estacao = "Inverno"; break;
            case 7:
                nomeMes = "Julho"; dias = 31; estacao = "Inverno"; break;
            case 8:
                nomeMes = "Agosto"; dias = 31; estacao = "Inverno"; break;
            case 9:
                nomeMes = "Setembro"; dias = 30; estacao = "Primavera"; break;
            case 10:
                nomeMes = "Outubro"; dias = 31; estacao = "Primavera"; break;
            case 11:
                nomeMes = "Novembro"; dias = 30; estacao = "Primavera"; break;
            case 12:
                nomeMes = "Dezembro"; dias = 31; estacao = "Verão"; break;
            default:
                System.out.println("Mês inválido");
        }

        if (mes >= 1 && mes <= 12) {
            semestre = (mes <= 6) ? "1º semestre" : "2º semestre";

            System.out.println("Mês: " + nomeMes);
            System.out.println("Semestre: " + semestre);
            System.out.println("Dias: " + dias);
            System.out.println("Estação: " + estacao);
        }

        // =========================
        // 3. Sexo por extenso
        // =========================
        System.out.print("\n3) Digite o sexo (M/F): ");
        char sexo = sc.next().charAt(0);

        switch (sexo) {
            case 'M':
            case 'm':
                System.out.println("Masculino");
                break;
            case 'F':
            case 'f':
                System.out.println("Feminino");
                break;
            default:
                System.out.println("Valor inválido");
        }

        // =========================
        // 4. Calculadora básica
        // =========================
        System.out.print("\n4) Digite uma expressão (ex: 2+3 ou 5.5*2): ");
        String expr = sc.next();

        char operador = ' ';
        double num1 = 0, num2 = 0;

        // Identifica operador
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                operador = ch;
                num1 = Double.parseDouble(expr.substring(0, i));
                num2 = Double.parseDouble(expr.substring(i + 1));
                break;
            }
        }

        double resultadoCalc = 0;

        switch (operador) {
            case '+':
                resultadoCalc = num1 + num2;
                break;
            case '-':
                resultadoCalc = num1 - num2;
                break;
            case '*':
                resultadoCalc = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    resultadoCalc = num1 / num2;
                } else {
                    System.out.println("Erro: divisão por zero");
                    break;
                }
                break;
            default:
                System.out.println("Operação inválida");
        }

        if (operador == '+' || operador == '-' || operador == '*' || operador == '/') {
            System.out.println("Resultado: " + resultadoCalc);
        }

        // =========================
        // 5. Cardápio lancheria
        // =========================
        System.out.print("\n5) Digite o código do item: ");
        int codigo = sc.nextInt();

        System.out.print("Digite a quantidade: ");
        int quantidade = sc.nextInt();

        String item = "";
        double preco = 0;

        switch (codigo) {
            case 100:
                item = "Cachorro quente"; preco = 5.50; break;
            case 101:
                item = "Bauru simples"; preco = 6.20; break;
            case 102:
                item = "Bauru com ovo"; preco = 7.80; break;
            case 103:
                item = "Hamburguer"; preco = 5.90; break;
            case 104:
                item = "Cheeseburguer"; preco = 6.80; break;
            case 105:
                item = "Refrigerante"; preco = 3.70; break;
            case 106:
                item = "Suco natural"; preco = 4.25; break;
            default:
                System.out.println("Código inválido");
        }

        if (preco > 0) {
            double total = preco * quantidade;
            System.out.println("Item: " + item);
            System.out.println("Total: R$ " + total);
        }

        sc.close();
    }
}