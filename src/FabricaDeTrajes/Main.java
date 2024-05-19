package FabricaDeTrajes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FabricaDeTrajes fabrica = new FabricaDeTrajes();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            fabrica.EscribirMenu();
            System.out.println("Seleccione una opción:");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            try {
                switch (opcion) {
                    case 1:
                        fabrica.añadirComponenteAlmacen();
                        break;
                    case 2:
                        fabrica.ListarComponentes();
                        break;
                    case 3:
                        fabrica.añadirTrajeAlmacen();
                        break;
                    case 4:
                        fabrica.ListarTrajes();
                        break;
                    case 5:
                        fabrica.activarDesactivarRebajas();
                        break;
                    case 6:
                        fabrica.crearEnvío();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);

        scanner.close();
    }
}
