/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template */
package netflixarraylist;
import java.util.ArrayList;
import java.util.List;

// 1. Interfaz de visualización
interface Visualizable {
    void marcarVisto();
    boolean esVisto();
    double tiempoVisto();
}

// 2. Superclase abstracta
abstract class Contenido implements Visualizable {
    protected String titulo;
    protected String genero;
    protected String creador;
    protected double duracion; // Duración en minutos
    protected boolean visto;

    public Contenido() {
        this.titulo = "Sin titulo";
        this.genero = "Sin genero";
        this.creador = "Anonimo";
        this.duracion = 0.0;
        this.visto = false;
    }

    public Contenido(String titulo, String creador) {
        this();
        this.titulo = titulo;
        this.creador = creador;
    }

    public Contenido(String titulo, String genero, String creador, double duracion) {
        if (duracion < 0) {
            throw new IllegalArgumentException("Error: La duracion no puede ser negativa.");
        }
        this.titulo = titulo;
        this.genero = genero;
        this.creador = creador;
        this.duracion = duracion;
        this.visto = false;
    }

    // Getters y Setters con validaciones de excepción
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getCreador() { return creador; }
    public void setCreador(String creador) { this.creador = creador; }

    public double getDuracion() { return duracion; }
    
    public void setDuracion(double duracion) {
        if (duracion < 0) {
            throw new IllegalArgumentException("Error: La duracion no puede ser negativa.");
        }
        this.duracion = duracion;
    }

    // Métodos de la interfaz Visualizable
    @Override
    public void marcarVisto() { this.visto = true; }

    @Override
    public boolean esVisto() { return this.visto; }

    @Override
    public double tiempoVisto() { return this.visto ? this.duracion : 0.0; }
}

// 3. Clase Pelicula
class Pelicula extends Contenido {
    private int year;

    public Pelicula() {
        super();
        this.year = 1900;
    }

    public Pelicula(String titulo, String creador) {
        super(titulo, creador);
        this.year = 1900;
    }

    public Pelicula(String titulo, String genero, String creador, int year, double duracion) {
        super(titulo, genero, creador, duracion);
        if (year < 1888) { // 1888 es el año de la primera película de la historia
            throw new IllegalArgumentException("Error: El año de la pelicula (" + year + ") es invalido.");
        }
        this.year = year;
    }

    public int getYear() { return year; }

    public void setYear(int year) {
        if (year < 1888) {
            throw new IllegalArgumentException("Error: El año de la pelicula (" + year + ") es invalido.");
        }
        this.year = year;
    }

    @Override
    public String toString() {
        return "Pelicula: " + titulo +
               " | Genero: " + genero +
               " | Creador: " + creador +
               " | Año: " + year +
               " | Duracion: " + duracion + " min" +
               " | Visto: " + (visto ? "Si" : "No");
    }
}

// 4. Clase Serie
class Serie extends Contenido {
    private int numeroTemporadas;

    public Serie() {
        super();
        this.numeroTemporadas = 1;
    }

    public Serie(String titulo, String creador) {
        super(titulo, creador);
        this.numeroTemporadas = 1;
    }

    public Serie(String titulo, int numeroTemporadas, String genero, String creador, double duracion) {
        super(titulo, genero, creador, duracion);
        if (numeroTemporadas <= 0) {
            throw new IllegalArgumentException("Error: Una serie debe tener al menos 1 temporada.");
        }
        this.numeroTemporadas = numeroTemporadas;
    }

    public int getNumeroTemporadas() { return numeroTemporadas; }

    public void setNumeroTemporadas(int numeroTemporadas) {
        if (numeroTemporadas <= 0) {
            throw new IllegalArgumentException("Error: Una serie debe tener al menos 1 temporada.");
        }
        this.numeroTemporadas = numeroTemporadas;
    }

    @Override
    public String toString() {
        return "Serie: " + titulo +
               " | Temporadas: " + numeroTemporadas +
               " | Genero: " + genero +
               " | Creador: " + creador +
               " | Duracion: " + duracion + " min" +
               " | Visto: " + (visto ? "Si" : "No");
    }
}
/** @author DELL */
public class NetflixArrayList {

    /* @param args the command line arguments */
    public static void main(String[] args) {
        // TODO code application logic here

        List<Pelicula> peliculas = new ArrayList<>();
        List<Serie> series = new ArrayList<>();

        // Bloque try-catch para capturar datos inválidos en la creación de objetos
        try {
            // Llenado de películas
            peliculas.add(new Pelicula("Inception", "Sci-Fi", "Christopher Nolan", 2010, 148));
            peliculas.add(new Pelicula("Oppenheimer", "Biografia", "Christopher Nolan", 2023, 180));
            peliculas.add(new Pelicula("Interstellar", "Sci-Fi", "Christopher Nolan", 2014, 169));
            peliculas.add(new Pelicula("Armageddon", "Accion", "Michael Bay", 1998, 151));
            peliculas.add(new Pelicula("10000 AC", "Aventura", "Roland Emmerich", 2008, 109));

            // Llenado de series
            series.add(new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan", 4700));
            series.add(new Serie("Stranger Things", 4, "Sci-Fi", "Duffer Brothers", 2000));
            series.add(new Serie("Lucifer", 6, "Fantasia", "Tom Kapinos", 3900));
            series.add(new Serie("Scorpion", 4, "Accion", "Nick Santora", 3800));
            series.add(new Serie("Peaky Blinders", 6, "Drama", "Steven Knight", 2160));

        } catch (IllegalArgumentException e) {
            System.err.println("Excepcion durante la creacion de objetos: " + e.getMessage());
        }

        // Marcar elementos como vistos con protección contra accesos fuera de rango
        try {
            peliculas.get(0).marcarVisto();
            peliculas.get(2).marcarVisto();
            peliculas.get(3).marcarVisto();

            series.get(0).marcarVisto();
            series.get(2).marcarVisto();
            series.get(4).marcarVisto();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error al acceder a un elemento por índice: " + e.getMessage());
        }

        // Procesamiento de Películas vistas
        double tiempoTotalPeliculas = 0;
        System.out.println("--- Peliculas vistas ---");
        for (Pelicula pelicula : peliculas) {
            if (pelicula != null && pelicula.esVisto()) {
                System.out.println(pelicula);
                tiempoTotalPeliculas += pelicula.tiempoVisto();
            }
        }
        System.out.println("Tiempo total visualizado en peliculas: " + tiempoTotalPeliculas + " minutos.\n");

        // Procesamiento de Series vistas
        double tiempoTotalSeries = 0;
        System.out.println("--- Series vistas ---");
        for (Serie serie : series) {
            if (serie != null && serie.esVisto()) {
                System.out.println(serie);
                tiempoTotalSeries += serie.tiempoVisto();
            }
        }
        System.out.println("Tiempo total visualizado en series: " + tiempoTotalSeries + " minutos.\n");

        // Búsqueda controlada de la serie con más temporadas
        try {
            if (series.isEmpty()) {
                throw new IllegalStateException("La lista de series se encuentra vacia.");
            }

            Serie serieMasTemporadas = series.get(0);
            for (int i = 1; i < series.size(); i++) {
                if (series.get(i) != null && series.get(i).getNumeroTemporadas() > serieMasTemporadas.getNumeroTemporadas()) {
                    serieMasTemporadas = series.get(i);
                }
            }
            System.out.println("--- Serie con mas temporadas ---");
            System.out.println(serieMasTemporadas);

        } catch (IllegalStateException | IndexOutOfBoundsException e) {
            System.err.println("Error procesando las series: " + e.getMessage());
        }

        // Búsqueda controlada de la película más reciente
        try {
            if (peliculas.isEmpty()) {
                throw new IllegalStateException("La lista de peliculas se encuentra vacia.");
            }

            Pelicula peliculaMasReciente = peliculas.get(0);
            for (int i = 1; i < peliculas.size(); i++) {
                if (peliculas.get(i) != null && peliculas.get(i).getYear() > peliculaMasReciente.getYear()) {
                    peliculaMasReciente = peliculas.get(i);
                }
            }
            System.out.println("\n--- Pelicula mas reciente ---");
            System.out.println(peliculaMasReciente);

        } catch (IllegalStateException | IndexOutOfBoundsException e) {
            System.err.println("Error procesando las peliculas: " + e.getMessage());
        }
    }
}