package audiovisual;

public interface Detallable {
    default void mostrarFicha() {
        System.out.println("\n--- Ficha audiovisual ---");
        mostrarDetallesGenerales();
        mostrarDetallesEspecificos();
    }

    void mostrarDetallesGenerales();
    void mostrarDetallesEspecificos();
}
