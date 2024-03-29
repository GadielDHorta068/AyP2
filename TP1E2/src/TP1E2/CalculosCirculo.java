package TP1E2;
import java.util.Scanner;

public class CalculosCirculo {
	
	public static void main(String[] args) {
	
		int radioCirculo;
		int pi = (int) 3.14159;
		Scanner myScanner = new Scanner(System.in);
	
		System.out.print("Radio del circulo:");
		radioCirculo = myScanner.nextInt();
		
		System.out.println("Diametro: " + diametro.calcular(radioCirculo));
		System.out.println("Circunferencia: " + circunferencia.calcular(radioCirculo, pi));
		System.out.println("Area: " + area.calcular(radioCirculo, pi));
	}
}
/* Escribir un programa que reciba el radio de un círculo e imprima
 *  el diámetro (2r), la circunferencia (2πr) y el área (πr2) de este círculo. 
 *  Utilizar el valor constante 3.14159 para π. */
