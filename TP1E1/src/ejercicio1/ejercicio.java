package ejercicio1;

import java.util.Scanner;

public class ejercicio {

	public static void main(String[] args) {
		String res;
		do {
			int PrimerNumero; //Primer numero
			int SegundoNumero; //Segundo numero
		
		
			System.out.print("Programa de operaciones basicas de dos numeros %d\n");
			Scanner myScanner = new Scanner(System.in);		
		
			System.out.print("Primer numero:");
			PrimerNumero = myScanner.nextInt();
			//System.out.print(A);

			System.out.print("Segundo numero:");
			SegundoNumero = myScanner.nextInt();
			//System.out.print(B);
		
			int suma = PrimerNumero+SegundoNumero;
			int resta = PrimerNumero-SegundoNumero;
			int multiplicacion = PrimerNumero*SegundoNumero;
			int division = PrimerNumero/SegundoNumero;
		
			System.out.printf("Suma		%d\n",suma);
			System.out.printf("Rest		%d\n",resta);
			System.out.printf("Mult		%d\n",multiplicacion);
			System.out.printf("Divi		%d\n",division);
		
			System.out.print("Volver a probar? S/N");
			res = myScanner.next();
		
			if (res.equalsIgnoreCase("N")) {
				System.out.print("Gracias vuelva prontos!");
		    	myScanner.close();
		    	System.exit(0);
			}
			if (res.equalsIgnoreCase("S")) {
		        for (int i = 0; i < 50; i++) {
		            System.out.println();
		        }
			}
		
		} while (res.equalsIgnoreCase("S"));
	}
}
