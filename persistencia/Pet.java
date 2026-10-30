import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pet {
    private int id;
    private String nome;
    private String sexo;
    private String tipo;
    private static final String separador = ";";
    private static int nextId = 1;
    private static final ArrayList<Pet> pets = new ArrayList<>();

    public Pet(String nome, String sexo, String tipo) {
        this.id = nextId++;
        this.nome = nome;
        this.sexo = sexo;
        this.tipo = tipo;
    }

    private Pet(int id, String nome, String sexo, String tipo) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.tipo = tipo;
        if (id >= nextId) {
            nextId = id + 1;
        }
    }

    public static void add(Pet pet) {
        pets.add(pet);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public static ArrayList<Pet> getPets() {
        return pets;
    }

    public static Pet getById(int id) {
        for (Pet pet : pets) {
            if (pet.id == id) {
                return pet;
            }
        }
        return null;
    }

    public static Pet getByNome(String nome) {
        for (Pet pet : pets) {
            if (pet.nome.equalsIgnoreCase(nome)) return pet;
        }
        return null;
    }

    public static void exibirDados() {
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    public String serializar() {
        return id + separador + nome + separador + sexo + separador + tipo;
    }

    public static String cabecalho() {
        return "id;nome;sexo;tipo";
    }

    public static void salvar() {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("pets.txt"))) {
            buffer.write(cabecalho());
            for (Pet pet : pets) {
                buffer.newLine();
                buffer.write(pet.serializar());
            }
            System.out.println("Pets salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar pets: " + e.getMessage());
        }
    }

    public static void carregar() {
        pets.clear();
        nextId = 1;

        try (BufferedReader buffer = new BufferedReader(new FileReader("pets.txt"))) {
            buffer.readLine(); // Cabecalho
            String linha;
            while ((linha = buffer.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] campos = linha.split(separador, -1);
                if (campos.length >= 4) {
                    pets.add(new Pet(
                        Integer.parseInt(campos[0]),
                        campos[1], campos[2], campos[3]
                    ));
                }
            }
            System.out.println("Pets carregados com sucesso.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao carregar pets: " + e.getMessage());
        }
    }

    public static void limpar() {
        pets.clear();
        nextId = 1;
    }

    @Override
    public String toString() {
        return "Pet [id=" + id + ", nome=" + nome +
               ", sexo=" + sexo + ", tipo=" + tipo + "]";
    }
}
