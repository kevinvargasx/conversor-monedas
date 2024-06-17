package com.kvargasdev.monedas.principal;

import com.kvargasdev.monedas.modelos.ConversorMoneda;
import com.kvargasdev.monedas.modelos.MenuConversor;

public class Principal {
    public static void main(String[] args) {

        String apiKey = "8a8e5aa02d433a76aaa6bc41";

        // Crear instancia del conversor de monedas
        ConversorMoneda conversor = new ConversorMoneda(apiKey);

        // Crear y mostrar el menú del conversor
        MenuConversor menu = new MenuConversor(conversor);
        menu.mostrarMenu();

    }
}
