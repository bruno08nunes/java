
public class Data {
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	private int dia;
	private int mes;
	private int ano;

	public String dataBarra() {
		return String.format("%02d/%02d/%04d", dia, mes, ano);
	}

	@Override
	public String toString() {
		return "Data [dia=" + dia + ", mes=" + mes + ", ano=" + ano + "]";
	}
}
