import java.util.Objects;

public class Cliente extends Persona{
    private String codigoCliente;
    private String tipoMembresia;

    public Cliente() {}

    public Cliente(String nombre, String correo, int edad, String codigoCliente, String tipoMembresia) {
        super(nombre, correo, edad);
        setCodigoCliente(codigoCliente);
        setTipoMembresia(tipoMembresia);
    }

    public void setCodigoCliente(String codigoCliente) {
        if (codigoCliente == null || codigoCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El codigo del cliente no puede estar vacio");
        }
        this.codigoCliente = codigoCliente;
    }
    public void setTipoMembresia(String tipoMembresia) {
        if (tipoMembresia == null ||
                (!tipoMembresia.equalsIgnoreCase("Gold")&&
                !tipoMembresia.equalsIgnoreCase("Silver")&&
                !tipoMembresia.equalsIgnoreCase("Premium"))){
            throw new IllegalArgumentException("Error: Membresia debe ser Gold, Silver o Premium");
        }
        this.tipoMembresia = tipoMembresia;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }
    public String getTipoMembresia() {
        return tipoMembresia;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return Objects.equals(codigoCliente, cliente.codigoCliente);
    }

    @Override
    public int hashCode(){
        return Objects.hash(codigoCliente);
    }

    @Override
    public String toString(){
        return super.toString() + " | Codigo: "+codigoCliente+" | Membresia: "+tipoMembresia;
    }
}
