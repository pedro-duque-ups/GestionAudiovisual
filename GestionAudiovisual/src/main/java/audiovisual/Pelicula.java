package audiovisual;

import java.util.ArrayList;
import java.util.List;

public class Pelicula extends ContenidoAudiovisual implements Detallable {
    private String director;
    // Agregación: los actores existen independientemente de una película.
    private final List<Actor> actores = new ArrayList<>();

    public Pelicula(String titulo, int anio, int duracionMinutos, String director) {
        super(titulo, anio, duracionMinutos);
        this.director = director;
    }

    public void agregarActor(Actor actor) {
        if (actor == null) throw new IllegalArgumentException("El actor no puede ser null.");
        if (!actores.contains(actor)) actores.add(actor);
    }

    public List<Actor> getActores() { return List.copyOf(actores); }
    @Override public String obtenerTipo() { return "Película"; }

    @Override
    public void mostrarDetallesGenerales() {
        super.mostrarDetalles();
        System.out.println("Tipo: " + obtenerTipo());
    }

    @Override
    public void mostrarDetallesEspecificos() {
        System.out.println("Director: " + director);
        System.out.println("Actores: " + (actores.isEmpty() ? "Sin actores registrados" : actores));
    }
}
