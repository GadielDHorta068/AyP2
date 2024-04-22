package circu;

public class ArrayCircularQueue<E> implements CircularQueue<E>{

	private int maxSize;
	private E[] queueArray;
	private int front;
	private int rear;
	private int currentSize;
	
	public ArrayCircularQueue(int size) {
		maxSize = size+1;//Espacio adicional para distinguir tail de head
		queueArray = (E[]) new Object[maxSize];
		front = 0;
		rear = -1;
		currentSize = 0;
	}
	

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return currentSize == 0;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return currentSize;
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
	    if (isFull()) {
	        throw new IllegalStateException("La cola está llena");
	    }
	    front = (front - 1 + maxSize) % maxSize;
	    queueArray[front] = e;
	    currentSize++;
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		if (isFull()) {
			System.out.println("la cola esta llena");
			return;
		}
        rear = (rear + 1) % maxSize;
        queueArray[rear] = e;
        currentSize++;	
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("lista vacia");
			return null;
		}
		E temp = queueArray[front];
		front = (front + 1) % maxSize;
		currentSize--;
		return temp;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		currentSize--;
		return null;
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
        if (isEmpty()) {
            System.out.println("lista vacia");
            return null;
        }
        return queueArray[front];
	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
        if (isEmpty()) {
            System.out.println("lista vacia");
            return null;
        }
        return queueArray[rear];
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
	      if (!isEmpty()) {
	            E temp = removeFirst();
	            addLast(temp);
	        }
	}


	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return size() == maxSize - 1;
	}

}
