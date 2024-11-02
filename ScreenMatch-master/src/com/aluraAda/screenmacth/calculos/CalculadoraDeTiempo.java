package com.aluraAda.screenmatch.calculos;

import com.aluraAda.screenmatch.modelos.Pelicula;
import com.aluraAda.screenmatch.modelos.Serie;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDeTiempo {
    private List<Pelicula> peliculas = new ArrayList<>();
    private List<Serie> series = new ArrayList<>();

    public void incluye(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void incluye(Serie serie) {
        series.add(serie);
    }

    public int getTiempoTotal() {
        int tiempoTotal = 0;

        for (Pelicula pelicula : peliculas) {
            tiempoTotal += pelicula.getDuracionEnMinutos();
        }

        for (Serie serie : series) {
            tiempoTotal += serie.getDuracionEnMinutos();
        }

        return tiempoTotal;
    }
}
