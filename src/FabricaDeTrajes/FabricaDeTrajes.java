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

    void EscribirMenu() {

        System.out.println("***************************************");
        System.out.println("* MENU FABRICA DE TRAJES              *"); 
        System.out.println("* 1.- Agregar Componente a almacen    *");
        System.out.println("* 2.- Listar Componentes del almacen  *");
        System.out.println("* 3.- Crear traje y agregar a almacen *");
        System.out.println("* 4.- Listar trajes del almacen       *");
        System.out.println("* 5.- Activar/Desactivar las rebajas  *");
        System.out.println("* 6.- Crear envio                     *");
        System.out.println("* 0.- Salir                           *");
        System.out.println("***************************************");

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

    @Override
    public void añadirTrajeAlmacen() {

    }

    public void ListarTrajes() {

        for (Traje traje : trajesEnAlmacen) {
            System.out.println(traje);
        }

    }

    @Override
    public void activarDesactivarRebajas() {
    }

    @Override
    public void crearEnvío() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

   
}
