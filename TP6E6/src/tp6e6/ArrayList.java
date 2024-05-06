package tp6e6;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

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
	
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for (int i = 0; i< size; i++) {
			elementos[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return IndexOf(e) != -1;
	}

	@Override
	public int IndexOf(E e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < size; i++) {
			if(e.equals(elementos[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(elementos[i])) {
                return i;
            }
        }
        return -1;
	}

	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
        int index = IndexOf(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
	}
	
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index fuera de rango");
        }
        System.arraycopy(elementos, index + 1, elementos, index, size - index - 1);
        elementos[--size] = null;
    }

}
