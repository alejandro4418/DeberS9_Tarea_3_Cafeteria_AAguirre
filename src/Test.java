import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    private static Scanner sc = new Scanner(System.in);
    private static Cafeteria cafeteria = new Cafeteria("Smart Coffee");

    void main(){
        int opcion;
        do{
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            switch (opcion){
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    cafeteria.mostrarClientes();
                    break;
                case 3:
                    registrarPedido();
                    break;
                case 4:
                    actualizarPedido();
                    break;
                case 5:
                    eliminarPedido();
                    break;
                case 6:
                    cafeteria.promedioConsumo();
                    break;
                case 7:
                    cafeteria.mejorCliente();
                    break;
                case 8:
                    buscarClientePorCorreo();
                    break;
                case 9:
                    cafeteria.mostrarPedido();
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente");
            }
        } while (opcion != 10);
    }

    public static void mostrarMenu(){
        System.out.println("\n========= SMART COFFEE =========");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Mostrar clientes");
        System.out.println("3. Registrar pedido");
        System.out.println("4. Actualizar pedido");
        System.out.println("5. Eliminar pedido");
        System.out.println("6. Mostrar promedio de consumo");
        System.out.println("7. Mostrar mejor cliente");
        System.out.println("8. Buscar cliente por correo");
        System.out.println("9. Mostrar pedidos registrados");
        System.out.println("10. Salir");
        System.out.println("================================");
    }
    public static int leerEntero(String mensaje){
        while (true){
            System.out.print(mensaje);
            try{
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e){
                System.out.println("Debe ingresar un numero entero");
                sc.nextLine();
                mostrarMenu();
            }
        }
    }

    public static double leerDouble(String mensaje){
        while (true){
            System.out.print(mensaje);
            try{
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e){
                System.out.println("Debe ingresar un numero valido");
                sc.nextLine();
            }
        }
    }

    public static void registrarCliente(){
        System.out.println("\n=== Registrar Cliente ===");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        int edad = leerEntero("Edad: ");
        System.out.print("Codigo del cliente: ");
        String codigoCliente = sc.nextLine();
        System.out.print("Tipo de membresia (Gold/Silver/Premium): ");
        String tipo = sc.nextLine();

        try {
            Cliente cliente = new Cliente(nombre, correo, edad, codigoCliente, tipo);
            cafeteria.registrarCliente(cliente);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void registrarPedido(){
        System.out.println("\n=== Registrar Pedido ===");
        System.out.print("Correo del cliente: ");
        String correo = sc.nextLine();
        double consumo = leerDouble("Monto del consumo: ");
        cafeteria.registrarPedido(correo, consumo);
    }

    public static void actualizarPedido(){
        System.out.println("\n=== Actualizar Pedido ===");
        System.out.print("Correo del cliente a actualizar: ");
        String correo = sc.nextLine();
        double nuevoConsumo = leerDouble("Nuevo monto del consumo: ");
        cafeteria.actualizarPedido(correo, nuevoConsumo);
    }

    public static void eliminarPedido(){
        System.out.println("\n=== Eliminar Pedido ===");
        System.out.print("Correo del cliente a eliminar: ");
        String correo = sc.nextLine();
        cafeteria.eliminarPedido(correo);
    }

    public static void buscarClientePorCorreo(){
        System.out.println("\n=== Buscar Cliente ===");
        System.out.print("Correo del cliente a buscar: ");
        String correo = sc.nextLine();
        Cliente cliente = cafeteria.buscarClientePorCorreo(correo);
        if (cliente != null){
            System.out.println("Cliente encontrado");
            System.out.println(cliente);
        } else {
            System.out.println("No se encontro un cliente con ese correo");
        }
    }
}
