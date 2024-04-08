package tateti;

import tateti.Node.DoubleLinkedList;

public class TestLista {
    public static void main(String[] args) {
    	DoubleLinkedList.class list = new DoubleLinkedList();
        int n = 3; // Tamaño de la lista (n x n)
        // Se agregan elementos a la lista
        for (int i = 1; i <= n * n; i++) {
            list.add(i);
        }
        // Se imprime la lista en forma de matriz n x n
        list.printList();
    }
}
