package com.kvargasdev.monedas.modelos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;



public class ConversorMoneda {

    private String apiKey;

    public ConversorMoneda(String apiKey) {
        this.apiKey = apiKey;
    }
    public Double obtenerTipoDeCambio(String baseCurrency, String targetCurrency) {
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            JSONObject json = new JSONObject(content.toString());
            if (json.getString("result").equals("error")) {
                System.out.println("Error al obtener los datos: " + json.getString("error-type"));
                return null;
            }

            return json.getJSONObject("conversion_rates").getDouble(targetCurrency);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Double convertirMoneda(double cantidad, String baseCurrency, String targetCurrency) {
        Double tipoDeCambio = obtenerTipoDeCambio(baseCurrency, targetCurrency);
        if (tipoDeCambio == null) {
            System.out.println("No se pudo obtener el tipo de cambio.");
            return null;
        }

        return cantidad * tipoDeCambio;
    }
}