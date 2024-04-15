package factorial;

public class Recursivo {
	public static int calcular(int n) {
		if (n==0) return 1;
		return n* calcular(n-1);
	}
}



