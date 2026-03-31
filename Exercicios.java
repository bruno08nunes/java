import java.util.Scanner;

public class Exercicios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // =========================
        // 1. Classificar caractere
        // =========================
        System.out.print("1) Digite um caractere: ");
        char c = sc.next().charAt(0);

        if (Character.isUpperCase(c)) {
            System.out.println("Letra maiúscula");
        } else if (Character.isLowerCase(c)) {
            System.out.println("Letra minúscula");
        } else if (Character.isDigit(c)) {
            System.out.println("Número");
        } else {
            System.out.println("Símbolo");
        }

        // =========================
        // 2. Par ou ímpar
        // =========================
        System.out.print("\n2) Digite um número inteiro: ");
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("Par");
        } else {
            System.out.println("Ímpar");
        }

        // =========================
        // 3. Divisibilidade
        // =========================
        System.out.print("\n3) Digite dois números (a e b): ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (b != 0 && a % b == 0) {
            System.out.println("Divisível");
        } else {
            System.out.println("Não divisível");
        }

        // =========================
        // 4. Subtração positiva ou negativa
        // =========================
        System.out.print("\n4) Digite dois números (a e b): ");
        a = sc.nextInt();
        b = sc.nextInt();

        int resultado = a - b;

        if (resultado >= 0) {
            System.out.println("Resultado positivo");
        } else {
            System.out.println("Resultado negativo");
        }

        // =========================
        // 5. Intervalo
        // =========================
        System.out.print("\n5) Digite um número: ");
        int num = sc.nextInt();
        System.out.print("Digite o início do intervalo: ");
        int inicio = sc.nextInt();
        System.out.print("Digite o fim do intervalo: ");
        int fim = sc.nextInt();

        if (num < inicio) {
            System.out.println("Abaixo do intervalo");
        } else if (num > fim) {
            System.out.println("Acima do intervalo");
        } else {
            System.out.println("Dentro do intervalo");
        }

        // =========================
        // 6. Estado da água
        // =========================
        System.out.print("\n6) Digite a temperatura (°C): ");
        int temp = sc.nextInt();

        if (temp < 0) {
            System.out.println("Sólido");
        } else if (temp <= 100) {
            System.out.println("Líquido");
        } else {
            System.out.println("Gasoso");
        }

        // =========================
        // 7. Comparação de letras
        // =========================
        System.out.print("\n7) Digite duas letras: ");
        char l1 = sc.next().charAt(0);
        char l2 = sc.next().charAt(0);

        if (l1 == l2) {
            System.out.println("São iguais");
        } else if (l1 < l2) {
            System.out.println("Antecessora");
        } else if (l1 > l2) {
            System.out.println("Sucessora");
        }

        // =========================
        // 8. Intervalo entre horários
        // =========================
        System.out.println("\n8) Digite horário inicial (h m s): ");
        int h1 = sc.nextInt();
        int m1 = sc.nextInt();
        int s1 = sc.nextInt();

        System.out.println("Digite horário final (h m s): ");
        int h2 = sc.nextInt();
        int m2 = sc.nextInt();
        int s2 = sc.nextInt();

        int inicioSeg = h1 * 3600 + m1 * 60 + s1;
        int fimSeg = h2 * 3600 + m2 * 60 + s2;

        int diff = fimSeg - inicioSeg;

        int h = diff / 3600;
        int m = (diff % 3600) / 60;
        int s = diff % 60;

        System.out.printf("Intervalo: %02d:%02d:%02d\n", h, m, s);

        // =========================
        // 9. MRU
        // =========================
        System.out.println("\n9) MRU (d = v * t)");
        System.out.print("Digite distância (0 se quiser calcular): ");
        double d = sc.nextDouble();
        System.out.print("Digite velocidade (0 se quiser calcular): ");
        double v = sc.nextDouble();
        System.out.print("Digite tempo (0 se quiser calcular): ");
        double t = sc.nextDouble();

        if (d == 0) {
            d = v * t;
            System.out.println("Distância = " + d);
        } else if (v == 0) {
            v = d / t;
            System.out.println("Velocidade = " + v);
        } else if (t == 0) {
            t = d / v;
            System.out.println("Tempo = " + t);
        } else {
            System.out.println("Nada a calcular");
        }

        // =========================
        // 10. Distância entre pontos
        // =========================
        System.out.println("\n10) Distância entre dois pontos");
        System.out.print("Digite x1 e y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Digite x2 e y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("Distância = " + distancia);

        // =========================
        // 11. Peso ideal
        // =========================
        System.out.println("\n11) Peso ideal");
        System.out.print("Digite altura: ");
        double altura = sc.nextDouble();

        System.out.print("Digite sexo (M/F): ");
        char sexo = sc.next().charAt(0);

        double pesoIdeal;

        if (sexo == 'M' || sexo == 'm') {
            pesoIdeal = (72.7 * altura) - 58;
        } else {
            pesoIdeal = (62.1 * altura) - 44.7;
        }

        System.out.println("Peso ideal: " + pesoIdeal);

        System.out.print("Digite seu peso atual: ");
        double pesoAtual = sc.nextDouble();

        double margem = pesoIdeal * 0.05;

        if (pesoAtual >= pesoIdeal - margem && pesoAtual <= pesoIdeal + margem) {
            System.out.println("Dentro do peso ideal");
        } else if (pesoAtual > pesoIdeal) {
            System.out.println("Acima do peso ideal");
        } else {
            System.out.println("Abaixo do peso ideal");
        }

        sc.close();
    }
}