package FabricaDeTrajes;
/**
 *
 * @author JulianAndresGuzmanCuellar 20232215518
 */
public class Chaqueta {
    private int numBotones;

    public Chaqueta(int numBotones) {
        this.numBotones = numBotones;
    }

    public int getNumBotones() {
        return numBotones;
    }

    public void setNumBotones(int numBotones) {
        this.numBotones = numBotones;
    }
    
    public String toString(){
        return "Numero de botones : " +numBotones;
        
    }
}
