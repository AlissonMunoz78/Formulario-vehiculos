public class Propietario {
    private String nombre;
    private String ID;
    private String telefono;

    public Propietario(String nombre, String ID, String telefono) {
        this.nombre = nombre;
        this.ID = ID;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
