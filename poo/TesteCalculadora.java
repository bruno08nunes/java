import java.util.Scanner;

public class TesteCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculadora calculadora = new Calculadora();

        System.out.println("Soma");

        System.out.print("Digite o primeiro número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double numero2 = scanner.nextDouble();

        System.out.println("Resultado: " + calculadora.somar(numero1, numero2));

        System.out.println();

        System.out.println("Subtração");

        System.out.print("Digite o primeiro número: ");
        numero1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        numero2 = scanner.nextDouble();

        System.out.println("Resultado: " + calculadora.subtrair(numero1, numero2));

        System.out.println();

        System.out.println("Multiplicação");

        System.out.print("Digite o primeiro número: ");
        numero1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        numero2 = scanner.nextDouble();

        System.out.println("Resultado: " + calculadora.multiplicar(numero1, numero2));

        System.out.println();

        System.out.println("Divisão");

        System.out.print("Digite o primeiro número: ");
        numero1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        numero2 = scanner.nextDouble();

        System.out.println("Resultado: " + calculadora.dividir(numero1, numero2));

        scanner.close();
    }
}