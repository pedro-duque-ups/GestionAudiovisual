package audiovisual;

public class Cortometraje extends ContenidoAudiovisual {
    private String categoria;
    private String director;

    public Cortometraje(String titulo, int anio, int duracionMinutos, String categoria, String director) {
        super(titulo, anio, duracionMinutos);
        if (duracionMinutos > 40) throw new IllegalArgumentException("Un cortometraje debe durar como máximo 40 minutos en este sistema.");
        this.categoria = categoria;
        this.director = director;
    }

    @Override public String obtenerTipo() { return "Cortometraje"; }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Categoría: " + categoria);
        System.out.println("Director: " + director);
    }
}
