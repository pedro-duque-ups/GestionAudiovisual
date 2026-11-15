
package vista;

import java.util.List;
import java.util.Map;

import modelo.Equipo;
import modelo.Partido;

public class VistaTorneo {

    // Mostrar menú principal
    public void mostrarMenu() {

        System.out.println("\n================================");
        System.out.println("   LIGA PROFESIONAL DE FUTBOL");
        System.out.println("================================");
        System.out.println("1. Mostrar equipos");
        System.out.println("2. Realizar sorteo de octavos");
        System.out.println("3. Realizar sorteo de cuartos");
        System.out.println("4. Realizar sorteo de semifinales");
        System.out.println("5. Realizar sorteo de la final");
        System.out.println("6. Mostrar resultados");
        System.out.println("7. Guardar torneo");
        System.out.println("8. Cargar torneo");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    // Mostrar equipos participantes
    public void mostrarEquipos(List<Equipo> equipos) {

        System.out.println("\n===== EQUIPOS PARTICIPANTES =====");

        for (Equipo equipo : equipos) {
            System.out.println(equipo);
        }
    }

    // Mostrar partidos de una etapa
    public void mostrarPartidos(List<Partido> partidos) {

        System.out.println("\n===== PARTIDOS DEL SORTEO =====");

        for (Partido partido : partidos) {
            System.out.println(partido);
        }
    }

    // Mostrar todas las etapas del torneo
    public void mostrarEtapas(Map<String, List<Partido>> map) {

        if (map.isEmpty()) {
            System.out.println("Todavía no hay sorteos realizados.");
            return;
        }

        for (Map.Entry<String, List<Partido>> entrada : map.entrySet()) {

            System.out.println("\n===== " + entrada.getKey() + " =====");

            for (Partido partido : entrada.getValue()) {
                System.out.println(partido);
            }
        }
    }

    // Mostrar mensajes
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
