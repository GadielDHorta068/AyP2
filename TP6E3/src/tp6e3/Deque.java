package tp6e3;
import java.util.ArrayList;

public class Deque<T> {
    private ArrayList<T> elements;

    
    public Deque() {
        elements = new ArrayList<>();
    }

    
    public boolean isEmpty() {
        return elements.isEmpty();
    }

   
    public int size() {
        return elements.size();
    }

    
    public void addFirst(T item) {
        elements.add(0, item);
    }

    
    public void addLast(T item) {
        elements.add(item);
    }

   
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return elements.remove(0);
    }

    
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return elements.remove(elements.size() - 1);
    }


    public T peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return elements.get(0);
    }

   
    public T peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return elements.get(elements.size() - 1);
    }

    
    public void clear() {
        elements.clear();
    }
}