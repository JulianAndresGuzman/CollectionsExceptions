
package FabricaDeTrajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public interface iFabricaDeTrajes {

  

    void añadirComponenteAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException;

    void listarComponentes();

    void añadirTrajeAlmacen() throws ColoresException, TallaException, TrajeYaExisteException;

    void listarTrajes();

    void activarDesactivarRebajas();

    void crearEnvío();

}

// NO se si esto son los nuevos requerimientos aca ud mira si le sirve si no lo elimina 

class FabricaDeTrajes implements iFabricaDeTrajes {

    private ArrayList<Componente> componentesEnAlmacen;
    private ArrayList<Traje> trajesEnAlmacen;
    private boolean sonRebajas;

    public FabricaDeTrajes() {
        this.componentesEnAlmacen = new ArrayList<>();
        this.trajesEnAlmacen = new ArrayList<>();
        this.sonRebajas = false;
    }

    @Override
    public void añadirComponenteAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tipo de componente (Blusa, Chaqueta, Falda, Pantalon):");
        String tipo = scanner.nextLine();

        // Validar que el id del componente no exista anteriormente
        System.out.print("Ingrese ID del componente: ");
        int id = scanner.nextInt();
        for (Componente comp : componentesEnAlmacen) {
            if (comp.getId() == id) {
                throw new IdException("El ID del componente ya existe.");
            }
        }

        // Más validaciones y creación de componente...
    }

    @Override
    public void listarComponentes() {
        for (Componente componente : componentesEnAlmacen) {
            System.out.println(componente);
        }
    }

    @Override
    public void añadirTrajeAlmacen() throws ColoresException, TallaException, TrajeYaExisteException {
        // Implementar lógica para añadir un traje al almacén
    }

    @Override
    public void listarTrajes() {
        for (Traje traje : trajesEnAlmacen) {
            System.out.println(traje);
        }
    }

    @Override
    public void activarDesactivarRebajas() {
        // Implementar lógica para activar/desactivar rebajas
    }

    @Override
    public void crearEnvío() {
        // Implementar lógica para crear un envío
    }
}




//Aca se enceuntra las excepciones 

class IdException extends Exception {
    public IdException(String message) {
        super(message);
    }
}

class MuchoExtracomunitarioException extends Exception {
    public MuchoExtracomunitarioException(String message) {
        super(message);
    }
}

class MangaException extends Exception {
    public MangaException(String message) {
        super(message);
    }
}

class ColoresException extends Exception {
    public ColoresException(String message) {
        super(message);
    }
}

class TallaException extends Exception {
    public TallaException(String message) {
        super(message);
    }
}

class TrajeYaExisteException extends Exception {
    public TrajeYaExisteException(String message) {
        super(message);
    }
}
    