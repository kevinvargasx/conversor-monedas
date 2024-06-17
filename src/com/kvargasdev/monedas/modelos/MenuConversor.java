package com.kvargasdev.monedas.modelos;

import java.util.Scanner;

public class MenuConversor {

    private ConversorMoneda conversor;

    public MenuConversor(ConversorMoneda conversor) {
        this.conversor = conversor;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        String menu = """
                ****Bienvenido al conversor de moneda****
                1. Dolar => Peso Argentino
                2. Peso Argentino => Dolar
                3. Dolar => Real Brasileño
                4. Real Brasileño => Dolar
                5. Dolar => Soles
                6. Soles => Dolar
                7. Salir
                Elija una opcion valida:
                """;

        while (true) {
            System.out.println(menu);
            String opcion = scanner.nextLine();

            if (opcion.equals("7")) {
                System.out.println("Gracias por usar el conversor de monedas.");
                break;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine();  // Clear the buffer

            switch (opcion) {
                case "1":
                    convertirYMostrar(cantidad, "USD", "ARS");
                    break;
                case "2":
                    convertirYMostrar(cantidad, "ARS", "USD");
                    break;
                case "3":
                    convertirYMostrar(cantidad, "USD", "BRL");
                    break;
                case "4":
                    convertirYMostrar(cantidad, "BRL", "USD");
                    break;
                case "5":
                    convertirYMostrar(cantidad, "USD", "PEN");
                    break;
                case "6":
                    convertirYMostrar(cantidad, "PEN", "USD");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        }

        scanner.close();
    }

    private void convertirYMostrar(double cantidad, String baseCurrency, String targetCurrency) {
        Double resultado = conversor.convertirMoneda(cantidad, baseCurrency, targetCurrency);
        if (resultado != null) {
            System.out.printf("%.2f %s son %.2f %s%n", cantidad, baseCurrency, resultado, targetCurrency);
        }
    }
}