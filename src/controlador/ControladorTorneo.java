
package controlador;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import modelo.Torneo;
import modelo.Partido;
import modelo.Equipo;
import vista.VistaTorneo;
import excepciones.NumeroEquiposInvalidoException;
import excepciones.SorteoInvalidoException;

public class ControladorTorneo {

    private Torneo torneo;
    private VistaTorneo vista;
    private Scanner teclado;

    public ControladorTorneo(Torneo torneo, VistaTorneo vista) {
        this.torneo = torneo;
        this.vista = vista;
        this.teclado = new Scanner(System.in);
    }

    public void iniciar() {

        int opcion = 0;

        while (opcion != 9) {

            vista.mostrarMenu();

            try {
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {

                    case 1:
                        vista.mostrarEquipos(torneo.getEquipos());
                        break;

                    case 2:
                        sortearEtapa("Octavos de final");
                        break;

                    case 3:
                        sortearEtapa("Cuartos de final");
                        break;

                    case 4:
                        sortearEtapa("Semifinales");
                        break;

                    case 5:
                        sortearEtapa("Gran final");
                        break;

                    case 6:
                        vista.mostrarEtapas(torneo.getEtapas());
                        break;

                    case 7:
                        guardarTorneo();
                        break;

                    case 8:
                        cargarTorneo();
                        break;

                    case 9:
                        vista.mostrarMensaje(
                                "¡Gracias por utilizar el sistema!"
                        );
                        break;

                    default:
                        vista.mostrarMensaje("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                vista.mostrarMensaje("Debes ingresar un número válido.");
            }
        }
    }

    private void sortearEtapa(String etapa) {

        try {
            List<Partido> partidos = torneo.sortearEtapa(
                    torneo.getParticipantesActuales(), etapa
            );

            vista.mostrarMensaje("\nSorteo de " + etapa);
            vista.mostrarPartidos(partidos);

            List<Equipo> ganadores =
                    torneo.obtenerGanadores(partidos, teclado);

            if (etapa.equals("Gran final")) {

                vista.mostrarMensaje(
                        "¡El campeón del torneo es: "
                        + ganadores.get(0).getNombre() + "!"
                );

            } else {

                torneo.actualizarParticipantes(ganadores);

                vista.mostrarMensaje(
                        "Los ganadores avanzan a la siguiente etapa."
                );
            }

        } catch (NumeroEquiposInvalidoException |
                 SorteoInvalidoException e) {

            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private void guardarTorneo() {

        try {
            torneo.guardarTorneo("torneo.dat");

            vista.mostrarMensaje(
                    "Torneo guardado correctamente."
            );

        } catch (IOException e) {
            vista.mostrarMensaje(
                    "Error al guardar: " + e.getMessage()
            );
        }
    }

    private void cargarTorneo() {

        try {
            torneo = Torneo.cargarTorneo("torneo.dat");

            vista.mostrarMensaje(
                    "Torneo cargado correctamente."
            );

        } catch (IOException | ClassNotFoundException e) {

            vista.mostrarMensaje(
                    "No se pudo cargar el torneo. "
                    + e.getMessage()
            );
        }
    }
}
