import java.util.Scanner;

public class ExerciciosVetores {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // exercicio1();
        // exercicio2();
        // exercicio3();
        // exercicio4();
        // exercicio5();
        // exercicio6();
        // exercicio7();
        // exercicio8();
        exercicio9();
    }

    // 1
    public static void exercicio1() {
        int[] vetor = new int[6];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (i + 1) * 2;
        }

        for (int v : vetor) {
            System.out.print(v + " ");
        }
        System.out.println("\n");
    }

    // 2
    public static void exercicio2() {
        double[] vetor = new double[10];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = -1.5 + (0.5 * i);
        }

        for (double v : vetor) {
            System.out.print(v + " ");
        }
        System.out.println("\n");
    }

    // 3
    public static void exercicio3() {
        double[] vetor = new double[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextDouble();
        }

        double menor = vetor[0], maior = vetor[0];
        int iMenor = 0, iMaior = 0;

        for (int i = 1; i < 10; i++) {
            if (vetor[i] < menor) {
                menor = vetor[i];
                iMenor = i;
            }
            if (vetor[i] > maior) {
                maior = vetor[i];
                iMaior = i;
            }
        }

        System.out.println("Menor valor: " + menor + " no indice " + iMenor);
        System.out.println("Maior valor: " + maior + " no indice " + iMaior);
        System.out.println("Diferença: " + (maior - menor) + "\n");
    }

    // 4
    public static void exercicio4() {
        int[] vetor = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextInt();
        }

        for (int i = 9; i >= 0; i--) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("\n");
    }

    // 5
    public static void exercicio5() {
        int[] v1 = new int[10];
        int[] v2 = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número: ");
            v1[i] = sc.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            v2[i] = v1[9 - i];
        }

        System.out.println("Vetor original:");
        for (int v : v1) System.out.print(v + " ");

        System.out.println("\nVetor invertido:");
        for (int v : v2) System.out.print(v + " ");

        System.out.println("\n");
    }

    // 6
    public static void exercicio6() {
        int[] vetor = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextInt();
        }

        for (int i = 0; i < vetor.length / 2; i++) {
            int aux = vetor[i];
            vetor[i] = vetor[vetor.length - 1 - i];
            vetor[vetor.length - 1 - i] = aux;
        }

        for (int v : vetor) System.out.print(v + " ");
        System.out.println("\n");
    }

    // 7
    public static void exercicio7() {
        int[] vetor = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextInt();
        }

        System.out.print("Número para buscar: ");
        int busca = sc.nextInt();

        boolean encontrou = false;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == busca) {
                System.out.println("Encontrado na posição: " + i);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println(busca + " - NÃO ENCONTRADO");
        }

        System.out.println();
    }

    // 8
    public static void exercicio8() {
        double[] A = new double[5];
        double[] B = new double[5];

        System.out.println("Vetor A:");
        for (int i = 0; i < 5; i++) {
            A[i] = sc.nextDouble();
        }

        System.out.println("Vetor B:");
        for (int i = 0; i < 5; i++) {
            B[i] = sc.nextDouble();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Indice " + i + ":");
            System.out.println("Soma: " + (A[i] + B[i]));
            System.out.println("Subtração: " + (A[i] - B[i]));
            System.out.println("Multiplicação: " + (A[i] * B[i]));
            System.out.println("Divisão: " + (B[i] != 0 ? A[i] / B[i] : "Divisão por zero"));
        }
        System.out.println();
    }

    // 9 (Desafio)
    public static void exercicio9() {
        System.out.print("Tamanho da turma: ");
        int n = sc.nextInt();

        double[] notas = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nota: ");
            notas[i] = sc.nextDouble();
        }

        double menor = notas[0], maior = notas[0], soma = 0;
        int countMenor = 0, countMaior = 0;

        for (double nota : notas) {
            soma += nota;

            if (nota < menor) {
                menor = nota;
                countMenor = 1;
            } else if (nota == menor) {
                countMenor++;
            }

            if (nota > maior) {
                maior = nota;
                countMaior = 1;
            } else if (nota == maior) {
                countMaior++;
            }
        }

        double media = soma / n;

        int[] hist = new int[8];

        for (double nota : notas) {
            if (nota <= 3.0) hist[0]++;
            else if (nota <= 4.0) hist[1]++;
            else if (nota <= 5.0) hist[2]++;
            else if (nota <= 6.0) hist[3]++;
            else if (nota <= 7.0) hist[4]++;
            else if (nota <= 8.0) hist[5]++;
            else if (nota <= 9.0) hist[6]++;
            else hist[7]++;
        }

        System.out.println("\nResultado da avaliação:");
        System.out.println("Menor nota: " + menor + " (" + countMenor + "x)");
        System.out.println("Maior nota: " + maior + " (" + countMaior + "x)");
        System.out.println("Média: " + media);

        String[] faixas = {
            "0.0 ~ 3.0", "3.1 ~ 4.0", "4.1 ~ 5.0", "5.1 ~ 6.0",
            "6.1 ~ 7.0", "7.1 ~ 8.0", "8.1 ~ 9.0", "9.1 ~ 10.0"
        };

        System.out.println("\nHistograma:");
        for (int i = 0; i < hist.length; i++) {
            System.out.print(faixas[i] + ": ");
            for (int j = 0; j < hist[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}