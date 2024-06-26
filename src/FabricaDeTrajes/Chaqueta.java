package FabricaDeTrajes;
/**
 *
 * @author JulianAndresGuzmanCuellar 20232215518
 */
public class Chaqueta extends Componente{
        private int numBotones;

        public Chaqueta(int id, String nombre, String talla, String color, boolean escomunitario, double precio, int numBotones) {
        super(id, nombre, talla, color, escomunitario, precio);
        setPrecio(precio + 2 * numBotones); // Ajuste de precio según el número de botones
        this.numBotones = numBotones;

    }

    public int getNumBotones() {
        return numBotones;
    }

    public void setNumBotones(int numBotones) {
        this.numBotones = numBotones;
    }
    
    @Override
    public String toString(){
        return "****Chaqueta****  " + "  Nombre:" + nombre + "     Numero de botones :" +numBotones + "    id =" + id + "    precio:" + precio;
        
    }
}
