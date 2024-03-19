package TP1E18;

import java.util.Scanner;

public class InputTemperatura {

	private String Dato;
	static private float TempOriginal;
	
    public static void main(String[] args) {
        InputTemperatura input = new InputTemperatura();
        input.Iniciar();
    }
	
	public void Iniciar() {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Para empezar");
		System.out.println("Ingrese la temperatura original");
		TempOriginal = myScanner.nextFloat();
		
		System.out.println("A que temperatura te gustaria convertir?");
		System.out.println("(Se asume el valor seleccionado como la unidad a convertir)");
		System.out.println("Celsius o Fahrenheit. C/F");
		System.out.print("La temperatura es de: " + setDato(myScanner));
		
		myScanner.close();
		System.exit(0);
	}

	public float setDato(Scanner myScanner) {
		Dato = myScanner.next();
		Dato.toLowerCase();
		if (Dato.equals("c")) {
			return conversiones.ToFar.CentToFahr(TempOriginal);
		}else if(Dato.equals("f")){
		 	return conversiones.ToCent.FahrToCent(TempOriginal);
		}else {
			setDato(myScanner);
		}
		return 0;
	}
	
}
/* 18. Implementar los siguientes métodos de conversión de temperatura y un programa que muestre su utilización:
a)	Método fahrToCent  retorna el valor en grados centígrados de una temperatura en grados Fahrenheit. °C = 5.0 / 9.0 * (F - 32)
b)	Método centToFahr retorna el valor en grados Fahrenheit de una temperatura en grados centígrados. °F = 9.0 / 5.0 * C + 32
*/