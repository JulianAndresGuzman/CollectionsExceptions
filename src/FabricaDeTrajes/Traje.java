package FabricaDeTrajes;

/**
 *
 * @author JulianAndresGuzmanCuellar 20232215518
 */
import java.util.ArrayList;

public class Traje {

    private ArrayList<Componente> piezas;
    private String nombre;
    private String nombreTraje;

    public Traje(ArrayList<Componente> piezas, String nombre) {
        this.piezas = piezas;
        this.nombre = nombre;
    }

    Traje(String nombreTraje, Componente blusa, Componente chaqueta, Componente falda, Componente pantalon) {
        this.nombreTraje = nombreTraje;
        
            }

    
    public ArrayList<Componente> getPiezas() {
        return piezas;
    }

    public void setPiezas(ArrayList<Componente> piezas) {
        this.piezas = piezas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "piezas: " + piezas + "nombre: " + nombre;
    }

}
