package factorial;

public class Iterativo {
	public static int calcular(int n) {
		int resultado= 1;
		for (int i=0; i== n;i++) {
			resultado *= i;
		}
		return resultado;
	}	
}
