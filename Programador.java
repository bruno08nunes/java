public class Funcionario {

    private String nome;
    private String cpf;
    private int matricula;

    public Funcionario(String nome, String cpf, int matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getMatricula() {
        return matricula;
    }
}

public class Programador extends Funcionario {

    private String linguagemPreferida;

    public Programador(
            String nome,
            String cpf,
            int matricula,
            String linguagemPreferida) {

        super(nome, cpf, matricula);
        this.linguagemPreferida = linguagemPreferida;
    }

    public String getLinguagemPreferida() {
        return linguagemPreferida;
    }

    public void setLinguagemPreferida(String linguagemPreferida) {
        this.linguagemPreferida = linguagemPreferida;
    }

    public void programar() {
        System.out.println(
            "Programando em " + linguagemPreferida
        );
    }
}

Programador p = new Programador(
    "Bruno",
    "123.456.789-00",
    123,
    "Java"
);

System.out.println(p.getNome());
System.out.println(p.getCpf());
System.out.println(p.getMatricula());
System.out.println(p.getLinguagemPreferida());

p.programar();