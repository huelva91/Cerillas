import java.util.Scanner;

/**
 * Created by sergio on 28/04/15.
 */
public class Cerillas {



    public static void main(String [] arg){

         Juego();


    }

    public static void Juego(){
        Scanner entradaEscaner = new Scanner(System.in);
        int cerillas;
        int quitar = 0;
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
        }
    }
}
