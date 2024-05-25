     package FabricaDeTrajes;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.*;
import java.io.IOException;

class FabricaDeTrajes implements iFabricaDeTrajes {

    private ArrayList<Componente> componentesEnAlmacen;
    private TreeSet<Traje> trajesEnAlmacen;
    private List<Componente> componentes = new ArrayList<>();

    private boolean sonRebajas;

    
    public FabricaDeTrajes() {
        this.componentesEnAlmacen = new ArrayList<>();
        this.trajesEnAlmacen = new TreeSet<>();
        this.sonRebajas = false;
    }
// Se actualizo el metodo del menu
    void EscribirMenu() {
    System.out.println("***************************************");
    System.out.println("MENU FABRICA DE TRAJES");
    System.out.println("1.- Añadir Componente a almacén");
    System.out.println("2.- Listar Componentes del almacén");
    System.out.println("3.- Actualizar Componente en el almacén");
    System.out.println("4.- Eliminar Componente del almacén");
    System.out.println("5.- Crear traje y añadir a almacén");
    System.out.println("6.- Listar trajes del almacén");
    System.out.println("7.- Activar/Desactivar las rebajas");
    System.out.println("8.- Crear envío");
    System.out.println("0.- Salir");
    System.out.println("****************************************");
}


    @Override
    public void añadirComponenteAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese ID:");
        int id = in.nextInt();
        in.nextLine(); // consume newline
        System.out.println("Ingrese nombre:");
        String nombre = in.nextLine();
        System.out.println("Ingrese talla:");
        String talla = in.nextLine();
        System.out.println("Ingrese color:");
        String color = in.nextLine();
        System.out.println("Es comunitario? (true/false):");
        boolean escomunitario = in.nextBoolean();
        System.out.println("Ingrese precio:");
        double precio = in.nextDouble();

        int opcion;
        System.out.println("Que tipo de componente es?");
        System.out.println("1.- Blusa");
        System.out.println("2.- Chaqueta");
        System.out.println("3.- Falda");
        System.out.println("4.- Pantalon");
        opcion = in.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Es con manga Larga? (false/true)");
                boolean mangaLarga = in.nextBoolean();
                Blusa blusa = new Blusa(id, nombre, talla, color, escomunitario, precio, mangaLarga);
                componentesEnAlmacen.add(blusa);
                break;

            case 2:
                System.out.println("Cuantos numeros de botones tiene?");
                int numbotones = in.nextInt();
                Chaqueta chaqueta = new Chaqueta(id, nombre, talla, color, escomunitario, precio, numbotones);
                componentesEnAlmacen.add(chaqueta);
                break;

            case 3:
                System.out.println("Tiene cremallera (false/true)");
                boolean cremallera = in.nextBoolean();
                Falda falda = new Falda(id, nombre, talla, color, escomunitario, precio, cremallera);
                componentesEnAlmacen.add(falda);
                break;

            case 4:
                System.out.println("Tiene cremallera (false/true)");
                boolean cremallera2 = in.nextBoolean();
                Pantalon pantalon = new Pantalon(id, nombre, talla, color, escomunitario, precio, cremallera2);
                componentesEnAlmacen.add(pantalon);

                break;
            default:
                System.out.println("Ingresa una opción válida");
                break;
        }
        System.out.println("Componente añadido con exito");
    }

    public void ListarComponentes() {
        for (Componente componente : componentesEnAlmacen) {
            System.out.println(componente);
        }
    }
    
//////////////////////////////////////////////////////////////////////
    
   @Override
    public void añadirTrajeAlmacen() {
        Scanner scanner = new Scanner(System.in);

        // Listar y seleccionar Blusa
        System.out.println("Blusas disponibles:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Blusa).forEach(System.out::println);
        System.out.print("Ingrese ID de la blusa: ");
        int blusaId = scanner.nextInt();
        Blusa blusa = (Blusa) componentesEnAlmacen.stream().filter(c -> c.getId() == blusaId && c instanceof Blusa).findFirst().orElse(null);

        if (blusa == null) {
            System.out.println("Blusa no encontrada.");
            return;
        }

        // Listar y seleccionar Chaqueta
        System.out.println("Chaquetas disponibles:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Chaqueta).forEach(System.out::println);
        System.out.print("Ingrese ID de la chaqueta: ");
        int chaquetaId = scanner.nextInt();
        Chaqueta chaqueta = (Chaqueta) componentesEnAlmacen.stream().filter(c -> c.getId() == chaquetaId && c instanceof Chaqueta).findFirst().orElse(null);

        if (chaqueta == null) {
            System.out.println("Chaqueta no encontrada.");
            return;
        }

        // Listar y seleccionar Falda (opcional)
        System.out.println("Faldas disponibles:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Falda).forEach(System.out::println);
        System.out.print("Ingrese ID de la falda (opcional, -1 para omitir): ");
        int faldaId = scanner.nextInt();
        Falda falda = null;
        if (faldaId != -1) {
            falda = (Falda) componentesEnAlmacen.stream().filter(c -> c.getId() == faldaId && c instanceof Falda).findFirst().orElse(null);
            if (falda == null) {
                System.out.println("Falda no encontrada.");
                return;
            }
        }

        // Listar y seleccionar Pantalón (opcional)
        System.out.println("Pantalones disponibles:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Pantalon).forEach(System.out::println);
        System.out.print("Ingrese ID del pantalón (opcional, -1 para omitir): ");
        int pantalonId = scanner.nextInt();
        Pantalon pantalon = null;
        if (pantalonId != -1) {
            pantalon = (Pantalon) componentesEnAlmacen.stream().filter(c -> c.getId() == pantalonId && c instanceof Pantalon).findFirst().orElse(null);
            if (pantalon == null) {
                System.out.println("Pantalón no encontrado.");
                return;
            }
        }

        System.out.print("Ingrese el nombre del traje: ");
        scanner.nextLine(); // Consumir newline
        String nombreTraje = scanner.nextLine();

        Traje traje = new Traje(nombreTraje, blusa, chaqueta, falda, pantalon);
        trajesEnAlmacen.add(traje);
        System.out.println("Traje añadido con éxito.");
    }

    @Override
    public void ListarTrajes() {
        for (Traje traje : trajesEnAlmacen) {
            System.out.println(traje);
        }
    }

    @Override
    public void activarDesactivarRebajas() {
        sonRebajas = !sonRebajas; // Cambia el estado de las rebajas
        if (sonRebajas) {
            System.out.println("Rebajas activadas.");
        } else {
            System.out.println("Rebajas desactivadas.");
        }
    }
    
    
    // En esta parte de añadio los nuevos metodos para que funcione 
    
    public void actualizarComponenteEnAlmacen() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el ID del componente a actualizar: ");
    int idComponente = scanner.nextInt();

    // Buscar el componente en la lista
    for (Componente componente : componentesEnAlmacen) {
        if (componente.getId() == idComponente) {
            System.out.println("Ingrese los nuevos datos del componente:");
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Talla: ");
            String talla = scanner.next();
            System.out.print("Color: ");
            String color = scanner.next();
            System.out.print("Es comunitario? (true/false): ");
            boolean escomunitario = scanner.nextBoolean();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();

            // Crear un nuevo componente con los nuevos datos
            Componente nuevoComponente = new Componente(idComponente, nombre, talla, color, escomunitario, precio);

            // Actualizar el componente en la lista
            componente.actualizar(nuevoComponente);

            System.out.println("Componente actualizado correctamente.");
            return; // Salir del método una vez que se ha actualizado el componente
        }
    }

    // Si llegamos aquí, significa que no se encontró el componente con el ID proporcionado
    System.out.println("No se encontró un componente con el ID especificado.");

}
    public void eliminarComponenteDelAlmacen() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el ID del componente a eliminar: ");
    int idComponente = scanner.nextInt();

    // Utilizamos un iterador para recorrer la lista y eliminar el componente
    Iterator<Componente> iterator = componentesEnAlmacen.iterator();
    while (iterator.hasNext()) {
        Componente componente = iterator.next();
        if (componente.getId() == idComponente) {
            iterator.remove();
            System.out.println("Componente eliminado del almacén.");
            return; // Salimos del método una vez que se ha eliminado el componente
        }
    }

    // Si llegamos aquí, significa que no se encontró el componente con el ID proporcionado
    System.out.println("No se encontró un componente con el ID especificado.");
}


    
//////////////////////////////////////////////////

public void crearEnvío() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese la información del envío:");
    System.out.print("Destino: ");
    String destino = scanner.nextLine();
    System.out.print("Fecha de envío (dd/mm/aaaa): ");
    String fechaEnvio = scanner.nextLine();
    System.out.print("Tipo de envío (express/normal): ");
    String tipoEnvio = scanner.nextLine();

    System.out.println("Lista de trajes disponibles para envío:");
    for (Traje traje : trajesEnAlmacen) {
        System.out.println(traje);
    }

    System.out.println("Ingrese los IDs de los trajes a enviar, separados por comas:");
    String ids = scanner.nextLine();
    String[] idsArray = ids.split(",");

    List<Traje> trajesSeleccionados = new ArrayList<>();
    for (String id : idsArray) {
        int trajeId = Integer.parseInt(id.trim());
        Traje traje = trajesEnAlmacen.stream().filter(t -> t.getId() == trajeId).findFirst().orElse(null);
        if (traje != null) {
            trajesSeleccionados.add(traje);
        }
    }

    // Eliminar los trajes seleccionados del almacén
    trajesEnAlmacen.removeAll(trajesSeleccionados);

    System.out.println("Envío creado con éxito. Trajes enviados:");
    for (Traje traje : trajesSeleccionados) {
        System.out.println(traje);{
        
    }
    }
    
}

}
    