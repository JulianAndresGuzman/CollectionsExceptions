
package FabricaDeTrajes;

/**
 *
 * @author Jerson Reyes
 */
public class Pantalon {
   
    private boolean conCremallera;

    public boolean isConCremallera() {
        return conCremallera;
    }

    public void setConCremallera(boolean conCremallera) {
        this.conCremallera = conCremallera;
    }

    @Override
    public String toString() {
        return "Pantalon{" + "conCremallera=" + conCremallera + '}';
    }
    
}
