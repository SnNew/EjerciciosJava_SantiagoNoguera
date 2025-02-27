package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String[] articulos = {"Agua", "Refresco", "Papas", "Chocolate", "Galletas"};
        int[] costos = {2000, 3500, 2600, 2500, 4000};
        int[] seleccion = new int[5];
        int montoTotal = 0;

        System.out.println("Bienvenido al dispensador automatizado.");
        System.out.println("Estos son los artículos disponibles:");
        for (int i = 0; i < articulos.length; i++) {
            System.out.println(i + 1 + ". " + articulos[i] + " - $" + costos[i]);
        }

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el número del artículo que desea comprar (1-5) o 0 para continuar con el pago: ");
            int eleccion = entrada.nextInt();

            switch (eleccion) {
                case 0 -> {
                    i = 5;
                }
                case 1, 2, 3, 4, 5 -> {
                    seleccion[i] = costos[eleccion - 1];
                    montoTotal += costos[eleccion - 1];
                }
                default -> {
                    System.out.println("Opción inválida. Intente nuevamente.");
                    i--;
                }
            }
        }

        if (montoTotal > 0) {
            System.out.println("El total de su compra es: $" + montoTotal);
            System.out.print("Ingrese la cantidad de dinero: ");
            int efectivo = entrada.nextInt();

            while (efectivo < montoTotal) {
                System.out.println("Fondos insuficientes. Intente nuevamente.");
                System.out.print("Ingrese la cantidad de dinero: ");
                efectivo = entrada.nextInt();
            }

            int vueltas = efectivo - montoTotal;
            System.out.println("Compra realizada con éxito. Su cambio es: $" + vueltas);
        } else {
            System.out.println("No ha seleccionado ningún artículo. Gracias por visitar el dispensador automatizado.");
        }

        entrada.close();
    }
}