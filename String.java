// String builder

append(String str) Adiciona a string especificada ao final do StringBuilder sb.append(“Texto”);
insert(int offset, String) Insere a string especificada na posição fornecida no StringBuilder
replace(int start, int end, String) Substitui caracteres em uma substring pela string especificada
delete(int start, int end) Remove caracteres no intervalo especificado sb.delete(5, 11);
reverse() Inverte a sequência de caracteres no StringBuilder sb.reverse();
length() Retorna o número de caracteres no StringBuilder int len = sb.length();
charAt(int index) Retorna o caractere no índice especificado char ch = sb.charAt(4);
setCharAt(int index, char) Substitui o caractere na posição especificada por um novo caractere. sb.setCharAt(0, ‘A’);
substring(int start, int end) Retorna uma nova String que contém caracteres do intervalo especificado String sub = sb.substring(0, 5);
deleteCharAt(int index) Remove o caractere na posição especificada sb.deleteCharAt(3);
indexOf(String str) Retorna o índice da primeira ocorrência da string especificada
lastIndexOf(String str) Retorna o índice da última ocorrência da string especificada int idx = sb.lastIndexOf(“Geeks”);
toString() Converte o objeto StringBuilder em uma String String result = sb.toString();
sb.insert(5, ” Texto”);
sb.replace(6, 11, “Texto”);
int idx = sb.indexOf(“Texto”)

public class ExemploStringBuilder {
    public static void main(String[] args) {
        // 1. Criando um StringBuilder
        StringBuilder sb = new StringBuilder("Java");

        // 2. append(): Adiciona texto ao final
        sb.append(" é ");
        sb.append("muito ");
        sb.append("poderoso.");
        // Conteúdo atual: "Java é muito poderoso."

        // 3. insert(): Insere texto em uma posição específica
        sb.insert(5, "linguagem "); 
        // Conteúdo atual: "Java linguagem é muito poderoso."

        // 4. replace(): Substitui uma parte do texto
        sb.replace(17, 19, "foi"); 
        // Conteúdo atual: "Java linguagem foi muito poderoso."

        // 5. delete(): Remove uma parte do texto
        sb.delete(24, 33); // Remove a palavra "poderoso"
        // Conteúdo atual: "Java linguagem foi "

        // 6. reverse(): Inverte a ordem dos caracteres
        sb.reverse();
        // Conteúdo atual: " .iof eugnawal avaJ"

        // 7. toString(): Converte o StringBuilder de volta para String
        String resultado = sb.toString();
        System.out.println(resultado);
    }
}

// String
length() → retorna o tamanho da string.
charAt(int index) → retorna o caractere em uma posição específica.
substring(int beginIndex) → retorna parte da string a partir de um índice.
substring(int beginIndex, int endIndex) → retorna parte da string entre dois índices.
equals(Object obj) → compara o conteúdo de duas strings.
equalsIgnoreCase(String str) → compara ignorando maiúsculas e minúsculas.
compareTo(String str) → compara strings lexicograficamente.
compareToIgnoreCase(String str) → compara ignorando diferenças de caixa.
contains(CharSequence s) → verifica se uma sequência está presente na string.
startsWith(String prefix) → verifica se a string começa com determinado texto.
endsWith(String suffix) → verifica se a string termina com determinado texto.
indexOf(String str) → retorna a posição da primeira ocorrência.
lastIndexOf(String str) → retorna a posição da última ocorrência.
isEmpty() → verifica se a string está vazia ("").
isBlank() → verifica se a string está vazia ou contém apenas espaços (Java 11+).
toUpperCase() → converte para maiúsculas.
toLowerCase() → converte para minúsculas.
trim() → remove espaços do início e do fim.
strip() → remove espaços em branco Unicode do início e do fim (Java 11+).
replace(char oldChar, char newChar) → substitui caracteres.
replace(CharSequence target, CharSequence replacement) → substitui trechos de texto.
replaceAll(String regex, String replacement) → substitui usando expressão regular.
replaceFirst(String regex, String replacement) → substitui apenas a primeira ocorrência.
split(String regex) → divide a string em um array.
concat(String str) → concatena strings.
join(CharSequence delimiter, CharSequence... elements) → junta elementos usando um separador.
matches(String regex) → verifica se a string corresponde a uma expressão regular.
repeat(int count) → repete a string várias vezes (Java 11+).
toCharArray() → converte a string em um vetor de caracteres.
getBytes() → converte a string em um vetor de bytes.
intern() → adiciona ou recupera a string do pool de strings.
valueOf() → converte diferentes tipos para string (método estático).
format() → cria strings formatadas (método estático).
lines() → retorna um fluxo de linhas da string (Java 11+).