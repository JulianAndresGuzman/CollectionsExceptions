package FabricaDeTrajes;

import java.util.ArrayList;

public class Traje implements Comparable<Traje> {

    private static int idCounter = 1; // Counter for generating unique IDs
    private int id; // ID único para cada traje
    private ArrayList<Componente> piezas;
    private String nombre;

    public Traje(String nombre, Blusa blusa, Chaqueta chaqueta) {
        this.id = idCounter++;
        this.nombre = nombre;
        this.piezas = new ArrayList<>();
        this.piezas.add(blusa);
        this.piezas.add(chaqueta);
    }

    public Traje(String nombre, Blusa blusa, Chaqueta chaqueta, Falda falda, Pantalon pantalon) {
        this.id = idCounter++;
        this.nombre = nombre;
        this.piezas = new ArrayList<>();
        this.piezas.add(blusa);
        this.piezas.add(chaqueta);
        if (falda != null) this.piezas.add(falda);
        if (pantalon != null) this.piezas.add(pantalon);
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
    
    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Traje otroTraje) {
        return this.nombre.compareTo(otroTraje.nombre);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Traje ID: ").append(id).append(", Nombre: ").append(nombre).append("\n");
        for (Componente componente : piezas) {
            builder.append(" - ").append(componente).append("\n");
        }
        return builder.toString();
    }
}