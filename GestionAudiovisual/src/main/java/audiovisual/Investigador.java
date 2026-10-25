package audiovisual;

public class Investigador {
    private String nombre;
    private String institucion;
    private String especialidad;

    public Investigador(String nombre, String institucion, String especialidad) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre obligatorio.");
        this.nombre = nombre;
        this.institucion = institucion;
        this.especialidad = especialidad;
    }

    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre + " — " + especialidad + (institucion == null || institucion.isBlank() ? "" : ", " + institucion);
    }
}
