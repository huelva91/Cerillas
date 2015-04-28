import java.util.Scanner;

/**
 * Created by sergio on 28/04/15.
 */
public class Cerillas {



    public static void main(String [] arg){

        Scanner entradaEscaner = new Scanner(System.in);
        String cerillas;
        System.out.println("Bienvenido al juego de las cerilas");
        System.out.println("¿Cuántas cerillas hay en la fila?:");
        cerillas = entradaEscaner.nextLine();
        System.out.printf("La entrada recibida es " + cerillas);

    }
}
