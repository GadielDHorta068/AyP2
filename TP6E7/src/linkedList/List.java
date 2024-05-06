package linkedList;

public interface List<E> {
	void clear();
	boolean contains(E e);
	int indexOf(E e);
	int lastIndexOf(E e);
	boolean remove(E e);
}
