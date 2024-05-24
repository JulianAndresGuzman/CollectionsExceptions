package FabricaDeTrajes;

import java.util.Scanner;


// se actualizo para que se pueda pueda utilizar las nuevas funciones de actualizar y eliminar componente 

public class Main {
    public static void main(String[] args) {
        FabricaDeTrajes fabrica = new FabricaDeTrajes();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            fabrica.EscribirMenu();
            System.out.println("Seleccione una opción:");
            try {
                opcion = Integer.parseInt(scanner.nextLine()); // Leer la opción como String y luego convertirla a entero
                switch (opcion) {
                    case 1:
                        fabrica.añadirComponenteAlmacen();
                        break;
                    case 2:
                        fabrica.ListarComponentes();
                        break;
                    case 3:
                        fabrica.actualizarComponenteEnAlmacen();
                        break;
                    case 4:
                        fabrica.eliminarComponenteDelAlmacen();
                        break;
                    case 5:
                        fabrica.añadirTrajeAlmacen();
                        break;
                    case 6:
                        fabrica.ListarTrajes();
                        break;
                    case 7:
                        fabrica.activarDesactivarRebajas();
                        break;
                    case 8:
                        fabrica.crearEnvío();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);

        scanner.close();
    }
}
