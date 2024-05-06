package circu;

public interface Queue<E> {

	public void addFirst(E e);
	//public void addLast(E e);
	public E removeFirst();
	//public E removeLast();
	public E first();
	public E last();
	public int size();
	public boolean isEmpty();
	public boolean isFull();
}
