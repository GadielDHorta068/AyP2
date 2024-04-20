package tp5e1;

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
}
