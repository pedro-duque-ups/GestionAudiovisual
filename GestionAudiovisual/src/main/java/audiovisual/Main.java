package audiovisual;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Actor actor1 = new Actor("María Fernanda", "Ecuatoriana");
        Actor actor2 = new Actor("Carlos Ruiz", "Colombiana");

        Pelicula pelicula = new Pelicula("Historias del camino", 2024, 110, "Andrea López");
        pelicula.agregarActor(actor1);
        pelicula.agregarActor(actor2);

        SerieDeTV serie = new SerieDeTV("Código abierto", 2023, 45, 3);
        serie.agregarTemporada(1, 8);
        serie.agregarTemporada(2, 10);

        Investigador investigador = new Investigador("Dr. Luis Andrade", "Instituto Andino", "Biodiversidad");
        Documental documental = new Documental("La vida del bosque", 2025, 52, "Naturaleza");
        documental.agregarInvestigador(investigador);

        Cortometraje corto = new Cortometraje("Un minuto de lluvia", 2022, 18, "Drama", "Sofía Vega");
        VideoYouTube video = new VideoYouTube("Java desde cero", 2025, 12, "Aprende Código", "https://youtube.com/", 1200);
        video.sumarVisualizaciones(300);

        List<ContenidoAudiovisual> catalogo = new ArrayList<>();
        catalogo.add(pelicula);
        catalogo.add(serie);
        catalogo.add(documental);
        catalogo.add(corto);
        catalogo.add(video);

        System.out.println("===== CATÁLOGO AUDIOVISUAL =====");
        for (ContenidoAudiovisual contenido : catalogo) {
            System.out.println("\\n-------------------------------");
            System.out.println("Tipo de contenido: " + contenido.obtenerTipo());
            contenido.mostrarDetalles();
            if (contenido instanceof Detallable) {
                ((Detallable) contenido).mostrarFicha();
            }
        }
    }
}
