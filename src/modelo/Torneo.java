
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import excepciones.NumeroEquiposInvalidoException;
import excepciones.SorteoInvalidoException;

public class Torneo implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Equipo> equipos;
    private Map<String, List<Partido>> etapas;
    private List<Equipo> participantesActuales;

    public Torneo() {

        equipos = new ArrayList<>();
        etapas = new LinkedHashMap<>();

        String[] nombres = {
            "Barcelona", "Real Madrid", "Manchester City",
            "Liverpool", "Bayern Munich", "PSG",
            "Arsenal", "Chelsea", "Juventus",
            "Inter Milan", "AC Milan", "Borussia Dortmund",
            "Atletico Madrid", "Napoli", "Benfica", "Porto"
        };

        for (String nombre : nombres) {
            equipos.add(new Equipo(nombre));
        }

        participantesActuales = new ArrayList<>(equipos);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public Map<String, List<Partido>> getEtapas() {
        return etapas;
    }

    public List<Equipo> getParticipantesActuales() {
        return participantesActuales;
    }

    // Actualizar los equipos que avanzan de etapa
    public void actualizarParticipantes(List<Equipo> ganadores) {

        if (ganadores == null) {
            throw new IllegalArgumentException(
                "La lista de ganadores no puede ser nula."
            );
        }

        participantesActuales = new ArrayList<>(ganadores);
    }

    // Validar cantidad y nombres de equipos
    private void validarEquipos(List<Equipo> equipos)
            throws NumeroEquiposInvalidoException {

        if (equipos == null || equipos.size() < 2
                || (equipos.size() & (equipos.size() - 1)) != 0) {

            throw new NumeroEquiposInvalidoException(
                "La cantidad de equipos debe ser una potencia de 2."
            );
        }

        Set<String> nombres = new HashSet<>();

        for (Equipo equipo : equipos) {

            if (equipo == null ||
                    !nombres.add(equipo.getNombre())) {

                throw new NumeroEquiposInvalidoException(
                    "Hay equipos repetidos o inválidos."
                );
            }
        }
    }

    // Realizar sorteo de una etapa
    public List<Partido> sortearEtapa(
            List<Equipo> participantes, String etapa)
            throws NumeroEquiposInvalidoException,
                   SorteoInvalidoException {

        validarEquipos(participantes);

        if (etapas.containsKey(etapa)) {
            throw new SorteoInvalidoException(
                "Esta etapa ya fue sorteada."
            );
        }

        int cantidadEsperada;

        switch (etapa) {

            case "Octavos de final":
                cantidadEsperada = 16;
                break;

            case "Cuartos de final":
                cantidadEsperada = 8;
                break;

            case "Semifinales":
                cantidadEsperada = 4;
                break;

            case "Gran final":
                cantidadEsperada = 2;
                break;

            default:
                throw new SorteoInvalidoException(
                    "Etapa desconocida."
                );
        }

        if (participantes.size() != cantidadEsperada) {
            throw new SorteoInvalidoException(
                "Cantidad incorrecta de equipos para " + etapa
            );
        }

        List<Equipo> aleatorios =
                new ArrayList<>(participantes);

        Collections.shuffle(aleatorios);

        List<Partido> partidos = new ArrayList<>();

        sorteoRecursivo(aleatorios, 0, etapa, partidos);

        etapas.put(etapa, partidos);

        return partidos;
    }

    // Algoritmo recursivo para emparejar equipos
    private void sorteoRecursivo(
            List<Equipo> equipos, int indice,
            String etapa, List<Partido> partidos)
            throws SorteoInvalidoException {

        if (indice == equipos.size()) {
            return;
        }

        if (indice + 1 >= equipos.size()) {
            throw new SorteoInvalidoException(
                "No se pudo completar el sorteo."
            );
        }

        Equipo equipo1 = equipos.get(indice);
        Equipo equipo2 = equipos.get(indice + 1);

        if (equipo1.getNombre().equals(equipo2.getNombre())) {
            throw new SorteoInvalidoException(
                "Un equipo no puede enfrentarse a sí mismo."
            );
        }

        partidos.add(new Partido(equipo1, equipo2, etapa));

        sorteoRecursivo(
            equipos, indice + 2, etapa, partidos
        );
    }

    // Registrar los ganadores de cada partido
    public List<Equipo> obtenerGanadores(
            List<Partido> partidos, Scanner teclado) {

        List<Equipo> ganadores = new ArrayList<>();

        for (int i = 0; i < partidos.size(); i++) {

            Partido partido = partidos.get(i);

            System.out.println("\nPartido " + (i + 1));
            System.out.println("1. " + partido.getEquipo1());
            System.out.println("2. " + partido.getEquipo2());

            int opcion = 0;

            while (opcion != 1 && opcion != 2) {

                System.out.print(
                    "Seleccione el ganador (1 o 2): "
                );

                try {
                    opcion = Integer.parseInt(
                        teclado.nextLine()
                    );

                    if (opcion != 1 && opcion != 2) {
                        System.out.println(
                            "Ingrese solamente 1 o 2."
                        );
                    }

                } catch (NumberFormatException e) {

                    System.out.println(
                        "Ingrese un número válido."
                    );
                }
            }

            if (opcion == 1) {
                ganadores.add(partido.getEquipo1());
            } else {
                ganadores.add(partido.getEquipo2());
            }
        }

        return ganadores;
    }

    // Guardar torneo mediante serialización
    public void guardarTorneo(String archivo) throws IOException {

        try (ObjectOutputStream salida =
                new ObjectOutputStream(
                    new FileOutputStream(archivo))) {

            salida.writeObject(this);
        }
    }

    // Recuperar torneo mediante deserialización
    public static Torneo cargarTorneo(String archivo)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream entrada =
                new ObjectInputStream(
                    new FileInputStream(archivo))) {

            return (Torneo) entrada.readObject();
        }
    }
}

