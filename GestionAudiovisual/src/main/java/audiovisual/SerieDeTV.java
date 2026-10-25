package audiovisual;

import java.util.ArrayList;
import java.util.List;

public class SerieDeTV extends ContenidoAudiovisual implements Detallable {
    private int temporadasPlaneadas;
    // Composición: la serie administra las temporadas creadas para ella.
    private final List<Temporada> temporadas = new ArrayList<>();

    public SerieDeTV(String titulo, int anio, int duracionMinutos, int temporadasPlaneadas) {
        super(titulo, anio, duracionMinutos);
        if (temporadasPlaneadas < 1) throw new IllegalArgumentException("Debe existir al menos una temporada planeada.");
        this.temporadasPlaneadas = temporadasPlaneadas;
    }

    public void agregarTemporada(int numero, int episodios) {
        if (temporadas.size() >= temporadasPlaneadas) {
            throw new IllegalStateException("Ya se registraron todas las temporadas planeadas.");
        }
        for (Temporada t : temporadas) {
            if (t.getNumero() == numero) throw new IllegalArgumentException("La temporada ya existe.");
        }
        temporadas.add(new Temporada(numero, episodios));
    }

    public List<Temporada> getTemporadas() { return List.copyOf(temporadas); }
    @Override public String obtenerTipo() { return "Serie de TV"; }

    @Override
    public void mostrarDetallesGenerales() {
        super.mostrarDetalles();
        System.out.println("Tipo: " + obtenerTipo());
    }

    @Override
    public void mostrarDetallesEspecificos() {
        System.out.println("Temporadas planeadas: " + temporadasPlaneadas);
        System.out.println("Temporadas registradas: " + (temporadas.isEmpty() ? "Ninguna" : temporadas));
    }
}
