package TP1E5;

import java.util.Scanner;

import TP1E3.comparar;

public class esmultiplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero1;
		int numero2;
		Scanner scanner;
		
		scanner = new Scanner(System.in);
		
		System.out.print("Ingrese el primer numero");
		numero1 = scanner.nextInt();
		
		System.out.print("Ingrese el segundo numero");
		numero2 = scanner.nextInt();
		
		System.out.print(dividir.calcular(numero1, numero2));
		
		scanner.close();
	}

}
/*5. Escribir un programa que lee dos números e imprima si el primero es múltiplo del segundo. */
