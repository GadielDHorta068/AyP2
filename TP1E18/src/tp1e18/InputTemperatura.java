package tp1e18;

import java.util.Scanner;

public class InputTemperatura {

	private String dato;
	static private float tempOriginal;
	
    public static void main(String[] args) {
        InputTemperatura input = new InputTemperatura();
        input.iniciar();
    }
	//Prints y llamar conversion
	public void iniciar() {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Para empezar");
		System.out.println("Ingrese la temperatura original");
		tempOriginal = myScanner.nextFloat();
		
		System.out.println("A que temperatura te gustaria convertir?");
		System.out.println("(Se asume el valor seleccionado como la unidad a convertir)");
		System.out.println("Celsius o Fahrenheit. C/F");
		System.out.print("La temperatura es de: " + setDato(myScanner));
		
		myScanner.close();
		System.exit(0);
	}
	//Funcion para convertir el dato ingresado a la nueva unidad
	public float setDato(Scanner myScanner) {
		dato = myScanner.next();
		dato.toLowerCase();
		if (dato.equals("c")) {
			return conversiones.ToFar.centToFahr(tempOriginal);
		}else if(dato.equals("f")){
		 	return conversiones.ToCent.fahrToCent(tempOriginal);
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