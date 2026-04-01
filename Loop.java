import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        exercicio1(sc);
        exercicio2(sc);
        exercicio3(sc);
        exercicio4(sc);
        exercicio5(sc);
        exercicio6(sc);
        exercicio7(sc);
        exercicio8();
        exercicio9();
        exercicio10();

        sc.close();
    }

    // 1
    public static void exercicio1(Scanner sc) {
        System.out.print("1) Digite n: ");
        int n = sc.nextInt();

        System.out.println("For:");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }

        System.out.println("\nWhile:");
        int i = 1;
        while (i <= n) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println("\n");
    }

    // 2
    public static void exercicio2(Scanner sc) {
        System.out.print("2) Digite n: ");
        int n = sc.nextInt();

        System.out.println("For:");
        for (int i = 1; i <= n; i++) {
            System.out.print((i * 2) + " ");
        }

        System.out.println("\nWhile:");
        int i = 1;
        while (i <= n) {
            System.out.print((i * 2) + " ");
            i++;
        }
        System.out.println("\n");
    }

    // 3
    public static void exercicio3(Scanner sc) {
        System.out.print("3) Digite n: ");
        int n = sc.nextInt();

        System.out.println("For:");
        for (int i = 0; i < n; i++) {
            System.out.print((2 * i + 1) + " ");
        }

        System.out.println("\nWhile:");
        int i = 0;
        while (i < n) {
            System.out.print((2 * i + 1) + " ");
            i++;
        }
        System.out.println("\n");
    }

    // 4
    public static void exercicio4(Scanner sc) {
        System.out.print("4) Digite n: ");
        int n = sc.nextInt();

        long fatorial = 1;

        // For
        for (int i = 1; i <= n; i++) {
            fatorial *= i;
        }
        System.out.println("Fatorial (for): " + fatorial);

        // While
        fatorial = 1;
        int i = 1;
        while (i <= n) {
            fatorial *= i;
            i++;
        }
        System.out.println("Fatorial (while): " + fatorial + "\n");
    }

    // 5
    public static void exercicio5(Scanner sc) {
        System.out.print("5) Digite n: ");
        int n = sc.nextInt();

        double valor = 1.5;

        for (int i = 0; i < n; i++) {
            System.out.print(valor + " ");
            valor += 0.5;
        }
        System.out.println("\n");
    }

    // 6
    public static void exercicio6(Scanner sc) {
        System.out.print("6) Digite n: ");
        int n = sc.nextInt();
        System.out.print("Digite p: ");
        double p = sc.nextDouble();
        System.out.print("Digite i: ");
        double inicio = sc.nextDouble();

        double valor = inicio;

        for (int j = 0; j < n; j++) {
            System.out.print(valor + " ");
            valor += p;
        }
        System.out.println("\n");
    }

    // 7
    public static void exercicio7(Scanner sc) {
        int num, qtd = 0, pares = 0, impares = 0;
        int soma = 0;
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        System.out.println("7) Digite números positivos (0 para parar):");

        while (true) {
            num = sc.nextInt();
            if (num == 0)
                break;

            qtd++;
            soma += num;

            if (num % 2 == 0)
                pares++;
            else
                impares++;

            if (num > maior)
                maior = num;
            if (num < menor)
                menor = num;
        }

        if (qtd > 0) {
            double media = (double) soma / qtd;

            System.out.println("Quantidade: " + qtd);
            System.out.println("Pares: " + pares);
            System.out.println("Ímpares: " + impares);
            System.out.println("Soma: " + soma);
            System.out.println("Média: " + media);
            System.out.println("Maior: " + maior);
            System.out.println("Menor: " + menor);
        } else {
            System.out.println("Nenhum número foi digitado.");
        }
        System.out.println();
    }

    // 8
    public static void exercicio8() {
        System.out.println("8)");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 9
    public static void exercicio9() {
        System.out.println("9)");
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 10
    public static void exercicio10() {
        System.out.println("10)");
        for (int i = 5; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}