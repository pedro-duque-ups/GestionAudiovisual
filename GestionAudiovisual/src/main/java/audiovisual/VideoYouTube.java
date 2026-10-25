package audiovisual;

public class VideoYouTube extends ContenidoAudiovisual {
    private String canal;
    private String url;
    private int visualizaciones;

    public VideoYouTube(String titulo, int anio, int duracionMinutos, String canal, String url, int visualizaciones) {
        super(titulo, anio, duracionMinutos);
        if (visualizaciones < 0) throw new IllegalArgumentException("Las visualizaciones no pueden ser negativas.");
        this.canal = canal;
        this.url = url;
        this.visualizaciones = visualizaciones;
    }

    public void sumarVisualizaciones(int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser positiva.");
        visualizaciones += cantidad;
    }

    @Override public String obtenerTipo() { return "Video de YouTube"; }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Canal: " + canal);
        System.out.println("URL: " + url);
        System.out.println("Visualizaciones: " + visualizaciones);
    }
}
