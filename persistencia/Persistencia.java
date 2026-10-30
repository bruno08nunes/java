import java.util.Scanner;

public class Persistencia {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    cadastrarPet();
                    break;
                case 2:
                    cadastrarPessoa();
                    break;
                case 3:
                    adotar();
                    break;
                case 4:
                    Pessoa.exibirDados();
                    break;
                case 5:
                    listarPorTipo();
                    break;
                case 6:
                    salvar();
                    break;
                case 7:
                    carregar();
                    break;
                case 8:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 8);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\\n===== MENU =====");
        System.out.println("1. Cadastrar pet");
        System.out.println("2. Cadastrar pessoa");
        System.out.println("3. Adotar");
        System.out.println("4. Listar tudo");
        System.out.println("5. Listar por tipo de pet");
        System.out.println("6. Salvar");
        System.out.println("7. Carregar");
        System.out.println("8. Sair");
    }

    private static void cadastrarPet() {
        System.out.println("\\n--- Cadastro de pet ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        Pet pet = new Pet(nome, sexo, tipo);
        Pet.add(pet);
        System.out.println("Pet cadastrado. ID gerado: " + pet.getId());
    }

    private static void cadastrarPessoa() {
        System.out.println("\\n--- Cadastro de pessoa ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, sexo);
        Pessoa.add(pessoa);
        System.out.println("Pessoa cadastrada. ID gerado: " + pessoa.getId());
    }

    private static void adotar() {
        System.out.println("\\n--- Adocao ---");
        System.out.print("Nome da pessoa: ");
        String nomePessoa = scanner.nextLine();
        System.out.print("Nome do pet: ");
        String nomePet = scanner.nextLine();

        Pessoa pessoa = Pessoa.getByNome(nomePessoa);
        Pet pet = Pet.getByNome(nomePet);

        if (pessoa == null) {
            System.out.println("Pessoa nao encontrada.");
        } else if (pet == null) {
            System.out.println("Pet nao encontrado.");
        } else {
            pessoa.adicionarPet(pet);
            System.out.println("Pet associado a pessoa com sucesso.");
        }
    }

    private static void listarPorTipo() {
        System.out.print("Informe o tipo de pet: ");
        String tipo = scanner.nextLine();
        Pessoa.exibirPorTipo(tipo);
    }

    private static void salvar() {
        Pet.salvar();
        Pessoa.salvar();
    }

    private static void carregar() {
        Pet.carregar();
        Pessoa.carregar();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }
}
