package audiovisual;

public class Actor {
    private String nombre;
    private String nacionalidad;

    public Actor(String nombre, String nacionalidad) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre obligatorio.");
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }

    @Override
    public String toString() {
        return nombre + (nacionalidad == null || nacionalidad.isBlank() ? "" : " (" + nacionalidad + ")");
    }
}
