/*

• Para termos acesso a um arquivo no modo de escrita, instanciamos um
objeto da classe FileWriter
• Porém, para obtermos um melhor gerenciamento de memória, as
operações de escrita devem ser feitas através de um objeto da classe
BufferedWriter associado ao FileWriter
• O BufferedWriter trabalha com o conceito de buffered-stream, ou seja, as
operações de escrita são realizadas em memória antes de serem
refletidas no arquivo físico

*/

import java.io.*;

try {
 FileWriter writer = new FileWriter("arquivo.txt", false); // O segundo parâmetro diz se vai adicionar novos texto no final (true) ou sobreescrever (false)
 BufferedWriter buffer = new BufferedWriter(writer);
 buffer.write("Trabalhar com arquivos no Java");
 buffer.newLine();
 buffer.write("é bastante simples!");
 buffer.newLine();
 buffer.close();
} catch (IOException e) {
 e.printStackTrace();
}

/*
Método Descrição
BufferedWriter(Writer out) Construtor - Cria um output-stream associado ao arquivo
write(char[] cbuf, int off, int len) Escreve um array de caracteres completo ou parte dele
write(int c) Escreve um único caractere
write(String s, int off, int len) Escreve uma string completa ou parte dela
newLine() Escreve uma quebra de linha
flush() Descarrega o buffer para o arquivo
close() Descarrega o buffer e fecha o output-stream 
*/

try {
 FileWriter writer = new FileWriter("arquivo.txt", true); // Append
 BufferedWriter buffer = new BufferedWriter(writer);
 int i = 12;
 double d = 3.1415;
 char c = 'A';
 String texto = String.format("%04d\n%.2f\n%c", i, d, c);
 buffer.write(texto);
 buffer.close();
} catch (IOException e) {
 e.printStackTrace();
}

/*

Para termos acesso a um arquivo no modo de leitura, instanciamos um
objeto da classe FileReader
• Porém, para obtermos um melhor gerenciamento de memória, as
operações de leitura devem ser feitas através de um objeto da classe
BufferedReader associado ao FileReader
• O BufferedReader trabalha com o conceito de buffered-stream, ou seja, a
carga do arquivo físico é feita inicialmente para a memória e as
operações de leitura são realizadas no buffer

*/

try {
 FileReader reader = new FileReader("arquivo.txt");
 BufferedReader buffer = new BufferedReader(reader);
 String line;
 while ((line = buffer.readLine()) != null) {
 System.out.println(line);
 }
 reader.close();
} catch (IOException e) {
 e.printStackTrace();
}

/*
Método Descrição
BufferedReader(Reader in) Construtor - Cria um input-stream associado ao arquivo
read(char[] cbuf, int off, int len) Lê um array de caracteres do buffer, completo ou parte dele
read() Lê um único caractere do buffer
readLine() Lê uma linha completa do buffer
ready() Indica se o stream está pronto para leitura
skip(long n) Avança “n” caracteres no buffer
close() Fecha o input-stream e libera os recursos alocados
*/

try {
 FileReader reader = new FileReader("arquivo.txt");
 BufferedReader buffer = new BufferedReader(reader);
 int i = Integer.parseInt(buffer.readLine());
 double d = Double.parseDouble(buffer.readLine().replace(',', '.'));
 char c = buffer.readLine().charAt(0);
 System.out.format("%d\n%f\n%c", i, d, c);
 reader.close();
} catch (IOException e) {
 e.printStackTrace();
}

try {
 FileReader reader = new FileReader("arquivo.txt");
 Scanner scanner = new Scanner(reader);
 int i = scanner.nextInt();
 double d = scanner.nextDouble();
 char c = scanner.next().charAt(0);
 System.out.format("%d\n%f\n%c\n", i, d, c);
 scanner.close();
 reader.close();
} catch (IOException e) {
 e.printStackTrace();
}

/*
CSV
 */

Locale.setDefault(Locale.ENGLISH); // Define o padrão de formatação
FileReader reader = new FileReader("pessoas.csv");
Scanner scanner = new Scanner(reader).useDelimiter(",|\n"); // Define os separadores
scanner.nextLine(); // Descarta a linha do cabeçalho
String nome; char sexo; int idade; double altura; int peso;
while (scanner.hasNext()) {
 nome = scanner.next();
 sexo = scanner.next().charAt(0);
 idade = scanner.nextInt();
 altura = scanner.nextDouble();
 peso = scanner.nextInt();
 System.out.format(
 "Nome: %s\tSexo: %c\tIdade: %d\tAltura: %.2f\tPeso: %d\n",
 nome, sexo, idade, altura, peso);
}
scanner.close();
reader.close();

//////////////////////////////////////

// LEITOR DE ARQUIVOS

/////////////////////////////////////////

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
      try {
        FileWriter writer = new FileWriter("texto.txt", false);
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write("AOSJFPASJFPASJF ASFASFASF");
        buffer.newLine();
        buffer.write("AOSJFPASJFPASJF ASFASFASF");
        buffer.newLine();
        buffer.write("AOSJFPASJFPASJF ASFASFASF");
        buffer.close();

        FileReader reader = new FileReader("texto.txt");
        BufferedReader bufferR = new BufferedReader(reader);
        String line;
        int wordsAmount = 0, linesAmount = 0;
        while ((line = bufferR.readLine()) != null) {
          System.out.println(line);
          linesAmount++;
          wordsAmount += line.split(" ").length;
        }
        System.out.println(wordsAmount);
        System.out.println(linesAmount);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}