package com.aluracursos.conversorDeMonedas.modulos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    private final HttpClient client;

    public Api() {
        this.client = HttpClient.newHttpClient();
    }

    public String getRespuesta(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new IOException("Error en la solicitud a la API: Codigo " + response.statusCode());
        }
        return response.body();
    }
}