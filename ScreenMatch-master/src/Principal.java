import com.aluraAda.screenmatch.OMDbAPI.OMDbAPI;
import com.aluraAda.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluraAda.screenmatch.calculos.FiltroRecomendaciones;
import com.aluraAda.screenmatch.modelos.Episodio;
import com.aluraAda.screenmatch.modelos.Pelicula;
import com.aluraAda.screenmatch.modelos.Serie;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static List<String> verMasTarde = new ArrayList<>();

    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre("Encanto");
        miPelicula.setFechaDeLanzamiento(2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);
        System.out.println("Total de evaluaciones: " + miPelicula.getTotalDelasEvaluaciones());
        System.out.println("Calificación media: " + miPelicula.calculaMedia());

        Serie casaDragon = new Serie();
        casaDragon.setNombre("La casa del dragón");
        casaDragon.setFechaDeLanzamiento(2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println("Duración total: " + casaDragon.getDuracionEnMinutos() + " minutos");

        Pelicula otraPelicula = new Pelicula();
        otraPelicula.setNombre("Matrix");
        otraPelicula.setFechaDeLanzamiento(1998);
        otraPelicula.setDuracionEnMinutos(180);

        // Asegúrate de que solo se añadan películas a la calculadora
        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(otraPelicula); // Solo agrega películas
        System.out.println("Tiempo necesario para ver tus títulos favoritos estas vacaciones: "
                + calculadora.getTiempoTotal() + " minutos");

        FiltroRecomendaciones filtroRecomendaciones = new FiltroRecomendaciones();
        filtroRecomendaciones.filtra(miPelicula);

        // Creación de un episodio
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("Capítulo 1");
        episodio.setSerie(casaDragon); // Asegúrate de que se pase el objeto Serie
        episodio.setTotalDeVisualizaciones(300);

        // Agregar filtro de recomendaciones para el episodio
        filtroRecomendaciones.filtra(episodio); // Este método debe ser modificado si no acepta Episodio

        // Implementación de la API OMDb
        try {
            OMDbAPI api = new OMDbAPI();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingresa el nombre de la película o serie que quieres buscar: ");
            String titulo = scanner.nextLine();

            JSONObject datosPelicula = api.buscarPelicula(titulo);
            if (datosPelicula.getString("Response").equals("True")) {
                System.out.println("Título: " + datosPelicula.getString("Title"));
                System.out.println("Clasificación: " + datosPelicula.getString("Rated"));
                System.out.println("Calificación IMDB: " + datosPelicula.getString("imdbRating"));

                // Agregar a "ver más tarde"
                System.out.print("¿Quieres agregar esta película a tu lista de 'ver más tarde'? (S/N): ");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("S")) {
                    verMasTarde.add(datosPelicula.getString("Title"));
                    System.out.println("Agregada a tu lista de 'ver más tarde'.");
                }

                // Mostrar lista de "ver más tarde"
                System.out.println("Películas/Series en tu lista de 'ver más tarde': ");
                for (String tituloEnLista : verMasTarde) {
                    System.out.println("- " + tituloEnLista);
                }

                // Eliminar de "ver más tarde"
                System.out.print("¿Quieres eliminar una película de la lista de 'ver más tarde'? (S/N): ");
                String eliminarRespuesta = scanner.nextLine();
                if (eliminarRespuesta.equalsIgnoreCase("S")) {
                    System.out.print("Ingresa el nombre de la película/serie a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    verMasTarde.remove(tituloEliminar);
                    System.out.println("Eliminada de tu lista.");
                }

            } else {
                System.out.println("No se encontró la película/serie.");
            }
        } catch (IOException e) {
            System.out.println("Error al buscar la película: " + e.getMessage());
        }
    }
}
