package com.currencyconverter.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APIClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private String apiKey;

    public APIClient() {
        // Cargar la API key desde config.properties
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input != null) {
                prop.load(input);
                apiKey = prop.getProperty("api.key");
            } else {
                throw new RuntimeException("Archivo config.properties no encontrado.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar config.properties: " + e.getMessage());
        }
    }

    public double obtenerTasaCambio(String monedaOrigen, String monedaDestino) throws UnsupportedCurrencyPairException {
        try {
            // Construir URL de la API con la clave
            URL url = new URL(API_URL + apiKey + "/latest/" + monedaOrigen);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Verificar el código de respuesta
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new UnsupportedCurrencyPairException("Error al obtener datos de la API. Código: " + responseCode);
            }

            // Leer y parsear el JSON
            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            // Extraer las tasas de cambio
            JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");
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