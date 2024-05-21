package FabricaDeTrajes;

/**
 *
 * @author JulianAndresGuzmanCuellar 20232215518
 */
import java.util.ArrayList;

public class Traje implements Comparable{

  

    private ArrayList<Componente> piezas;
    private String nombre;

    public Traje(String nombre, Blusa blusa, Chaqueta chaqueta) {
        this.nombre = nombre;
        this.piezas = new ArrayList<>();
        this.piezas.add(blusa);
        this.piezas.add(chaqueta);
    }

    Traje(String nombreTraje, Blusa blusa, Chaqueta chaqueta, Falda falda, Pantalon pantalon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    public int compareTo(Traje otroTraje) {
        // Aquí defines la lógica de comparación
        // Por ejemplo, puedes comparar los nombres de los trajes
        return this.nombre.compareTo(otroTraje.nombre);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Traje: ").append(nombre).append("\n");
        for (Componente componente : piezas) {
            builder.append(" - ").append(componente).append("\n");
        }
        return builder.toString();
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}