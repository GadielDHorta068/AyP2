package clone;

import java.util.EmptyStackException;

public class SinglyLinkedStack<E> implements Stack<E>{
	private SinglyLinkedList<E> list;
	 
	 public SinglyLinkedStack() {
		 list = new SinglyLinkedList<>();
	 }

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		list.addFirst(e);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if (isEmpty()){
			throw new EmptyStackException();
		}
		return list.removeFirst();
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return list.first();
	}
	@Override
	public SinglyLinkedStack<E> clone() {
	    // Creamos una nueva instancia de SinglyLinkedStack
	    SinglyLinkedStack<E> clonedStack = new SinglyLinkedStack<>();
	    
	    // Clonamos la lista enlazada
	    SinglyLinkedList<E> clonedList = null;
		try {
			clonedList = list.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	    
	    // Asignamos la lista clonada al nuevo stack clonado
	    clonedStack.list = clonedList;
	    
	    return clonedStack;
	}
}
