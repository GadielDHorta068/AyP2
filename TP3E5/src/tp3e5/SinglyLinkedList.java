package tp3e5;

public class SinglyLinkedList<E> {
	/* ------------------Clase Nodo------------------*/
	private static class Node<E>{
		private E elemento;				//Referencia del elemento guardado en este nodo
		private Node<E> siguiente;		//Referencia al siguiente nodo in la lista
		public Node (E e, Node<E> n) {
			elemento = e;
			siguiente = n;
		}
		public E getElemento() {return elemento;}
		public Node<E> getSiguiente(){return siguiente;}
		
		public void setSiguiente(Node<E> n) {siguiente = n;}
	}
	/* -----------------Fin Nodo----------------*/
	
	private Node<E> head = null;	//Nodo head de la lista, null si esta vacio
	private Node<E> tail = null;	//Nodo tail, null si esta vacio
	private int size = 0;			//Numero de nodos en la lista
	
	public SinglyLinkedList() {};	//Constructor vacio
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	public E first() {				//Devolver primer elemento
		if(isEmpty()) {
			return null;
		}
		return head.getElemento();
	}
	public E last() {				//Devolver ultimo elemento
		if(isEmpty()) {
			return null;
		}
		return tail.getElemento();
	}
	
	public void addFirst(E e) {		//Aniadir un elemento al inicio de la lista
		head = new Node<>(e, head);	// Crear y linkear al nuevo nodo
		if (size == 0) {
			tail = head;			//Caso especial que el nuevo nodo tambien es cola
		}
		size++;
	}
	
	public void addLast(E e) {		//Aniadir elemento e al final de lista
		Node<E> newest = new Node<>(e, null);
		if (isEmpty()) {
			head = newest;			//Caso especial, lista anteriormente vacia
		}else {
			tail.setSiguiente(newest);//Nuevo nodo luego de cola existente
		}
		tail = newest;				//Nuevo nodo es la cola
		size++;
	}
	
	public E removeFirst() {		//remueve y devuelve el primer elemento
		if (isEmpty()) {			//Nada a remover
			return null;	
		}
		E answer = head.getElemento();
		head = head.getSiguiente();
		size--;
		if (size == 0) {
			tail = null;			//Si ahora la lista esta vacia
		}
		return answer;
	}
	
	
	
    /* Inserta el elemento e en la posicion n de la lista */
    public void addPos(E e, int n) throws IndexOutOfBoundsException {
    	if (0>n || n>size) {
    		throw new IndexOutOfBoundsException("posicion no valida");
    	}
    	
    	if(n==0) {						// Si la posición es 0,addFirst
    		addFirst(e);
    	}else if (n== size) {			// Si la posición es el tamaño, addLast
    		addLast(e);					
    	}else {							// Inserta el elemento en la posición especificada
    		Node<E> current = head;
    		for (int i=0; i< n-1; i++) {
    			current = current.getSiguiente();
    		}
    		current.setSiguiente(new Node<>(e, current.getSiguiente()));
    	}
    }

    /* Elimina el elemento e de la lista */
    /* Retorna NULL si no lo encuentra */
    public E removeElement(E e) {
		Node<E> current = head;
		Node<E> previous = null;
    	
		 // Recorre la lista hasta encontrar el elemento o llegar al final
		while (current != null && !current.getElemento().equals(e)) {
			previous = current;
			current = current.getSiguiente();
		}
		if (current == null) {	//Si noencuentra devuelve null
			return null;
		}
		if (current == head) {	//Si el elemento es el primer nodo, ajusta head
			head = current.getSiguiente();	
		}else {					//Si no es el primer nodo, ajusta los enlaces
			previous.setSiguiente(current.getSiguiente());
		}
		if (current == tail) {	//Si el elemento es el último nodo, ajusta tail
			tail = previous;
		}
		size--;					//Bajar el tamanio de la lista
		return current.getElemento();
    }

    /* Elimina elemento que se encuentra en la posicion n de la lista */
    /* Retorna NULL si no es una posicion valida */
    public E removePos(int n) throws IndexOutOfBoundsException {
        if (n < 0 || n >= size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (n == 0) {	//Si la pos es 0, removeFirst
            return removeFirst();
        } else {		//Eliminar el elemento de la pos especificada
            Node<E> current = head;
            for (int i = 0; i < n - 1; i++) {
                current = current.getSiguiente();
            }
            E removedElement = current.getSiguiente().getElemento();
            current.setSiguiente(current.getSiguiente().getSiguiente());
            if (n == size - 1) {	//Si el eliminado es ultimo, ajusta tail
                tail = current;
            }
            size--;	//Bajar tamanio de lista
            return removedElement;
        }	
    }

    /* Inserta todos los elementos de la Lista l al final de la lista */
    public void concatenate(SinglyLinkedList l) {
        if (l.isEmpty()) {	//Si l esta vacio, no hacer nada
            return;
        }
        if (isEmpty()) {	//Si la lista actual esta vacia, copia los atributos
            head = l.head;
            tail = l.tail;
            size = l.size;
        } else {	//Si l no esta vacia, ajustar tail y size y enlazar las listas
            tail.setSiguiente(l.head);
            tail = l.tail;
            size += l.size;
        }
    }

    /* Busca el elemento e dentro de la lista */
    /* Retorna el elemnto si lo encuentra o Null si no esta en la lista */
    public E search(E e) {
        Node<E> current = head;
        while (current != null) {					//Recorrer lista
        	if (current.getElemento().equals(e)) {	//Retorna el lemento si lo encuentra
                return current.getElemento();
            }
            current = current.getSiguiente();
        }
        return null;	//Si no se encuentra retorna null
    }

    /* Verifica si dos listas son iguales */
    @Override
    public boolean equals(Object o) {
    	 if (o == this) {	
             return true;	//Son la misma instancia?
         }
         if (!(o instanceof SinglyLinkedList)) {
             return false;	//Instrancia de SinglyLinkedList?
         }
         
         //Cast a SinglyLinkedList
         SinglyLinkedList<?> other = (SinglyLinkedList<?>) o;
         if (size != other.size) {	//Mismo tamanio?
             return false;
         }
         Node<E> current = head;
         Node<?> otherCurrent = other.head;
         while (current != null) {	//Comparar los elementos de ambas listas
             if (!current.getElemento().equals(otherCurrent.getElemento())) {
                 return false;
             }
             current = current.getSiguiente();
             otherCurrent = otherCurrent.getSiguiente();
         }
         return true;
    }

    /* Retorna una copia de una lista dada */
    @Override
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> newList = new SinglyLinkedList<>();
        Node<E> current = head;
        while (current != null) {	//Recorrer y agregar elementos
            newList.addLast(current.getElemento());
            current = current.getSiguiente();
        }
        return newList;
    }
}