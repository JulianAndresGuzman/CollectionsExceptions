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

    void EscribirMenu() {

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

        if (escomunitario) {
            long countExtracomunitarios = componentesEnAlmacen.stream().filter(Componente::isEscomunitario).count();
            if (countExtracomunitarios > componentesEnAlmacen.size() / 2) {
                System.out.println("No se puede añadir más del 50% de componentes extracomunitarios.");
                return;
            }
        }
        // Verificar condiciones especiales para Blusa y Chaqueta
        if (nuevoComponente instanceof Blusa) {
            Blusa blusa = (Blusa) nuevoComponente;
            boolean existeMangaCorta = componentesEnAlmacen.stream().anyMatch(c -> c instanceof Blusa && !((Blusa) c).isMangaLarga() && c.getColor().equals(blusa.getColor()));
            boolean existeMangaLarga = componentesEnAlmacen.stream().anyMatch(c -> c instanceof Blusa && ((Blusa) c).isMangaLarga() && c.getColor().equals(blusa.getColor()));

            if (blusa.isMangaLarga() && !existeMangaCorta || !blusa.isMangaLarga() && !existeMangaLarga) {
                System.out.println("No se puede añadir la blusa. Debe existir una blusa de manga corta o larga del mismo color.");
                return;
            }
        }

        componentesEnAlmacen.add(nuevoComponente);
        System.out.println("Componente añadido con éxito.");
    }

    public void ListarComponentes() {
        for (Componente componente : componentesEnAlmacen) {
            System.out.println(componente);
        }
    }

    @Override
    public void añadirTrajeAlmacen() {

        Scanner in = new Scanner(System.in);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Blusas disponibles:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Blusa).forEach(System.out::println);

        System.out.print("Ingrese ID de la blusa: ");
        int blusaId = scanner.nextInt();
        Componente blusa = componentesEnAlmacen.stream().filter(c -> c.getId() == blusaId && c instanceof Blusa).findFirst().orElse(null);

        if (blusa == null) {
            System.out.println("Blusa no encontrada.");
            return;
        }

        System.out.println("Chaquetas disponibles:");
        componentesEnAlmacen.stream().filter(c -> c instanceof Chaqueta).forEach(System.out::println);

        System.out.print("Ingrese ID de la chaqueta: ");
        int chaquetaId = scanner.nextInt();
        Componente chaqueta = componentesEnAlmacen.stream().filter(c -> c.getId() == chaquetaId && c instanceof Chaqueta).findFirst().orElse(null);

        if (chaqueta == null) {
            System.out.println("Chaqueta no encontrada.");
            return;
        }

        System.out.print("Ingrese el nombre del traje: ");
        scanner.nextLine(); // Consumir newline
        String nombreTraje = scanner.nextLine();

        for (Traje traje : trajesEnAlmacen) {
            if (traje.getNombre().equals(nombreTraje)) {
                System.out.println("Ya existe un traje con ese nombre.");
                return;
            }
        }

        System.out.println("Traje añadido con éxito.");

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
