import java.util.Scanner;
import java.util.ArrayList;

public class Cerillas {


    static int ALGORITMO = 0;
    static int VALOR_INICIAL = 2435; //Valor inicial de juego

    private static ArrayList<Nodo> hijos = new ArrayList<Nodo>();
    private static ArrayList<Integer> valoresHeuristicos = new ArrayList<Integer>();


    public static void Juego(){
        Scanner entradaEscaner = new Scanner(System.in);
        int cerillas;
        int quitar;

        boolean turnoP = false;
        System.out.println("Bienvenido al juego de las cerilas");
        System.out.println("¿Cuántas cerillas hay en la fila?:");
        cerillas = entradaEscaner.nextInt();
        while (cerillas > 0) {
            System.out.println("Hay " + cerillas + " cerillas");

            System.out.print(cerillas+ ": ");
            for (int i=0; i< cerillas; i++)
            {
                System.out.print("X");
            }
            System.out.println("");


            if (turnoP == false){

                System.out.println("¿Cuantas cerillas quieres quitar? M (1,2 o 3)");
                quitar = entradaEscaner.nextInt();
                turnoP = true;

            }

            else {
                System.out.println("¿Cuantas cerillas quieres quitar? P (1,2 o 3)");
                quitar = entradaEscaner.nextInt();
                turnoP = false;
            }

            while (quitar > 3 || quitar < 1) {


                System.out.println("Error introduce una cantidad de cerillas a quitar adecuada");
                quitar = entradaEscaner.nextInt();
            }
            if (cerillas >= quitar) {
                cerillas = cerillas - quitar;

            }
            else {
                System.out.println("Quedan..." + cerillas);
                System.out.println("Has introducido un número mayor a las cerillas restantes");

            }

        }


        if (turnoP == false ){
            System.out.println("Ha ganado la máquina");
        }
        else{
            System.out.println("Ha ganado la persona");
            //
        }
    }
    public static int minimax(Nodo nodo, int prof) {
        if (nodo.esFinal() || prof == 0){
            nodo.evaluarNodo();
            return nodo.getValorHeuristico();
        }
        int alpha = -100;
        ArrayList<Nodo> h = nodo.generarHijos();
        for (int i = 0; i < h.size(); i++) {
            h.get(i).evaluarNodo();
            alpha = Math.max(alpha, -minimax(h.get(i), prof-1));
        }
        return alpha;
    }
    public static int valorMax(Nodo nodo, int alpha, int beta) {
        if (nodo.esFinal()) {
            nodo.evaluarNodo();
            return nodo.getValorHeuristico();
        }else{
            ArrayList<Nodo> h = nodo.generarHijos();
            for (int i = 0; i < h.size(); i++) {
                alpha = Math.max(alpha, valorMin(h.get(i), alpha, beta));
                if (alpha >= beta)
                    return beta;
            }
            return alpha;
        }
        //
    }


    public static int valorMin(Nodo nodo, int alpha, int beta) {
        if (nodo.esFinal()) {
            nodo.evaluarNodo();
            return nodo.getValorHeuristico();
        }else{
            ArrayList<Nodo> h = nodo.generarHijos();
            for (int i = 0; i < h.size(); i++) {
                alpha = Math.min(alpha, valorMax(h.get(i), alpha, beta));
                if (alpha >= beta)
                    return alpha;
            }
            return beta;
        }
    }
}
