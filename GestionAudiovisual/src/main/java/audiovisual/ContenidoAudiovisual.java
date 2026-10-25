package audiovisual;

public abstract class ContenidoAudiovisual {
    private String titulo;
    private int anio;
    private int duracionMinutos;

    public ContenidoAudiovisual(String titulo, int anio, int duracionMinutos) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (anio < 1888 || duracionMinutos <= 0) {
            throw new IllegalArgumentException("Año o duración no válidos.");
        }
        this.titulo = titulo;
        this.anio = anio;
        this.duracionMinutos = duracionMinutos;
    }

    public String getTitulo() { return titulo; }
    public int getAnio() { return anio; }
    public int getDuracionMinutos() { return duracionMinutos; }

    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Año: " + anio);
        System.out.println("Duración: " + duracionMinutos + " minutos");
    }

    public abstract String obtenerTipo();
}
