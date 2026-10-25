package audiovisual;

import java.util.ArrayList;
import java.util.List;

public class Documental extends ContenidoAudiovisual implements Detallable {
    private String tema;
    // Asociación: un investigador puede colaborar en diferentes documentales.
    private final List<Investigador> investigadores = new ArrayList<>();

    public Documental(String titulo, int anio, int duracionMinutos, String tema) {
        super(titulo, anio, duracionMinutos);
        this.tema = tema;
    }

    public void agregarInvestigador(Investigador investigador) {
        if (investigador == null) throw new IllegalArgumentException("El investigador no puede ser null.");
        if (!investigadores.contains(investigador)) investigadores.add(investigador);
    }

    @Override public String obtenerTipo() { return "Documental"; }

    @Override
    public void mostrarDetallesGenerales() {
        super.mostrarDetalles();
        System.out.println("Tipo: " + obtenerTipo());
    }

    @Override
    public void mostrarDetallesEspecificos() {
        System.out.println("Tema: " + tema);
        System.out.println("Investigadores: " + (investigadores.isEmpty() ? "Sin investigadores registrados" : investigadores));
    }
}
