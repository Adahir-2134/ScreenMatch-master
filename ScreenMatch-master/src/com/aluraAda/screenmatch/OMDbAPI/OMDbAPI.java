package com.aluraAda.screenmatch.OMDbAPI;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class OMDbAPI {
    private final String apiKey = "36752440"; // Tu clave de API

    public JSONObject buscarPelicula(String titulo) throws IOException {
        // Formar la URL de la solicitud
        String urlString = "http://www.omdbapi.com/?t=" + titulo.replace(" ", "+") + "&apikey=" + apiKey;
        URL url = new URL(urlString);

        // Hacer la conexión
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        // Verificar si la solicitud fue exitosa (código 200)
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Error: " + responseCode);
        }

        // Leer la respuesta de la API
        Scanner scanner = new Scanner(url.openStream());
        StringBuilder jsonResponse = new StringBuilder();
        while (scanner.hasNext()) {
            jsonResponse.append(scanner.nextLine());
        }
        scanner.close();

        // Devolver la respuesta como un objeto JSON
        return new JSONObject(jsonResponse.toString());
    }
}
