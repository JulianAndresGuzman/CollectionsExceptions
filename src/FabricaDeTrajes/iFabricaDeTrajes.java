
package FabricaDeTrajes;

import java.util.List;

    public interface iFabricaDeTrajes {

      void añadirComponenteAlmacen(); //throws IdException, MuchoExtracomunitarioException, MangaException;
      void ListarComponentes();
      void añadirTrajeAlmacen(); //throws ColoresException, TallaException, TrajeYaExisteException
      void ListarTrajes();
      void activarDesactivarRebajas();
      void crearEnvío();

    
}
    