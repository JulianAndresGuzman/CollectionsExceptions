
package FabricaDeTrajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public interface iFabricaDeTrajes {
  

    void añadirComponenteAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException;

    void ListarComponentes();

    void añadirTrajeAlmacen() throws ColoresException, TallaException, TrajeYaExisteException;

    void ListarTrajes();

    void activarDesactivarRebajas();

    void crearEnvío();

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
    