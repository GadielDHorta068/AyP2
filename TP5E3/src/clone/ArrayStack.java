package clone;

public class ArrayStack<E> implements Stack<E> {

	public static final int CAPACITY = 1000;
	private E[] data;
	private int t= -1;
	public ArrayStack() {this(CAPACITY);}
	public ArrayStack(int capacity) {
		// TODO Auto-generated constructor stub
		data = (E[]) new Object[capacity];
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return (t+1);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (t == -1);
	}

	@Override
	public void push(E e) throws IllegalStateException{
		// TODO Auto-generated method stub
		if (size()== data.length) throw new IllegalStateException("Stack lleno");
		data[++t] = e;
	}

	@Override
	public E top() {
		if (isEmpty()) return null;
		return data[t];
	}

	@Override
	public E pop() {
		if(isEmpty()) return null;
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}
	
	@Override
	public ArrayStack<E> clone() {
		ArrayStack<E> cloned = new ArrayStack<>(data.length);
		for (int i =0; i <= t; i++) {
			cloned.data[i] = data[i];
		}
		cloned.t = t;
		return cloned;
	}
}
