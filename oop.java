class Caneta {
    private String cor;
    private String marca;
    private double preco;
    private String ponta;

    // Exercício 2
    // Todos os atributos, exceto preço, são informados.
    public Caneta(String cor, String marca, String ponta) {
        this.cor = cor;
        this.marca = marca;
        this.ponta = ponta;
        this.preco = 0.0;
    }

    // Exercício 1
    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPreco(String preco) {
        this.preco = Double.parseDouble(preco);
    }

    public void setPonta(String ponta) {
        this.ponta = ponta;
    }
}

// Exercício 3
Carro carro = new Carro();

// Exercício 4
class Retangulo {
    private double base;
    private double altura;
    private double area;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.area = base * altura;
    }

    public void setBase(double base) {
        this.base = base;
        this.area = base * altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
        this.area = base * altura;
    }
}

// Exercício 5
Funcionario f;
f = new Funcionario("Bruno");

// Exercicio 6
// a) 2 - Linha 8 e linha 12

// b) 8 e 10

// c) c1 e c3 -> Circulo raio 7.5
// c2 -> Circulo raio 8.0

// d)
public class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}