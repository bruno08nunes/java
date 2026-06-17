import java.io.*;
import java.util.Scanner;

public class Main {
    static double valorIngresso;
    static int linhas, colunas;

    static int[][] idades;
    static char[][] sexos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor do ingresso: ");
        valorIngresso = sc.nextDouble();

        do {
            System.out.print("Quantidade de fileiras (5 a 25): ");
            linhas = sc.nextInt();
        } while (linhas < 5 || linhas > 25);

        do {
            System.out.print("Assentos por fileira (5 a 25): ");
            colunas = sc.nextInt();
        } while (colunas < 5 || colunas > 25);

        idades = new int[linhas][colunas];
        sexos = new char[linhas][colunas];

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Carregar dados");
            System.out.println("2. Consultar assento");
            System.out.println("3. Reservar n assentos");
            System.out.println("4. Liberar n assentos");
            System.out.println("5. Visualizar mapa");
            System.out.println("6. Relatorios");
            System.out.println("7. Salvar dados");
            System.out.println("8. Integrantes");
            System.out.println("9. Sair");
            System.out.print("Opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    carregarDados(sc);
                    break;

                case 2:
                    consultarAssento(sc);
                    break;

                case 3:
                    reservarAssentos(sc);
                    break;

                case 4:
                    liberarAssentos(sc);
                    break;

                case 5:
                    visualizarMapa();
                    break;

                case 6:
                    relatorios();
                    break;

                case 7:
                    salvarDados(sc);
                    break;

                case 8:
                    integrantes();
                    break;

                case 9:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

        } while (opcao != 9);

        sc.close();
    }

    static int[] converterAssento(String assento) {
        assento = assento.toUpperCase();
        int linha = assento.charAt(0) - 'A';
        int coluna = Integer.parseInt(assento.substring(1)) - 1;
        return new int[] { linha, coluna };
    }

    static boolean valido(int l, int c) {
        return l >= 0 && l < linhas && c >= 0 && c < colunas;
    }

    static boolean reservado(int l, int c) {
        return idades[l][c] > 0;
    }

    static void carregarDados(Scanner sc) {
        try {
            System.out.print("Arquivo: ");
            String nome = sc.nextLine();

            BufferedReader br = new BufferedReader(new FileReader(nome));

            br.readLine();

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] p = linha.split(",");

                int[] pos = converterAssento(p[0]);

                int l = pos[0];
                int c = pos[1];

                if (valido(l, c)) {
                    sexos[l][c] = p[1].charAt(0);
                    idades[l][c] = Integer.parseInt(p[2]);
                }
            }

            br.close();
            System.out.println("Dados carregados.");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static double valorPago(int idade) {
        if (idade <= 17 || idade >= 60) {
            return valorIngresso / 2.0;
        }
        return valorIngresso;
    }

    static void consultarAssento(Scanner sc) {
        System.out.print("Assento: ");
        String assento = sc.nextLine();

        int[] pos = converterAssento(assento);

        if (!valido(pos[0], pos[1])) {
            System.out.println("Assento invalido.");
            return;
        }

        if (!reservado(pos[0], pos[1])) {
            System.out.println("Assento livre.");
        } else {
            int idade = idades[pos[0]][pos[1]];
            char sexo = sexos[pos[0]][pos[1]];

            System.out.printf("Reservado | Sexo: %c | Idade: %d | Valor: R$ %.2f%n",
                    sexo, idade, valorPago(idade));
        }
    }

    static void reservarAssentos(Scanner sc) {
        System.out.print("Assento inicial: ");
        String assento = sc.nextLine();

        System.out.print("Quantidade: ");
        int n = sc.nextInt();
        sc.nextLine();

        int[] pos = converterAssento(assento);

        int l = pos[0];
        int c = pos[1];

        if (!valido(l, c) || c + n > colunas) {
            System.out.println("Nao ha espaco suficiente.");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (reservado(l, c + i)) {
                System.out.println("Existe assento ocupado. Operacao cancelada.");
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Reserva do assento " + (char) ('A' + l) + (c + i + 1));

            System.out.print("Sexo (M/F): ");
            sexos[l][c + i] = Character.toUpperCase(sc.nextLine().charAt(0));

            System.out.print("Idade: ");
            idades[l][c + i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println("Reservas realizadas.");
    }

    static void liberarAssentos(Scanner sc) {
        System.out.print("Assento inicial: ");
        String assento = sc.nextLine();

        System.out.print("Quantidade: ");
        int n = sc.nextInt();
        sc.nextLine();

        int[] pos = converterAssento(assento);

        int l = pos[0];
        int c = pos[1];

        if (!valido(l, c) || c + n > colunas) {
            System.out.println("Faixa invalida.");
            return;
        }

        for (int i = 0; i < n; i++) {
            idades[l][c + i] = 0;
            sexos[l][c + i] = '\0';
        }

        System.out.println("Reservas liberadas.");
    }

    static void visualizarMapa() {
        System.out.print("   ");
        for (int c = 1; c <= colunas; c++) {
            System.out.printf("%02d ", c);
        }
        System.out.println();

        for (int l = 0; l < linhas; l++) {
            System.out.print((char) ('A' + l) + "  ");

            for (int c = 0; c < colunas; c++) {
                System.out.print((reservado(l, c) ? "X" : "·") + "  ");
            }

            System.out.println();
        }
    }

    static void relatorios() {
        relatorioA();
        relatorioB();
        relatorioC();
        relatorioD();
    }

    static void relatorioA() {
        System.out.println("\n--- LISTAGEM ---");
        System.out.printf("%-8s %-6s %-6s %-10s%n", "Assento", "Sexo", "Idade", "Valor");

        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {
                if (reservado(l, c)) {
                    System.out.printf("%-8s %-6c %-6d R$ %-10.2f%n",
                            "" + (char) ('A' + l) + (c + 1),
                            sexos[l][c],
                            idades[l][c],
                            valorPago(idades[l][c]));
                }
            }
        }
    }

    static void relatorioB() {
        int livres = 0, reservados = 0;

        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {
                if (reservado(l, c))
                    reservados++;
                else
                    livres++;
            }
        }

        System.out.println("\nTotal assentos: " + (livres + reservados));
        System.out.println("Reservados: " + reservados);
        System.out.println("Livres: " + livres);
    }

    static void relatorioC() {
        int m = 0, f = 0;

        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {
                if (reservado(l, c)) {
                    if (sexos[l][c] == 'M')
                        m++;
                    else if (sexos[l][c] == 'F')
                        f++;
                }
            }
        }

        System.out.println("\nMasculino: " + m);
        System.out.println("Feminino: " + f);
    }

    static String barra(double percentual) {
        int tamanho = 20;
        int cheios = (int) Math.round(percentual * tamanho / 100.0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cheios; i++)
            sb.append("=");
        for (int i = cheios; i < tamanho; i++)
            sb.append("-");

        return sb.toString();
    }

    static void relatorioD() {

        int meiaMenor = 0;
        int inteira = 0;
        int meiaIdoso = 0;

        double valorMenor = 0;
        double valorInteira = 0;
        double valorIdoso = 0;

        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {

                if (!reservado(l, c))
                    continue;

                int idade = idades[l][c];

                if (idade <= 17) {
                    meiaMenor++;
                    valorMenor += valorIngresso / 2;
                } else if (idade <= 59) {
                    inteira++;
                    valorInteira += valorIngresso;
                } else {
                    meiaIdoso++;
                    valorIdoso += valorIngresso / 2;
                }
            }
        }

        int total = meiaMenor + inteira + meiaIdoso;
        double receita = valorMenor + valorInteira + valorIdoso;

        if (total == 0) {
            System.out.println("\nNenhuma reserva.");
            return;
        }

        System.out.println("\n--- GRAFICO ---");

        double p1 = meiaMenor * 100.0 / total;
        double p2 = inteira * 100.0 / total;
        double p3 = meiaIdoso * 100.0 / total;

        System.out.printf("Meia menor: %d - %.1f%% |%s| R$ %.2f%n",
                meiaMenor, p1, barra(p1), valorMenor);

        System.out.printf("Inteira    : %d - %.1f%% |%s| R$ %.2f%n",
                inteira, p2, barra(p2), valorInteira);

        System.out.printf("Meia idoso : %d - %.1f%% |%s| R$ %.2f%n",
                meiaIdoso, p3, barra(p3), valorIdoso);

        System.out.printf("Total      : %d - 100.0%% |%s| R$ %.2f%n",
                total, barra(100), receita);
    }

    static void salvarDados(Scanner sc) {
        try {
            System.out.print("Arquivo: ");
            String nome = sc.nextLine();

            PrintWriter pw = new PrintWriter(nome);

            pw.println("Assento,Sexo,Idade");

            for (int l = 0; l < linhas; l++) {
                for (int c = 0; c < colunas; c++) {
                    if (reservado(l, c)) {
                        pw.println("" + (char) ('A' + l) + (c + 1)
                                + "," + sexos[l][c]
                                + "," + idades[l][c]);
                    }
                }
            }

            pw.close();
            System.out.println("Dados salvos.");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void integrantes() {
        System.out.println("Bruno Nunes");
        System.out.println("Leonardo Falcão");
    }
}
