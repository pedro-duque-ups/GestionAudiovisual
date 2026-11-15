
import modelo.Torneo;
import vista.VistaTorneo;
import controlador.ControladorTorneo;

public class Main {

    public static void main(String[] args) {

        // Crear el torneo
        Torneo torneo = new Torneo();

        // Crear la vista
        VistaTorneo vista = new VistaTorneo();

        // Crear el controlador
        ControladorTorneo controlador =
                new ControladorTorneo(torneo, vista);

        // Iniciar la aplicación
        controlador.iniciar();
    }
}
