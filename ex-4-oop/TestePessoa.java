public class TestePessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(
                "Bruno",
                "bruno@email.com"
        );

        Data dataNascimento = new Data(15, 5, 2005);

        pessoa.setDataNascimento(dataNascimento);

        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("E-mail: " + pessoa.getEmail());

        System.out.print("Data de nascimento: ");
        pessoa.getDataNascimento().escreveData();
    }
}