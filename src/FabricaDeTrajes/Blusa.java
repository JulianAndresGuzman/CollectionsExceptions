
package FabricaDeTrajes;
/**
 *
 * @author ASUS
 */
public class Blusa extends Componente{
    private boolean mangaLarga;

    public Blusa(int id, String nombre, String talla, String color, boolean escomunitario, double precio) {
        super(id, nombre, talla, color, escomunitario, precio);
    }

    public boolean isMangaLarga() {
        return mangaLarga;
    }

    public void setMangaLarga(boolean mangaLarga) {
        this.mangaLarga = mangaLarga;
    }

    @Override
    public String toString() {
        return "Blusa{" + "mangaLarga=" + mangaLarga + '}';
    }
    
}
