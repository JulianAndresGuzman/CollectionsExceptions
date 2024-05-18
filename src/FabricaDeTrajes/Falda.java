package FabricaDeTrajes;
/**
 *
 * @author JulianAndresGuzmanCuellar 20232215518
 */
public class Falda {

    private boolean conCremallera;

    public Falda(boolean conCremallera) {
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
        return "Tiene cremallera: " + conCremallera;
    }
}
