
import java.util.ArrayList;

public class Nodo {

    private int cerillas; //En valor guardamos el número que dejariamos al otro jugador para jugar.
    private Nodo padre;
    private int valorHeuristico;
    private int profundidad;

    public Nodo() {
        cerillas = (int) (40*Math.random());
        profundidad = 0;
        evaluarNodo();
    }

    public Nodo(int val) {
        this.cerillas = val;
        profundidad = 0;
        evaluarNodo();
    }

    public ArrayList<Nodo> generarHijos() {
        ArrayList<Nodo> hijos = new ArrayList<Nodo>();
        for (int i = 1; i <= cerillas; i++) {
            Nodo aux = new Nodo(cerillas - i*i);
            aux.padre = this;
            aux.profundidad++;
            hijos.add(aux);
        }
        return hijos;
    }

    public void evaluarNodo() {
        if (cerillas == 0)
            valorHeuristico = 100;



    }

    public int getProfundidad() {
        return profundidad;
    }

    public int getValor() {
        return cerillas;
    }

    public Nodo getPadre() {
        return padre;
    }

    public int getValorHeuristico() {
        return valorHeuristico;
    }

    public boolean esFinal(){
        if (cerillas%1 == 0 || cerillas == 0)
            return true;
        else
            return false;
    }

    public void setValorHeuristico(int valor){
        valorHeuristico = valor;
    }

}
