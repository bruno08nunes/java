public class TesteData {
    public static void main(String[] args) {
        Data data1 = new Data(31, 8, 2024);
        Data data2 = new Data(31, 8, 2024);
        Data data3 = new Data(1, 1, 2025);

        System.out.print("Data 1: ");
        data1.escreveData();

        System.out.print("Data 2: ");
        data2.escreveData();

        System.out.print("Data 3: ");
        data3.escreveData();

        System.out.println("Data 1 é igual à Data 2? " + data1.equals(data2));
        System.out.println("Data 1 é igual à Data 3? " + data1.equals(data3));

        System.out.println("2024 é bissexto? " + data1.ehBissexto());
        System.out.println("2025 é bissexto? " + data3.ehBissexto());
    }
}