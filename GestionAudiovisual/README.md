# Gestión Audiovisual — Proyecto Java POO

## Descripción
Aplicación de consola que modela un catálogo audiovisual con películas, series, documentales, cortometrajes y videos de YouTube. El proyecto demuestra herencia, encapsulamiento, polimorfismo, asociación, agregación y composición.

## Clases
- `ContenidoAudiovisual`: clase abstracta con título, año, duración y métodos comunes.
- `Pelicula`: administra una lista de `Actor` mediante agregación.
- `SerieDeTV`: crea y administra objetos `Temporada` mediante composición.
- `Documental`: se relaciona con `Investigador` mediante asociación.
- `Cortometraje` y `VideoYouTube`: nuevas subclases de `ContenidoAudiovisual`.
- `Detallable`: interfaz con un método `default` para mostrar fichas.
- `Main`: crea objetos, los registra en un catálogo y prueba sus métodos.

## Requisitos
- JDK 17 o superior recomendado.
- Eclipse IDE, IntelliJ IDEA o terminal con `javac`.

## Ejecutar en Eclipse
1. Descomprime el proyecto.
2. En Eclipse, selecciona **File > Import > Existing Projects into Workspace**.
3. Elige la carpeta `GestionAudiovisual`.
4. Abre `src/main/java/audiovisual/Main.java`.
5. Ejecuta con **Run As > Java Application**.

## Ejecutar desde terminal
Desde la carpeta del proyecto:

```bash
javac -d out src/main/java/audiovisual/*.java
java -cp out audiovisual.Main
```

## Relaciones UML
- **Herencia:** `Pelicula`, `SerieDeTV`, `Documental`, `Cortometraje` y `VideoYouTube` heredan de `ContenidoAudiovisual`.
- **Agregación:** `Pelicula` utiliza `Actor`; un actor puede existir aunque no esté asociado a una película.
- **Composición:** `SerieDeTV` crea y administra sus objetos `Temporada`.
- **Asociación:** `Documental` colabora con objetos `Investigador`, que pueden participar en otros documentales.
- **Realización:** las clases `Pelicula`, `SerieDeTV` y `Documental` implementan `Detallable`.

## Pruebas realizadas manualmente
El programa crea instancias de todas las clases, añade actores, temporadas e investigadores, aumenta las visualizaciones de un video y recorre una colección polimórfica de contenidos.

## Historial de commits sugerido
Realiza al menos tres commits reales en tu repositorio:
1. `Crear estructura inicial y clase abstracta`
2. `Agregar relaciones entre pelicula, serie y documental`
3. `Incorporar nuevas subclases, pruebas y README`

> Los commits deben ejecutarse en tu propio repositorio; no se simulan en este archivo.
