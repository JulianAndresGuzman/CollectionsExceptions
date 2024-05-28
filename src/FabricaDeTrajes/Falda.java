package FabricaDeTrajes;
/**
 *
 * @author JulianAndresGuzmanCuellar 20232215518
 */
public class Falda extends Componente {

    private boolean conCremallera;

    public Falda(int id, String nombre, String talla, String color, boolean escomunitario, double precio, boolean conCremallera) {
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
        return "****Falda****  "+ "Nombre = " + nombre + "     Tiene cremallera: " + conCremallera + "  id=" + id + "   precio:" + precio ;
    }
}
