package TP1E4;

import java.util.Scanner;


public class ParImpar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numero;
		Scanner scanner;
		
		scanner = new Scanner(System.in);
		
		System.out.print("Ingrese el numero");
		numero = scanner.nextInt();
		
		System.out.print(comparar.calcular(numero));
		
		scanner.close();
	}

}
/* Escribir un programa que lee un número e imprima si es par o impar utilizando el operador módulo.
 */
