
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

    Scanner in = new Scanner(System.in);

//LISTA DE FUNCIONES - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //Crear sudoku 4x4
    public static int[][] crearSudoku4x4() {
        int[][] sudoku = new int[4][4];
        //……………. (rellena el sudoku aleatoriamente)
        return sudoku;
    }

    //Mostrar el menú y devuelve la opción elegida
    public static int menu() {
        sout “Opción 0 1 2 3...”

    int opcion = pedirIntEnRango(1, 8)
        return opcion;

    }

//Pide al jugador un valor INT, una y otra vez hasta que responde con valor en rango
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

//MAIN PRINCIPAL - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void main(String[] args) {

        //VARIABLES AUXILIARES
        int opcion; //opción del menú

    }
}
