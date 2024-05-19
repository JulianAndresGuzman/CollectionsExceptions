
package FabricaDeTrajes;

import java.util.ArrayList;
import java.util.TreeSet;

public abstract class FabricaDeTrajes implements iFabricaDeTrajes {
    
    private ArrayList<Componente> componentesEnAlmacen;
    private TreeSet<Traje> trajesEnAlmacen;
    private boolean sonRebajas;

    public FabricaDeTrajes() {
        this.componentesEnAlmacen = new ArrayList<>();
        this.trajesEnAlmacen = new TreeSet<>();
        this.sonRebajas = false;
    }
  
}

   
   
    

