public class Persona {
    private String nombre;
    private String correo;
    private int edad;

    public Persona() {}

    public Persona(String nombre, String correo, int edad) {
        setNombre(nombre);
        setCorreo(correo);
        setEdad(edad);
    }
//Setters
    public void setCorreo(String correo) {
        if (correo == null || !correo.contains("@")){
            throw new IllegalArgumentException("Error: El correo debe contener '@'");
        }
        this.correo = correo;
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Error: El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        if (edad < 18 || edad > 60){
            throw new IllegalArgumentException("Error: La edad debe estar entre 18 y 60 años");
        }
        this.edad = edad;
    }
//Getters
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public int getEdad() {
        return edad;
    }

    @Override
    public String toString(){
        return "Nombre: "+nombre+" | Correo: "+correo+" | Edad: "+edad;
    }
}
