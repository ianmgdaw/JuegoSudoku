
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
//VARIABLES GLOBALES - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static Scanner in = new Scanner(System.in);
    public static int opcion; //opción del menú
    public static int[][] sudoku = new int[4][4];
    public static boolean salir = false;
    public static int posC, posF;
    public static int num;

//LISTA DE FUNCIONES - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
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

    //Pide al jugador un valor INT, umenuna y otra vez hasta que ===============
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
                    System.out.println("NUMERO ANTES: " + num);
                    modificarSudoku(sudoku, num);
                    System.out.println("NUMERO DESPUES: " + num);
                    break;
                case 3: //Terminar
                    salir = true;
                    break;
            }

            System.out.println("");
        } while (!salir);

    }
}
