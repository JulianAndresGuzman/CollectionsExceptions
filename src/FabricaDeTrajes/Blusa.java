package FabricaDeTrajes;

public class Blusa extends Componente {

    private boolean mangaLarga;


    public Blusa(int id, String nombre, String talla, String color, boolean escomunitario, double precio, boolean mangaLarga) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.mangaLarga = mangaLarga;
        
    }

    public boolean isMangaLarga() {
        return mangaLarga;
    }

    public void setMangaLarga(boolean mangaLarga) {
        this.mangaLarga = mangaLarga;
    }

    @Override
    public String toString() {
        return "****Blusa****  " + "Nombre:" + nombre + "    Es manga larga:" + mangaLarga + "     id =" + id + "    precio:" + precio;
    }

}
