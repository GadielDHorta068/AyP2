package potencias;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis( ); 
		double resultado = Recursivo1.calcular(5,10);
		long endTime = System.currentTimeMillis( ); 
		long elapsed = endTime - startTime;
		System.out.println( "Tiempo Algoritmo 1:"+ elapsed + "ms, resultado" + resultado);

		startTime = System.currentTimeMillis( ); 
		resultado = Recursivo1.calcular(5,10);
		endTime = System.currentTimeMillis( ); 
		elapsed = endTime - startTime;
		System.out.println( "Tiempo Algoritmo 2:"+ elapsed+ "ms, resultado" + resultado);
	}

}
