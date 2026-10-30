import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Pessoa {
    private int id;
    private String nome;
    private String sexo;
    private ArrayList<Pet> pets;
    private static final String separador = ";";
    private static int nextId = 1;
    private static final ArrayList<Pessoa> pessoas = new ArrayList<>();

    public Pessoa(String nome, String sexo) {
        this.id = nextId++;
        this.nome = nome;
        this.sexo = sexo;
        this.pets = new ArrayList<>();
    }

    private Pessoa(int id, String nome, String sexo) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.pets = new ArrayList<>();
        if (id >= nextId) {
            nextId = id + 1;
        }
    }

    public static void add(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void adicionarPet(Pet pet) {
        if (pet == null) return;
        
        if (!pets.contains(pet)) {
            pets.add(pet);
        }
    }

    public static ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public static Pessoa getByNome(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.nome.equals(nome)) {
                return pessoa;
            }
        }
        return null;
    }

    public static void exibirDados() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        for (Pessoa pessoa : pessoas) {
            System.out.println("Pessoa: " + pessoa.nome + " (ID: " + pessoa.id + ", sexo: " + pessoa.sexo + ")");
            if (pessoa.pets.isEmpty()) {
                System.out.println("  Pets: nenhum");
            } else {
                for (Pet pet : pessoa.pets) {
                    System.out.println("  Pet: " + pet.getNome() + " (tipo: " + pet.getTipo() + ", ID: " + pet.getId() + ")");
                }
            }
        }
    }

    public static void exibirPorTipo(String tipo) {
        boolean encontrou = false;

        for (Pessoa pessoa : pessoas) {
            for (Pet pet : pessoa.pets) {
                if (pet.getTipo().equalsIgnoreCase(tipo)) {
                    if (!encontrou) {
                        encontrou = true;
                    }
                    System.out.println("Pessoa: " + pessoa.nome + " | Pet: " + pet.getNome());
                }
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma pessoa possui pet do tipo informado.");
        }
    }

    public String serializar() {
        StringJoiner petIds = new StringJoiner(",");
        for (Pet pet : pets) {
            petIds.add(String.valueOf(pet.getId()));
        }
        return id + separador + nome + separador + sexo + separador + petIds;
    }

    public static String cabecalho() {
        return
            "id" + separador +
            "nome" + separador +
            "sexo" + separador +
            "petId";
    }

    public static void salvar() {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("pessoas.txt"))) {
            buffer.write(cabecalho());
            for (Pessoa pessoa : pessoas) {
                buffer.newLine();
                buffer.write(pessoa.serializar());
            }
            System.out.println("Pessoas salvas com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar pessoas: " + e.getMessage());
        }
    }

    public static void carregar() {
        limpar();

        try (BufferedReader buffer = new BufferedReader(new FileReader("pessoas.txt"))) {
            buffer.readLine(); // Cabecalho
            String linha;

            while ((linha = buffer.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                String[] campos = linha.split(separador, -1);
                if (campos.length < 4) continue;

                Pessoa pessoa = new Pessoa(
                    Integer.parseInt(campos[0]), campos[1], campos[2]
                );

                if (!campos[3].trim().isEmpty()) {
                    String[] idsPets = campos[3].split(",");
                    for (String idPet : idsPets) {
                        Pet pet = Pet.getById(Integer.parseInt(idPet));
                        if (pet != null) pessoa.adicionarPet(pet);
                    }
                }

                pessoas.add(pessoa);
            }
            System.out.println("Pessoas carregadas com sucesso.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao carregar pessoas: " + e.getMessage());
        }
    }

    public static void limpar() {
        pessoas.clear();
        nextId = 1;
    }

    @Override
    public String toString() {
        StringJoiner petIds = new StringJoiner(", ");

        for (Pet pet : pets) {
            petIds.add(String.valueOf(pet.getId()));
        }

        return "Pessoa [id=" + id +
            ", nome=" + nome +
            ", sexo=" + sexo +
            ", pets=[" + petIds + "]]";
    }
}
