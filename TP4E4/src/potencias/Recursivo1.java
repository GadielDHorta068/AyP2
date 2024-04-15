package potencias;

public class Recursivo1 {
	public static int calcular(int num, int potencia) {
		int pot = 1;
		for (int i=0;i<potencia;i++) {	//Tiempo lineal
			pot *= num;
		}
		return pot;
	}
}
