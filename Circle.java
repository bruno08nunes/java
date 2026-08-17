public class Teste{
    
    public static void main(String[] args){
        
        // 5)
        Circulo c1 = new Circulo();
        c1.tornarVisivel();

        // 6)
        c1.alterarCor("red");

        // 7)
        c1.moverHorizontal(30);

        // 8)
        c1.moverHorizontal(-50);

        // 9)
        Circulo c2 = new Circulo();

        c2.alterarCor("magenta");
        c2.alterarTamanho(50);

        c2.moverHorizontal(450);
        c2.moverVertical(300);

        c2.tornarVisivel();

        // 10)
        c1.tornarInvisivel();
        c2.tornarInvisivel();

        // 11)
        Circulo azul = new Circulo();
        azul.alterarCor("blue");
        azul.alterarTamanho(50);
        azul.moverHorizontal(-100);
        azul.moverVertical(-50);
        azul.tornarVisivel();


        Circulo vermelho = new Circulo();
        vermelho.alterarCor("red");
        vermelho.alterarTamanho(50);
        vermelho.moverHorizontal(100);
        vermelho.moverVertical(-50);
        vermelho.tornarVisivel();


        Circulo amarelo = new Circulo();
        amarelo.alterarCor("yellow");
        amarelo.alterarTamanho(50);
        amarelo.moverHorizontal(-100);
        amarelo.moverVertical(50);
        amarelo.tornarVisivel();


        Circulo verde = new Circulo();
        verde.alterarCor("green");
        verde.alterarTamanho(50);
        verde.moverHorizontal(100);
        verde.moverVertical(50);
        verde.tornarVisivel();

        // 12)
        Circulo azul = new Circulo();
        azul.alterarCor("blue");
        azul.alterarTamanho(200);
        azul.moverHorizontal(-65);
        azul.moverVertical(-65);
        azul.tornarVisivel();


        Circulo amarelo = new Circulo();
        amarelo.alterarCor("yellow");
        amarelo.alterarTamanho(150);
        amarelo.moverHorizontal(-40);
        amarelo.moverVertical(-40);
        amarelo.tornarVisivel();


        Circulo verde = new Circulo();
        verde.alterarCor("green");
        verde.alterarTamanho(100);
        verde.moverHorizontal(-15);
        verde.moverVertical(-15);
        verde.tornarVisivel();


        Circulo vermelho = new Circulo();
        vermelho.alterarCor("red");
        vermelho.alterarTamanho(50);
        vermelho.moverHorizontal(10);
        vermelho.moverVertical(10);
        vermelho.tornarVisivel();
    }
    
}

// 1) Possui 5 atributos
// 2) Possui 15 métodos (contando o construtor)
// 3) Sim, o método alterarCor
// 4) É possível ler o nome do método, os comentários ou o próprio código
