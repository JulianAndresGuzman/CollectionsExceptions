
package FabricaDeTrajes;

/**
 *
 * @author Jerson Reyes
 */
public class Pantalon extends Componente {
   
    private boolean conCremallera;

    public Pantalon(int id, String nombre, String talla, String color, boolean escomunitario, double precio, boolean conCremallera) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.conCremallera = conCremallera;
    }

    public boolean isConCremallera() {
        return conCremallera;
    }

    public void setConCremallera(boolean conCremallera) {
        this.conCremallera = conCremallera;
    }

    @Override
    public String toString() {
        return "****Pantalon****  " + "Nombre: " + nombre + "    Cremallera: " +conCremallera + "    id =" + id    +   "precio:" + precio ;
    } 
    
}
