package tp1e20;

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
            int numeroIngresado = 0;

            System.out.println("Debes adivinar el numero que eleji");
            System.out.println("Es un número entre 1 y 1000. Cual es?");
         
            //Ejecuto el juego
            intentos = logicaJuego(numeroAleatorio, numeroIngresado, scanner, intentos);
            
            //Resultado del juego
            System.out.println("¡Adivinaste en " + intentos + " intentos!");
            
            //Repetir o no logica de juego
            System.out.print("¿Quieres jugar de nuevo? (s/n): ");
            String opcion = scanner.next().toLowerCase();

            if (!opcion.equals("s")) {
                jugarDeNuevo = false;
                System.out.println("¡Gracias por jugar! ¡Hasta luego!");
            }
        }

        scanner.close();
	}
	private static int logicaJuego(int numeroAleatorio, int numeroIngresado, Scanner scanner, int intentos) {
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
        return intentos;
	}
}

