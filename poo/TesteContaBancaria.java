public class TesteContaBancaria {

    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria(
            12345,
            100,
            "Bruno"
        );

        conta.imprimirInfosConta();

        System.out.println();

        conta.depositar(200.00);
        System.out.println("Após depositar R$ 200,00:");
        System.out.println("Saldo: R$ " + conta.getSaldo());

        conta.depositar(80.40);
        System.out.println("Após depositar R$ 80,40:");
        System.out.println("Saldo: R$ " + conta.getSaldo());

        conta.sacar(100.00);
        System.out.println("Após sacar R$ 100,00:");
        System.out.println("Saldo: R$ " + conta.getSaldo());

        conta.sacar(20.50);
        System.out.println("Após sacar R$ 20,50:");
        System.out.println("Saldo: R$ " + conta.getSaldo());

        System.out.println();

        conta.imprimirInfosConta();
    }
}