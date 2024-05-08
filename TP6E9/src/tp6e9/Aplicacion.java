package tp6e9;

import net.datastructures.*;

public class Aplicacion {

	public static void main(String[] args) {
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();

		list.addFirst(2);
		list.addFirst(1);
		list.addAfter(list.first(), 3);

		System.out.println("Lista inicial: " + list);

		list.addBefore(list.last(), 5);

		list.addLast(7);

		System.out.println("Lista después de addLast y addBefore: " + list);
	}
}
