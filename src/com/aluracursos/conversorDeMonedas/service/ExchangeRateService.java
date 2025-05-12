package com.aluracursos.conversorDeMonedas.service;

import com.aluracursos.conversorDeMonedas.modulos.Api;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

public class ExchangeRateService {
    private final Api api;
    private final String apiKey;
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public ExchangeRateService(String apiKey) {
        this.api = new Api();
        this.apiKey = apiKey;
    }

    public double getExchangeRate(String fromCurrency, String toCurrency, double amount) throws IOException, InterruptedException {
        String url = BASE_URL + apiKey + "/pair/" + fromCurrency + "/" + toCurrency + "/" + amount;
        String jsonResponse = api.getRespuesta(url);
        JsonObject jsonObject = new Gson().fromJson(jsonResponse, JsonObject.class);
        if (!jsonObject.get("result").getAsString().equals("success")) {
            throw new IOException("Error en la respuesta de la API: " + jsonObject.get("error-type").getAsString());
        }
        return jsonObject.get("conversion_result").getAsDouble();
    }
}