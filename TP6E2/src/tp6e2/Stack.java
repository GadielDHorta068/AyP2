package tp6e2;

import java.util.ArrayList;

public class Stack<E> {

	private ArrayList<E> elementos;
	
	public Stack() {
		elementos = new ArrayList<>();
	}
	public boolean isEmpty() {
		return elementos.isEmpty();
	}
	
	public boolean size() {
		return elementos.isEmpty();
	}
	
	public void push(E item) {
		elementos.add(item);
	}
	
	public E pop() {
		if (isEmpty()) {
			System.out.print("Lista vacia");
		}
		return elementos.remove(elementos.size() -1 );
	}
	
	public E peek() {
		if (isEmpty()) {
			System.out.print("Lista vacia");
		}
		return elementos.get(elementos.size() -1 );
	}
    public void clear() {
        elementos.clear();
    }
}
