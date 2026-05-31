public interface CrudPedido {
    void registrarPedido(String correo, double consumo);
    void actualizarPedido(String correo, double nuevoConsumo);
    void eliminarPedido(String correo);
    double promedioConsumo();
    void mejorCliente();
}
