package fibonacci;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 35;
		System.out.println("Serie fibonacci primer algoritmo");
		long startTime = System.currentTimeMillis( ); 
        for (int i = 0; i < n; i++) {
            System.out.print(Recursivo1.fibonacci(i) + " ");
        }
		long endTime = System.currentTimeMillis( ); 
		long elapsed = endTime - startTime;
		System.out.println();
		System.out.println(elapsed +"ms");
		
        System.out.println();
        
		System.out.println("Serie fibonacci segundo algoritmo");
		startTime = System.currentTimeMillis( );
        for (int i = 0; i < n; i++) {
            System.out.print(Recursivo2.fibonacci(i, 0,1) + " ");
        }
        endTime = System.currentTimeMillis( ); 
		elapsed = endTime - startTime;
		System.out.println();
		System.out.println(elapsed +"ms");
	}

}
