import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Cafeteria implements CrudPedido{
    private String nombreCafeteria;
    private HashSet<Cliente> clientes = new HashSet<>();
    private HashMap<String, Double> mapaPedidos = new HashMap<>();

    public Cafeteria(String nombreCafeteria) {
        this.nombreCafeteria = nombreCafeteria;
    }

    public Cliente buscarClientePorCorreo(String correo){
        for (Cliente c : clientes){
            if(c.getCorreo().equalsIgnoreCase(correo)){
                return c;
            }
        }
        return null;
    }

    public void registrarCliente(Cliente cliente){
        try {
            if (clientes.contains(cliente)){
                System.out.println("Error: Ya existe un cliente con el codigo "+cliente.getCodigoCliente());
                return;
            }
            clientes.add(cliente);
            System.out.println("Cliente registrado exitosamente");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void mostrarClientes(){
        if (clientes.isEmpty()){
            System.out.println("No hay clientes registrados");
            return;
        }
        System.out.println("\n=== Lista de Clientes ===");
        for (Cliente c : clientes){
            System.out.println(c);
        }
        System.out.println("========================================");
    }

    @Override
    public void registrarPedido(String correo, double consumo){
        if (consumo <= 0){
            System.out.println("Error: El consumo debe ser mayor a 0");
            return;
        }
        Cliente cliente = buscarClientePorCorreo(correo);
        if (cliente == null){
            System.out.println("Error: No existe un cliente con ese correo");
            return;
        }
        String codigo = cliente.getCodigoCliente();
        if (mapaPedidos.containsKey(codigo)){
            System.out.println("Error: Ya existe un pedido para este cliente");
        } else {
            mapaPedidos.put(codigo, consumo);
            System.out.println("Pedido reigstrado exitosamente");
        }
    }

    @Override
    public void actualizarPedido(String correo, double nuevoConsumo){
        if (nuevoConsumo <= 0){
            System.out.println("Error: El nuevo consumo debe ser mayor a 0");
            return;
        }
        Cliente cliente = buscarClientePorCorreo(correo);
        if (cliente == null){
            System.out.println("Error: No existe un cliente con ese correo");
            return;
        }
        String codigo = cliente.getCodigoCliente();
        if (mapaPedidos.containsKey(codigo)){
            mapaPedidos.put(codigo, nuevoConsumo);
            System.out.println("Pedido actualizado exitosamente");
        } else {
            System.out.println("Error: No existe un pedido para este cliente");
        }
    }

    @Override
    public void eliminarPedido(String correo){
        Cliente cliente = buscarClientePorCorreo(correo);
        if (cliente == null){
            System.out.println("Error: No existe un cliente con ese correo");
            return;
        }
        String codigo = cliente.getCodigoCliente();
        if (mapaPedidos.containsKey(codigo)){
            mapaPedidos.remove(codigo);
            System.out.println("Pedido eliminado correctamente");
        } else {
            System.out.println("Error: No existe un pedido para este cliente");
        }
    }

    @Override
    public double promedioConsumo(){
        if (mapaPedidos.isEmpty()){
            System.out.println("No hay pedidos registrados");
            return 0;
        }
        double suma = 0;
        for (double consumo : mapaPedidos.values()){
            suma += consumo;
        }
        double promedio = suma / mapaPedidos.size();
        System.out.printf("Promedio de consumo: $%.2f%n", promedio);
        return promedio;
    }

    @Override
    public void mejorCliente(){
        if (mapaPedidos.isEmpty()){
            System.out.println("No hay pedidos registrados");
            return;
        }
        String mejorCliente = null;
        double maxConsumo = -1;

        for (Map.Entry<String, Double> entry : mapaPedidos.entrySet()){
            if (entry.getValue()> maxConsumo){
                maxConsumo = entry.getValue();
                mejorCliente = entry.getKey();
            }
        }
        for (Cliente c : clientes){
            if(c.getCodigoCliente().equals(mejorCliente)){
                System.out.println("\nMejor cliente: "+c.getNombre());
                System.out.println("Consumo total: $"+maxConsumo);
                return;
            }
        }
    }

    public void mostrarPedido(){
        if (mapaPedidos.isEmpty()){
            System.out.println("No hay pedidos registrados");
            return;
        }
        System.out.println("\n=== Lista de Pedidos ===");
        for (Map.Entry<String, Double> entry : mapaPedidos.entrySet()){
            String codigo = entry.getKey();
            double consumo = entry.getValue();
            for (Cliente c:clientes){
                if (c.getCodigoCliente().equals(codigo)){
                    System.out.println("Cliente: "+c.getNombre()+" | Correo: "+c.getCorreo()+" | Consumo: $"+consumo);
                    break;
                }
            }
            System.out.println("===========================================");
        }
    }
}
