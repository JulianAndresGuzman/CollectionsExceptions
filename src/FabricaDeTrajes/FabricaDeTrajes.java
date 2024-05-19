package FabricaDeTrajes;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.*;
import java.io.IOException;

class FabricaDeTrajes implements iFabricaDeTrajes {

    private ArrayList<Componente> componentesEnAlmacen;
    private TreeSet<Traje> trajesEnAlmacen;
    private boolean sonRebajas;

    public FabricaDeTrajes() {
        this.componentesEnAlmacen = new ArrayList<>();
        this.trajesEnAlmacen = new TreeSet<>();
        this.sonRebajas = false;
    }

    public void EscribirMenu() {

        System.out.println("***************************************");
        System.out.println("MENU FABRICA DE TRAJES");
        System.out.println("1.- Añadir Componente a almacén");
        System.out.println("2.- Listar Componentes del almacén");
        System.out.println("3.- Crear traje y añadir a almacén");
        System.out.println("4.- Listar trajes del almacén");
        System.out.println("5.- Activar/Desactivar las rebajas");
        System.out.println("6.- Crear envío");
        System.out.println("7.- Crea componentes de prueba");
        System.out.println("0.- Salir");
        System.out.println("****************************************");

    }

    @Override
    public void añadirComponenteAlmacen() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese ID del componente: ");
        int id = in.nextInt();
        in.nextLine(); // Consumir newline
        for (Componente comp : componentesEnAlmacen) {
            if (comp.getId() == id) {
                System.out.println("El ID del componente ya existe.");
                return;
            }
        }
        
        System.out.print("Ingrese nombre del componente: ");
        String nombre = in.nextLine();

        System.out.print("Ingrese talla del componente: ");
        String talla = in.nextLine();

        System.out.print("Ingrese color del componente: ");
        String color = in.nextLine();

        System.out.print("Es comunitario (true/false): ");
        boolean escomunitario = in.nextBoolean();

        System.out.print("Ingrese precio del componente: ");
        double precio = in.nextDouble();
        
        Componente nuevoComponente = new Componente(id, nombre, talla, color, escomunitario, precio);

    }
    
    
    @Override
    public void ListarComponentes() {
        for (Componente componente : componentesEnAlmacen) {
            System.out.println(componente);
        }
    }

    @Override
    public void añadirTrajeAlmacen() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ListarTrajes() {
        for (Traje traje : trajesEnAlmacen) {
            System.out.println(traje);
        }
    }

    @Override
    public void activarDesactivarRebajas() {
        sonRebajas = !sonRebajas;
        if (sonRebajas) {
            for (Componente componente : componentesEnAlmacen) {
                componente.setPrecio(componente.getPrecio() * 0.9); // Aplicar 10% de descuento
            }
            for (Traje traje : trajesEnAlmacen) {
                // Aplicar descuento en los componentes del traje
                traje.getChaqueta().setPrecio(traje.getChaqueta().getPrecio() * 0.9);
                traje.getBlusa().setPrecio(traje.getBlusa().getPrecio() * 0.9);
                traje.getParteInferior().setPrecio(traje.getParteInferior().getPrecio() * 0.9);
            }
        } else {
            // Restaurar precios originales si es necesario
        }
    }

    @Override
    public void crearEnvío() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
