import java.util.Scanner;

public class ExerciciosJava {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Imprima o seu primeiro nome usando texto fixo e em seguida usando uma variável
        // System.out.println("Bruno");

        // String nome = "Bruno";
        // System.out.println(nome);


        // 2. Imprima a sua idade, utilizando uma variável numérica
        // int idade = 17;
        // System.out.println(idade);


        // 3. Imprima a sua altura com 2 casas decimais, utilizando uma variável numérica
        // double altura = 1.82;
        // System.out.printf("Altura: %.2f\n", altura);


        // 4. Solicite ao usuário o dia do seu nascimento e imprima no terminal o dia informado
        // System.out.print("Digite o dia do seu nascimento: ");
        // int diaNascimento = scanner.nextInt();
        // System.out.println(diaNascimento);


        // 5. Solicite ao usuário o dia e mês do seu nascimento e imprima no terminal
        // System.out.print("Digite o dia do seu nascimento: ");
        // int dia = scanner.nextInt();

        // System.out.print("Digite o mês do seu nascimento: ");
        // int mes = scanner.nextInt();

        // System.out.println("Você nasceu no dia " + dia + " do mês " + mes);

        // 6. Solicite ao usuário o dia, mês e ano do seu nascimento e imprima no formato dd/mm/yyyy
        // System.out.print("Digite o dia do seu nascimento: ");
        // int dia = scanner.nextInt();

        // System.out.print("Digite o mês do seu nascimento: ");
        // int mes = scanner.nextInt();

        // System.out.print("Digite o ano do seu nascimento: ");
        // int ano = scanner.nextInt();

        // System.out.printf("Data de nascimento: %02d/%02d/%04d\n", dia, mes, ano);


        // 7. Solicite um número fracionário e imprima como inteiro e com 3 casas decimais
        // System.out.print("\nDigite um número fracionário: ");
        // double numero = scanner.nextDouble();

        // System.out.println("Número como inteiro: " + (int) numero);
        // System.out.printf("Número com 3 casas decimais: %.3f\n", numero);


        // 8. Solicite um caractere representando uma moeda e um valor fracionário
        // System.out.print("\nDigite o símbolo da moeda: ");
        // char moeda = scanner.next().charAt(0);

        // System.out.print("Digite o valor: ");
        // double valor = scanner.nextDouble();

        // System.out.printf("Valor formatado: %c$ %.2f\n", moeda, valor);

        // 9. Solicite 3 números inteiros entre 0 e 255 (RGB) e mostre em hexadecimal
        System.out.print("\nDigite o valor de R (0-255): ");
        int r = scanner.nextInt();

        System.out.print("Digite o valor de G (0-255): ");
        int g = scanner.nextInt();

        System.out.print("Digite o valor de B (0-255): ");
        int b = scanner.nextInt();

        System.out.printf("Código hexadecimal do pixel: #%02X%02X%02X\n", r, g, b);

        scanner.close();
    }
}