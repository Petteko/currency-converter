package com.currencyconverter.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIClient {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public double obtenerTasaCambio(String monedaOrigen, String monedaDestino) throws UnsupportedCurrencyPairException {
        try {
            // Construir URL de la API
            URL url = new URL(API_URL + monedaOrigen);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Verificar el código de respuesta
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new UnsupportedCurrencyPairException("Error al obtener datos de la API.");
            }

            // Leer y parsear el JSON
            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            // Extraer las tasas de cambio
            JsonObject rates = jsonResponse.getAsJsonObject("rates");
            if (rates != null && rates.has(monedaDestino)) {
                return rates.get(monedaDestino).getAsDouble();
            } else {
                throw new UnsupportedCurrencyPairException("Par de monedas no soportado: " + monedaOrigen + " a " + monedaDestino);
            }
        } catch (IOException e) {
            throw new UnsupportedCurrencyPairException("Error al conectar con la API: " + e.getMessage());
        }
    }
}
