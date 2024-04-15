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

	        // Prueba de los m�todos get y remove
	        try {
	            System.out.println("Elemento en la posici�n 0: " + lista.get(1));
	            System.out.println("Elemento eliminado en la posici�n 0: " + lista.remove(0));
	            System.out.println("Lista despu�s de eliminar: " + lista);
	        } catch (IndexOutOfBoundsException e) {
	            System.out.println("�ndice fuera de rango");
	        }
	        
	        try {
	            lista.add(1, 25);
	            System.out.println("Lista despu�s de agregar en posici�n 1: " + lista);
	        } catch (IndexOutOfBoundsException e) {
	            System.out.println("Error: �ndice fuera de rango");
	        }
	    }
}
