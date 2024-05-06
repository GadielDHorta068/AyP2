package binarySearch;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data = crearArreglo(2097152);
		int[] target = new int[12];

		long startTime;
		boolean resultado;
		long endTime;
		long elapsed;

		for (int i = 0; i < data.length; i++) {

			startTime = System.currentTimeMillis();
			resultado = BinarySearch.recursivo(data, i, 0, data.length);
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;

			System.out.println("Recursivo :" + elapsed + "ms, resultado " + resultado);

			startTime = System.currentTimeMillis();
			resultado = BinarySearch.iterativo(data, i);
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;

			System.out.println("Iterativo:" + elapsed + "ms, resultado " + resultado);

		}
	}

	public static int[] crearArreglo(int dimension) {
		int[] arreglo = new int[dimension];
		for (int i = 0; i < dimension; i++) {
			arreglo[i] = i;
			System.out.print(arreglo[i]);
		}

		return arreglo;

	}

	public static void aBuscar(int[] t) {
		t[0] = 1;
		t[1] = 2;
		t[2] = 4;
		t[3] = 8;
		t[4] = 16;
		t[5] = 32;
		t[6] = 64;
		t[7] = 128;
		t[8] = 256;
		t[9] = 512;
		t[10] = 1024;
		t[11] = 1048576;
		t[12] = 2097152;
	}

	public static void bucarTodos(int[] data, int[] target) {
		long startTime;
		boolean resultado;
		long endTime;
		long elapsed;


		for (int i = 0; i < data.length; i++) {

			startTime = System.currentTimeMillis();
			resultado = BinarySearch.recursivo(data, i, 0, data.length);
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;


			System.out.println("Recursivo :" + elapsed + "ms, resultado " + resultado);


			startTime = System.currentTimeMillis();
			resultado = BinarySearch.iterativo(data, i);
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;

			System.out.println("Iterativo:" + elapsed + "ms, resultado " + resultado);
		}
	}

}
