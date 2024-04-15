package net.datastructures;

public class Test {
	  public static void main(String[] args) {
	        // Crear una lista
	        SinglyLinkedList<Integer> lista = new SinglyLinkedList<>();

	        // Agregar elementos a la lista
	        lista.addLast(10);
	        lista.addLast(20);
	        lista.addLast(30);
	        lista.addLast(40);

	        // Imprimir la lista antes de las operaciones
	        System.out.println("Lista original: " + lista);

	        // Prueba de los métodos get y remove
	        try {
	            System.out.println("Elemento en la posición 0: " + lista.get(1));
	            System.out.println("Elemento eliminado en la posición 0: " + lista.remove(0));
	            System.out.println("Lista después de eliminar: " + lista);
	        } catch (IndexOutOfBoundsException e) {
	            System.out.println("Índice fuera de rango");
	        }
	        
	        try {
	            lista.add(1, 25);
	            System.out.println("Lista después de agregar en posición 1: " + lista);
	        } catch (IndexOutOfBoundsException e) {
	            System.out.println("Error: Índice fuera de rango");
	        }
	    }
}
