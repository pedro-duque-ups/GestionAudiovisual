package audiovisual;

public class Temporada {
    private int numero;
    private int episodios;

    public Temporada(int numero, int episodios) {
        if (numero <= 0 || episodios <= 0) throw new IllegalArgumentException("Número de temporada y episodios deben ser positivos.");
        this.numero = numero;
        this.episodios = episodios;
    }

    public int getNumero() { return numero; }
    public int getEpisodios() { return episodios; }

    @Override
    public String toString() {
        return "Temporada " + numero + " (" + episodios + " episodios)";
    }
}
