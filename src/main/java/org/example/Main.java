package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tipos de Pokémon: Agua, Fuego, Planta, Eléctrico");
        System.out.println("(Escriba exactamente como se muestra arriba)");

        System.out.print("Ingrese el tipo del Pokémon atacante: ");
        String tipoAtacante = scanner.nextLine();

        System.out.print("Ingrese el tipo del Pokémon defensor: ");
        String tipoDefensor = scanner.nextLine();

        System.out.print("Ingrese el valor de ataque (1-100): ");
        int ataque = scanner.nextInt();

        System.out.print("Ingrese el valor de defensa (1-100): ");
        int defensa = scanner.nextInt();

        // Validación de entrada
        if (ataque < 1 || ataque > 100) {
            System.out.println("Error: El valor de ataque debe estar entre 1 y 100.");
            scanner.close();
            return;
        }

        if (defensa < 1 || defensa > 100) {
            System.out.println("Error: El valor de defensa debe estar entre 1 y 100.");
            scanner.close();
            return;
        }

        // Cálculo de efectividad
        double efectividad = 1.0; // Neutral por defecto

        if (tipoAtacante.equals("Agua")) {
            if (tipoDefensor.equals("Fuego")) {
                efectividad = 2.0; // Agua es súper efectivo contra Fuego
            } else if (tipoDefensor.equals("Agua") || tipoDefensor.equals("Planta")) {
                efectividad = 0.5; // Agua no es muy efectivo contra Agua o Planta
            }
        } else if (tipoAtacante.equals("Fuego")) {
            if (tipoDefensor.equals("Planta")) {
                efectividad = 2.0; // Fuego es súper efectivo contra Planta
            } else if (tipoDefensor.equals("Agua") || tipoDefensor.equals("Fuego")) {
                efectividad = 0.5; // Fuego no es muy efectivo contra Agua o Fuego
            }
        } else if (tipoAtacante.equals("Planta")) {
            if (tipoDefensor.equals("Agua")) {
                efectividad = 2.0; // Planta es súper efectivo contra Agua
            } else if (tipoDefensor.equals("Fuego") || tipoDefensor.equals("Planta")) {
                efectividad = 0.5; // Planta no es muy efectivo contra Fuego o Planta
            }
        } else if (tipoAtacante.equals("Eléctrico")) {
            if (tipoDefensor.equals("Agua")) {
                efectividad = 2.0; // Eléctrico es súper efectivo contra Agua
            } else if (tipoDefensor.equals("Planta") || tipoDefensor.equals("Eléctrico")) {
                efectividad = 0.5; // Eléctrico no es muy efectivo contra Planta o Eléctrico
            }
        }

        // Cálculo de daño
        double daño = 50 * ((double)ataque / defensa) * efectividad;

        // Mostrar resultado
        System.out.println("\n--- Resultado del Ataque ---");
        System.out.println("Pokémon atacante: " + tipoAtacante);
        System.out.println("Pokémon defensor: " + tipoDefensor);
        System.out.println("Valor de ataque: " + ataque);
        System.out.println("Valor de defensa: " + defensa);

        String mensajeEfectividad = "neutral";
        if (efectividad == 2.0) {
            mensajeEfectividad = "¡Es súper efectivo!";
        } else if (efectividad == 0.5) {
            mensajeEfectividad = "No es muy efectivo...";
        }

        System.out.println("Efectividad: " + mensajeEfectividad + " (x" + efectividad + ")");
        System.out.println("Daño causado: " + daño);

        scanner.close();
    }
}