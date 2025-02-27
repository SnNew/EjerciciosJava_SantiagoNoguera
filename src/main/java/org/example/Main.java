package org.example;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int victoriasJugador1 = 0;
        int victoriasJugador2 = 0;

        int piedra = 1;
        int papel = 2;
        int tijera = 3;

        while (victoriasJugador1 < 2 && victoriasJugador2 < 2 ){

            int jugador1 = random.nextInt(3) +1;
            int jugador2 = random.nextInt(3) +1;

            String eleccionJugador1;
            if (jugador1 == piedra){
                eleccionJugador1 = "piedra";
            } else if (jugador1 == papel) {
                eleccionJugador1 = "papel";
            }else{
                eleccionJugador1 = "tijera";
            }
            String eleccionJugador2;
            if (jugador2 == piedra){
                eleccionJugador2 = "piedra";
            } else if (jugador2 == papel) {
                eleccionJugador2 = "papel";
            }else{
                eleccionJugador2 = "tijera";
            }

            System.out.println("\nEl jugador 1 ha sacado " +eleccionJugador1);
            System.out.println("El jugador 2 ha sacado " +eleccionJugador2);

            int ganador;

            if (jugador1 == jugador2){
                ganador = 0;
            } else if ((jugador1 == piedra && jugador2 == tijera )||( jugador1 == tijera && jugador2 == papel) || (jugador1 == papel && jugador2 == piedra)) {
                ganador = 1;
            }else {
                ganador = 2;
            }
            if (ganador == 1){
                victoriasJugador1 ++;
                System.out.println("El jugador 1 gana esta ronda");
            } else if (ganador == 2) {
                victoriasJugador2 ++;
                System.out.println("El jugador 2 gana esta ronda");
            }else {
                System.out.println("empate");
            }
        }
        if (victoriasJugador1 >= 2){
            System.out.println("\nEl jugador 1 es el ganador");
        }else{
            System.out.println("\nEl jugador 2 es el ganador");
        }
    }
}