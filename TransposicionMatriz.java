import java.util.*;

public class TransposicionMatriz {

    public static void main(String[] args) {
        int[][] matriz = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        transponerAntihorario(matriz);

        System.out.println("\nMatriz transpuesta en sentido antihorario:");
        imprimirMatriz(matriz);
    }

    // sentido ant horaro
    private static void transponerAntihorario(int[][] matriz) {
        // sentido anti horario
        for (int i = 0; i < 2; i++) {
            for (int j = i; j < 3 - i; j++) {
                // cambio de pocicion de valores
                int temp = matriz[i][j];
                matriz[i][j] = matriz[3 - j][i];
                matriz[3 - j][i] = matriz[3 - i][3 - j];
                matriz[3 - i][3 - j] = matriz[j][3 - i];
                matriz[j][3 - i] = temp;
            }
        }
    }

    // Imprimir
    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
