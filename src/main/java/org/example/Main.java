package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dinero = 50000;
        boolean salir = false;

        while (!salir) {
            System.out.println("\nCAJERO AUTOMATICO");
            System.out.println("1. Consultar dinero");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> System.out.println("Su saldo es de: $" + dinero);
                case 2 -> {
                    System.out.print("Ingrese el dinero que desea depositar: ");
                    int ingreso = scanner.nextInt();
                    if (ingreso > 0) {
                        dinero += ingreso;
                        System.out.println("Depósito exitoso. Su nuevo saldo es de: $" + dinero);
                    } else {
                        System.out.println("Ingrese un monto de dinero valido por favor.");
                    }
                }
                case 3 -> {
                    System.out.print("Cuanto dinero desea retirar: ");
                    int sacar = scanner.nextInt();
                    if (sacar > 0 && sacar <= dinero) {
                        dinero -= sacar;
                        System.out.println("Retiro exitoso. Su nuevo saldo es de: $" + dinero);
                    } else {
                        System.out.println("Monto inválido o insuficiente. por favor ingrese un monto valido");
                    }
                }
                case 4 -> {
                    salir = true;
                    System.out.println("Gracias por usar nuestro programa.");
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}