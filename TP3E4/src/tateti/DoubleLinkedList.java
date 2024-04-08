package tateti;

 class Node {
	 int data;
	 Node nextHorizontal;
	 Node prevHorizontal;
	 Node nextVertical;
	 Node prevVertical;

	 public Node(int data) {
		 this.data = data;
	     this.nextHorizontal = null;
	     this.prevHorizontal = null;
	     this.nextVertical = null;
	     this.prevVertical = null;   
	 }

public class DoubleLinkedList {
	 Node head;	//Puntero al inicio de la lista
	 int size;	//Tamaño de la lista

	//Constructor de la clase DoublyLinkedList
	 public void DoublyLinkedList() {
		 head = null;
	     size = 0;
	 }

	 public void add(int data) {
		 // Si la lista está vacía, el nuevo nodo se convierte en el nodo principal
		 Node newNode = new Node(data);
	     if (head == null) {
	    	 head = newNode;
	   
	     // Si la lista no está vacía, se busca el último nodo en la dirección horizontal
	     } else {
	    	 Node temp = head;
	    	 while (temp.nextHorizontal != null) {
	    		 temp = temp.nextHorizontal;  
	    	 }
	    	 // Se agrega el nuevo nodo al final de la lista
	    	 temp.nextHorizontal = newNode;
	    	 newNode.prevHorizontal = temp;	
	     }
	     size++;	
	 }
	// Método para imprimir los elementos de la lista en forma de matriz n x n
	 public void printList() {
		 Node temp = head;
		 while (temp != null) {
			 Node verticalTemp = temp;
	         while (verticalTemp != null) {
	        	//Se imprime el valor del nodo actual
	        	 System.out.print(verticalTemp.data + " ");
	        	 
	        	//Se pasa al siguiente nodo en la dirección vertical
	             verticalTemp = verticalTemp.nextVertical;
	         }
	         System.out.println();
	         
	         //Se pasa al siguiente nodo en la dirección horizontal
	         temp = temp.nextHorizontal;
	         }
	 	}	 
	}
}

