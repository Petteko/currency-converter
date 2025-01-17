package com.currencyconverter.converter;

import com.currencyconverter.api.APIClient;
import com.currencyconverter.api.UnsupportedCurrencyPairException;

public class ConversorMonedas {
    private APIClient apiClient;

    public ConversorMonedas() {
        apiClient = new APIClient();
    }

    public String convertir(String monedaOrigen, String monedaDestino, double monto) throws UnsupportedCurrencyPairException {
        double tasa = apiClient.obtenerTasaCambio(monedaOrigen, monedaDestino);
        double resultado = monto * tasa;
        return String.format("%.2f %s = %.2f %s", monto, monedaOrigen, resultado, monedaDestino);
    }
}
