package FabricaDeTrajes;

public class Componente {

    private int id;
    private String nombre;
    private String talla;
    private String color;
    private boolean escomunitario;
    private double precio;

    public Componente(int id, String nombre, String talla, String color, boolean escomunitario, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.escomunitario = escomunitario;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEscomunitario() {
        return escomunitario;
    }

    public void setEscomunitario(boolean escomunitario) {
        this.escomunitario = escomunitario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "id: " + id + " talla: " + talla + " color : " + color + " es comunitario: " + escomunitario + "precio : " + precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Componente otro) {
        return Integer.compare(this.id, otro.id);
    }
    
}
