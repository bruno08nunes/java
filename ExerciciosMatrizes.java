import java.util.Scanner;

public class ExerciciosMatrizes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Exercício 1
        double[][] matriz = criarMatrizFracionaria();
        // imprimirMatriz(matriz);

        // Exercício 2
        // imprimirDiagonalPrincipal(matriz);

        // Exercício 3
        // imprimirDiagonalSecundaria(matriz);

        // Exercício 4
        // imprimirBordas(matriz);
        
        // Exercício 5
        System.out.print("\nInforme o número de linhas da nova matriz (<10): ");
        int linhas = sc.nextInt();

        System.out.print("Informe o número de colunas da nova matriz (<10): ");
        int colunas = sc.nextInt();

        double[][] novaMatriz = copiarUltimasLinhasColunas(matriz, linhas, colunas);

        System.out.println("\nNova matriz:");
        imprimirMatriz(novaMatriz);

        // Exercício 6
        double[][] transposta = transporMatriz(novaMatriz);

        System.out.println("\nMatriz transposta:");
        imprimirMatriz(transposta);
        
        // Exercício 7
        char[][] matrizX = criarMatrizDiagonaisX();

        System.out.println("\nMatriz com diagonais em X:");
        imprimirMatrizChar(matrizX);
        
        // Exercício 8
        System.out.print("\nInforme um número entre 3 e 15: ");
        int tamanho = sc.nextInt();

        char[][] losango = criarLosango(tamanho);

        System.out.println("\nLosango:");
        imprimirMatrizChar(losango);

        sc.close();
    }

    // =========================================================
    // EXERCÍCIO 1
    // =========================================================
    public static double[][] criarMatrizFracionaria() {

        double[][] matriz = new double[10][10];

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][j] = i + (j / 10.0);
            }
        }

        return matriz;
    }

    public static void imprimirMatriz(double[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.printf("%.1f\t", matriz[i][j]);
            }

            System.out.println();
        }
    }

    // =========================================================
    // EXERCÍCIO 2
    // =========================================================
    public static void imprimirDiagonalPrincipal(double[][] matriz) {

        System.out.println("\nDiagonal principal:");

        for (int i = 0; i < matriz.length; i++) {

            System.out.printf("%.1f ", matriz[i][i]);
        }

        System.out.println();
    }

    // =========================================================
    // EXERCÍCIO 3
    // =========================================================
    public static void imprimirDiagonalSecundaria(double[][] matriz) {

        System.out.println("\nDiagonal secundária:");

        for (int i = 0; i < matriz.length; i++) {

            System.out.printf("%.1f ", matriz[i][9 - i]);
        }

        System.out.println();
    }

    // =========================================================
    // EXERCÍCIO 4
    // =========================================================
    public static void imprimirBordas(double[][] matriz) {

        System.out.println("\nBordas da matriz:");

        int linhas = matriz.length;
        int colunas = matriz[0].length;

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                if (i == 0 || i == linhas - 1 ||
                    j == 0 || j == colunas - 1) {

                    System.out.printf("%.1f\t", matriz[i][j]);

                } else {

                    System.out.print("\t");
                }
            }

            System.out.println();
        }
    }

    // =========================================================
    // EXERCÍCIO 5
    // =========================================================
    public static double[][] copiarUltimasLinhasColunas(
            double[][] matrizOriginal,
            int linhas,
            int colunas) {

        double[][] nova = new double[linhas][colunas];

        int inicioLinha = 10 - linhas;
        int inicioColuna = 10 - colunas;

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                nova[i][j] =
                        matrizOriginal[inicioLinha + i][inicioColuna + j];
            }
        }

        return nova;
    }

    // =========================================================
    // EXERCÍCIO 6
    // =========================================================
    public static double[][] transporMatriz(double[][] matriz) {

        int linhas = matriz.length;
        int colunas = matriz[0].length;

        double[][] transposta = new double[colunas][linhas];

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                transposta[j][i] = matriz[i][j];
            }
        }

        return transposta;
    }

    // =========================================================
    // EXERCÍCIO 7
    // =========================================================
    public static char[][] criarMatrizDiagonaisX() {

        char[][] matriz = new char[10][10];

        // Inicializa com '-'
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                matriz[i][j] = '-';
            }
        }

        // Coloca X nas diagonais
        for (int i = 0; i < 10; i++) {

            matriz[i][i] = 'X';

            matriz[i][9 - i] = 'X';
        }

        return matriz;
    }

    // =========================================================
    // EXERCÍCIO 8
    // =========================================================
    public static char[][] criarLosango(int n) {

        char[][] matriz = new char[n][n];

        // Inicializa com '-'
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                matriz[i][j] = '-';
            }
        }

        int meio1 = (n - 1) / 2;
        int meio2 = n / 2;

        for (int i = 0; i < n; i++) {

            int distancia = Math.abs(meio1 - i);

            if (n % 2 == 1) {

                matriz[i][distancia] = 'X';
                matriz[i][n - 1 - distancia] = 'X';

            } else {

                matriz[i][distancia] = 'X';
                matriz[i][n - 1 - distancia] = 'X';
            }
        }

        return matriz;
    }

    // =========================================================
    // MÉTODO AUXILIAR PARA MATRIZ CHAR
    // =========================================================
    public static void imprimirMatrizChar(char[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j] + " ");
            }

            System.out.println();
        }
    }
}