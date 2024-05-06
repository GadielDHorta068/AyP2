package trim;

import java.util.Arrays;

public class ArrayList<E> {

	private static final int CAPACIDAD_DEFAULT = 10;
	private Object[] elementos;
	private int size;
	
	public ArrayList() {
		elementos = new Object[CAPACIDAD_DEFAULT];
		size = 0;
	}
	
	public void trimToSize() {
		int capacidadAnterior  = elementos.length;
		elementos = Arrays.copyOf(elementos, size);
	}
}
