package tp6e8;

public class LinkedPositionalList<E> implements PositionalList<E> {

	private static class Node<E> implements Position<E> {

		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		@Override
		public E getElement() throws IllegalStateException {
			// TODO Auto-generated method stub
			if (next == null)
				throw new IllegalStateException("Position no valida");
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setElement(E e) {
			element = e;
		}

		public void setPrev(Node<E> p) {
			prev = p;
		}

		public void setNext(Node<E> n) {
			next = n;
		}

	}

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public LinkedPositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null;
		return node;
	}

	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}

	private Node<E> validate(Position<E> p) { // agregar manejo de error, el mundo (no)ES PERFECTO
		Node<E> node = (Node<E>) p;
		return node;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Position<E> first() {
		// TODO Auto-generated method stub
		return position(header.getNext());
	}

	@Override
	public Position<E> last() {
		// TODO Auto-generated method stub
		return position(trailer.getPrev());
	}

	@Override
	public Position<E> addFirst(E e) {
		// TODO Auto-generated method stub
		return addBetween(e, header, header.getNext());
	}

	@Override
	public Position<E> addLast(E e) {
		// TODO Auto-generated method stub
		return addBetween(e, trailer.getPrev(), trailer);
	}

	@Override
	public Position<E> before(Position<E> p) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return node.getPrev();

	}

	@Override
	public Position<E> after(Position<E> p) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return node.getNext();
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	@Override
	public E set(Position<E> p, E e) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}

	@Override
	public E remove(Position<E> p) {
		// TODO Auto-generated method stub
		Node<E> node = validate (p);
		Node<E> predecessor = node.getPrev();
		Node<E> succesor = node.getNext();
		predecessor.setNext(succesor);
		succesor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}

}
