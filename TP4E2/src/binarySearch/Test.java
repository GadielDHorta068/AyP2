package binarySearch;

public class Test {

	public static void main(String[] args) {
		 int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	        int buscar = 8;
	        int index = Iterativo.buscar(arr, buscar);
	        if (index != -1) {
	            System.out.println("Iterativo El elemento " + buscar + " está en el índice " + index);
	        } else {
	            System.out.println("Iterativo El elemento " + buscar + " no está en el arreglo.");
	        }
	        
	        index = Recursivo.buscar(arr, buscar);
	        if (index != -1) {
	            System.out.println("Recursivo Iterativo El elemento " + buscar + " está en el índice " + index);
	        } else {
	            System.out.println("Recursivo Iterativo El elemento " + buscar + " no está en el arreglo.");
	        }

	}

}
