import java.util.*;

public class Busqueda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresar las dimensiones de la matriz
        System.out.print("Ingrese el numero de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el numero de columnas: ");
        int columnas = scanner.nextInt();

        // Crear y llenar la matriz
        int[][] matriz = new int[filas][columnas];
        System.out.println("Ingrese la matriz ordenada:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Mostrar la matriz
        System.out.println("Matriz ingresada:");
        mostrarMatriz(matriz);

        // Ingresar el elemento a buscar
        System.out.print("Ingrese el elemento a buscar: ");
        int elementoBuscado = scanner.nextInt();

        // Realizar la búsqueda en la matriz
        buscarElemento(matriz, filas, columnas, elementoBuscado);

        scanner.close();
    }

    // Método para mostrar la matriz
    private static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para buscar el elemento en la matriz
    private static void buscarElemento(int[][] matriz, int filas, int columnas, int elementoBuscado) {
        int fila = 0;
        int columna = columnas - 1;

        boolean encontrado = false;
        boolean repetido = false;

        while (fila < filas && columna >= 0) {
            int elementoActual = matriz[fila][columna];

            if (elementoActual == elementoBuscado) {
                if (!encontrado) {
                    System.out.println("Elemento encontrado en la posicion: (" + fila + ", " + columna + ")");
                    encontrado = true;
                } else {
                    System.out.println("Elemento repetido en la posicion: (" + fila + ", " + columna + ")");
                    repetido = true;
                }
                // Moverse a la izquierda en la misma fila
                columna--;
            } else if (elementoActual > elementoBuscado) {
                // Moverse hacia arriba en la matriz
                columna--;
            } else {
                // Moverse hacia abajo en la matriz
                fila++;
            }
        }

        if (!encontrado) {
            System.out.println("Elemento no encontrado en la matriz.");
        }

        if (repetido) {
            System.out.println("Hay elementos repetidos en la matriz.");
        }
    }
}
