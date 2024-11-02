package com.aluraAda.screenmatch.calculos;

import com.aluraAda.screenmatch.modelos.Episodio;
import com.aluraAda.screenmatch.modelos.Pelicula;

public class FiltroRecomendaciones {

    public void filtra(Pelicula pelicula) {
        // Implementación del filtrado de recomendaciones para películas
        if (pelicula.getDuracionEnMinutos() > 120) {
            System.out.println("Te recomendamos ver: " + pelicula.getNombre());
        } else {
            System.out.println("Puedes ver " + pelicula.getNombre() + " en menos de 120 minutos.");
        }
    }

    // Sobrecarga del método para aceptar episodios
    public void filtra(Episodio episodio) {
        System.out.println("Episodio: " + episodio.getNombre() + " de la serie " + episodio.getSerie().getNombre());
        // Implementa la lógica para filtrar episodios si es necesario
    }
}
