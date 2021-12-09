
import java.util.Scanner;

/*
 * Proyecto JuegoSudoku - Archivo Sudoku.java - Compañia DAW
 * Licencia Creative Commons BY-NC-SA 4.0
 * https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
/**
 *
 * @author Ian Molina Guillo <ianmg.daw@gmail.com>
 * @version 1.0
 * @date 1 dic. 2021 21:29:58
 */
public class Sudoku {

    //VARIABLES GLOBALES - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static Scanner in = new Scanner(System.in);
    public static int opcion; //variable opción del menú
    public static int[][] sudoku = new int[4][4]; // crear matriz de sudoku
    public static boolean salir = false; // boolean salida
    public static int posC, posF; // Nº de posiciones
    public static int num; // Número
    public static boolean resultadoComprobar; // Devuelve true si el resultado es correcto, sino false.

    //LISTA DE FUNCIONES - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //Crear sudoku 4x4 =========================================================
    public static int[][] crearSudoku4x4() {

        for (int i = 0; i < sudoku.length; i++) { //fila
            for (int j = 0; j < sudoku[i].length; j++) { //columna
                sudoku[i][j] = 1;
            }
        }
        return sudoku;
    }
    //==========================================================================

    //Mostrar sudoku 4x4 =======================================================
    public static int[][] mostrarSudoku4x4() {
        System.out.println("C:   0 1 2 3 4");
        for (int i = 0; i < sudoku.length; i++) { //fila
            System.out.print("F" + i + ": ");
            for (int j = 0; j < sudoku[i].length; j++) { //columna
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println("");
        }
        return sudoku;
    }
    //==========================================================================

    //Mostrar el menú y devuelve la opción elegida =============================
    public static int menu() {
        System.out.println("0. Salir");
        System.out.println("1. Mostrar sudoku");
        System.out.println("2. Añadir o modificar");
        System.out.println("3. Terminar");
        System.out.print("Elige una opción: ");

        int opcion = pedirIntEnRango(0, 3);
        return opcion;
    }
    //==========================================================================

    //Pide al jugador un valor INT, en una y otra vez hasta que ===============
    //responde con valor en rango
    public static int pedirIntEnRango(int min, int max) {
        int valor;
        do {
            valor = in.nextInt();
            if (valor < min || valor > max) {
                System.out.println("AVISO: No válido. Debe ser entre " + min + " y " + max);
                System.out.print("Vuelve a intentarlo: ");
            }
        } while (valor < min || valor > max);

        return valor;
    }
    //==========================================================================

    // Pedir el numero de posición de fila y de columna y un numero de 1 al 4 ==
    // Despues se guarda el número
    public static int[][] modificarSudoku(int sudoku[][], int num) {
        System.out.print("Escribe Nº posicion de fila: ");  //pedir fila
        posF = pedirIntEnRango(0, 3);
        System.out.print("Escribe Nº posicion de columna: "); //pedir columna
        posC = pedirIntEnRango(0, 3);
        System.out.print("Escribe el número: "); //pedir numero
        num = pedirIntEnRango(1, 4);

        System.out.println("PosF: " + posF);
        System.out.println("PosC: " + posC);
        System.out.println("Num: " + num);

        sudoku[posF][posC] = num;

        return sudoku;

    }
    //==========================================================================

    // Comprueba si los numeros son correctos o no =============================
    public static boolean comprobarSudoku(int sudoku[][]) {
        int[] sumaFil = new int[4]; //Vector para guardar las sumas de fila
        int[] sumaCol = new int[4]; //Vector para guardar las sumas de columna
        int filIgual = 0, colIgual = 0; // Contador de filas y columnas correctas

        //Sumar los numeros de fila
        for (int i = 0; i < sudoku.length; i++) {
            sumaFil[i] = 0;
            for (int j = 0; j < sudoku[i].length; j++) {
                sumaFil[i] += sudoku[i][j];
            }
        }

        //Sumar los numeros de columna
        for (int j = 0; j < sudoku.length; j++) {
            sumaCol[j] = 0;
            for (int i = 0; i < sudoku[j].length; i++) {
                sumaCol[j] += sudoku[i][j];
            }
        }

        //Comprueba si las sumas de filas son iguales a 10.
        for (int i = 0; i < sudoku.length; i++) {
            if (sumaFil[i] == 10) { //Comprueba que total de sumas son 10. 
                filIgual++;
            }
        }

        //Comprueba si las sumas de columnas son iguales a 10.
        for (int i = 0; i < sudoku.length; i++) {
            if (sumaCol[i] == 10) {  //Comprueba que total de sumas son 10.
                colIgual++;
            }
        }

        //Ultima comprobación las sumas del filas y columnas
        if (filIgual == 4 && colIgual == 4) {
            resultadoComprobar = true;
        } else {
            resultadoComprobar = false;
        }

        return resultadoComprobar;
    }
    //==========================================================================

//MAIN PRINCIPAL - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void main(String[] args) {

        //VARIABLES AUXILIARES
        //Bucle principal
        do {
            crearSudoku4x4(); //Crear la tabla de sudoku al empezar.
            opcion = menu();

            switch (opcion) {
                case 0: //Salir
                    salir = true;
                    break;
                case 1: //Mostrar sudoku
                    mostrarSudoku4x4();
                    break;
                case 2: //Añadir o modificar
                    modificarSudoku(sudoku, num);
                    break;
                case 3: //Terminar
                    if (comprobarSudoku(sudoku)) {
                        System.out.println("¡Has ganado! ¡Felicidades!");
                    } else {
                        System.out.println("Oh, has perdido.");
                    }
                    System.out.println("Gracias por jugar.");
                    salir = true;
                    break;
            }

            System.out.println("");
        } while (!salir);

    }
}
