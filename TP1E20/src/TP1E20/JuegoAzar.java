package TP1E20;

import java.util.Random;
import java.util.Scanner;

public class JuegoAzar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean jugarDeNuevo = true;

        while (jugarDeNuevo) {
        	
            int numeroAleatorio = random.nextInt(1000) + 1;
            int intentos = 0;
            int numeroIngresado;

            System.out.println("Debes adivinar el numero que eleji");
            System.out.println("Es un número entre 1 y 1000. Cual es?");

            do {
                System.out.print("Ingresa un número: ");
                numeroIngresado = scanner.nextInt();
                intentos++;

                if (numeroIngresado < numeroAleatorio) {
                    System.out.println("Demasiado bajo. Inténtalo de nuevo.");
                } else if (numeroIngresado > numeroAleatorio) {
                    System.out.println("Demasiado alto. Inténtalo de nuevo.");
                }
            } while (numeroIngresado != numeroAleatorio);

            System.out.println("¡Adivinaste en " + intentos + " intentos!");

            System.out.print("¿Quieres jugar de nuevo? (s/n): ");
            String opcion = scanner.next().toLowerCase();

            if (!opcion.equals("s")) {
                jugarDeNuevo = false;
                System.out.println("¡Gracias por jugar! ¡Hasta luego!");
            }
        }

        scanner.close();
	}
}
