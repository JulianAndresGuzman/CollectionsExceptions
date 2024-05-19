
package FabricaDeTrajes;
/**
 *
 * @author ASUS
 */
public class Blusa {
    private boolean mangaLarga;

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
