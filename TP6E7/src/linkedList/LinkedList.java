package linkedList;


public class LinkedList<E> implements List {
	private static class Node<E>{
		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		
		public E getElement() {return element;}
		public Node<E> getPrev(){return prev;}
		public Node<E> getNext( ) { return next; }
		public void setPrev(Node<E> p) { prev = p; }
		public void setNext(Node<E> n) { next = n; }
	}
	
	private Node<E> header; // header sentinel
	private Node<E> trailer; // trailer sentinel
	private int size = 0; // number of elements in the list
	
	public LinkedList( ) {
	
		header = new Node<>(null, null, null); // create header
		trailer = new Node<>(null, header, null); // trailer is preceded by header
		header.setNext(trailer); // header is followed by trailer
	 
	}
	public E getFirst() {return header.element;}
	public int size( ) { return size; }
	public boolean isEmpty( ) { return size == 0; }
	public E first( ) {
		if (isEmpty( )) return null;
		return header.getNext( ).getElement( ); // first element is beyond header
	 }
	 
	 public E last( ) {
		 if (isEmpty( )) return null;
		 return trailer.getPrev( ).getElement( ); // last element is before trailer
	}
	 
	 public void addFirst(E e) {
		 addBetween(e, header, header.getNext( )); // place just after the header	  
	 }
		 
		 
	 public void addLast(E e) {
		 addBetween(e, trailer.getPrev( ), trailer); // place just before the trailer
	 }	
	 public E removeFirst( ) {
		 if (isEmpty( )) return null; // nothing to remove
		 return remove(header.getNext( )); // first element is beyond header  
	 }

	 public E removeLast( ) {
		  if (isEmpty( )) return null; // nothing to remove
		  return remove(trailer.getPrev( )); // last element is before trailer
	 }	  
	 private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		  
		 Node<E> newest = new Node<>(e, predecessor, successor);
		 predecessor.setNext(newest);
		 successor.setPrev(newest); 
		 size++; 
	 }
	 private E remove(Node<E> node) {
		 Node<E> predecessor = node.getPrev( );
		 Node<E> successor = node.getNext( );
		 predecessor.setNext(successor);
		 successor.setPrev(predecessor);
		 size--;
		 return node.getElement( );	  
	 }
	@Override
	public void clear() {
		// TODO Auto-generated method stub
        Node<E> current = header;
        while (current != null) {
            Node<E> next = current.next;
            current.element = null;
            current.next = null;
            current.prev = null;
            current = next;
        }
        header = trailer = null;
        size = 0;
	}
	@Override
	public boolean contains(Object e) {
		// TODO Auto-generated method stub
		return indexOf(e) != -1;
	}
	@Override
	public int indexOf(Object e) {
		// TODO Auto-generated method stub
        Node<E> current = header;
        int index = 0;
        while (current != null) {
            if (current.element.equals(e)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
	}
	@Override
	public int lastIndexOf(Object e) {
		// TODO Auto-generated method stub
	      Node<E> current = trailer;
	        int index = size - 1;
	        while (current != null) {
	            if (current.element.equals(e)) {
	                return index;
	            }
	            current = current.prev;
	            index--;
	        }
	        return -1;
	}
	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
        int index = indexOf(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
	}
}
