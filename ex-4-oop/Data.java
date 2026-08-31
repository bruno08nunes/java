public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void escreveData() {
        System.out.printf("%02d/%02d/%04d%n", dia, mes, ano);
    }

    public boolean equals(Data data) {
        return this.dia == data.dia
                && this.mes == data.mes
                && this.ano == data.ano;
    }

    public boolean ehBissexto() {
        if (ano % 100 == 0) {
            return ano % 400 == 0;
        }

        return ano % 4 == 0;
    }
}