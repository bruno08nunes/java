import java.util.Scanner;

public class AppTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe C para Celsius ou F para Fahrenheit: ");
        String opcao = scanner.nextLine();

        System.out.print("Informe a temperatura: ");
        double temperatura = scanner.nextDouble();

        if (opcao.equalsIgnoreCase("C")) {
            double resultado = ConversorTemperatura.celsiusParaFahrenheit(temperatura);
            System.out.println("Temperatura em Fahrenheit: " + resultado);
        } else if (opcao.equalsIgnoreCase("F")) {
            double resultado = ConversorTemperatura.fahrenheitParaCelsius(temperatura);
            System.out.println("Temperatura em Celsius: " + resultado);
        } else {
            System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}