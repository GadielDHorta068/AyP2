package binarySearch;

public class Iterativo {

	public static int buscar(int[] arr, int buscado) {
		int inicio = 0;
		int derecha = arr.length-1 ;
		
		while(inicio <= derecha) {
			int medio = inicio + (derecha - inicio) /2;
			if (arr[medio] == buscado) {
				return medio;
			}else if(arr[medio] < buscado) {
				inicio = medio +1; // Buscar a la mitad derecha
			}else {
				derecha = medio -1;// Buscar a la izquierda
			}
		}
		return 0;
	}
}
