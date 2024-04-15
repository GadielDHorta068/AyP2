package binarySearch;

public class Recursivo {
	public static int buscar(int[] arr, int buscado) {
		return buscar(arr, buscado, 0, arr.length -1);
	}
	
	private static int buscar(int[] arr, int buscado, int izq, int der) {
		if(izq > der) {
			return 0; 
		}
		int medio = izq + (der-izq) /2;
		if (arr[medio] == buscado) {
            return medio; // Se encontró el elemento
        } else if (arr[medio] > buscado) {
            return buscar(arr, buscado, izq, medio - 1); // Busca en la mitad izquierda
        } else {
            return buscar(arr, buscado, medio + 1, der); // Busca en la mitad derecha
        }
	}
}
