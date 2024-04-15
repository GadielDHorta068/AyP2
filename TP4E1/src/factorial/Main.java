package factorial;

public class Main {

	public static void main(int[] args) {
		// TODO Auto-generated method stub
		int num = args[0];
		System.out.println("El factorial Iterativo de " + num + "es" + Iterativo.calcular(5) );
		System.out.println("El factorial Recursivo de " + num + "es" + Recursivo.calcular(5) );
	}

}
