package tp5e1;

public class Test {

	 public static void main(String[] args) {
	        long startTime; 
	        long endTime;
	        int n = 1000000; 

	        // Usando un array
	        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
	        startTime = System.currentTimeMillis();
	        for (int i = 0; i < n; i++) {
	            arrayStack.push(i);
	            arrayStack.pop();
	        }
	        endTime = System.currentTimeMillis();
	        System.out.println("Array Stack: " + (endTime - startTime) + " ms");

	        // Usando una lista enlazada
	        SinglyLinkedStack<Integer> linkedListStack = new SinglyLinkedStack<Integer>();
	        startTime = System.currentTimeMillis();
	        for (int i = 0; i < n; i++) {
	            linkedListStack.push(i);
	            linkedListStack.pop();
	        }
	        endTime = System.currentTimeMillis();
	        System.out.println("Lista enlazada Stack: " + (endTime - startTime) + " ms");

	        // Usando una lista doblemente enlazada
	        DoublyLinkedStack<Integer> doublyLinkedListStack = new DoublyLinkedStack<Integer>();
	        startTime = System.currentTimeMillis();
	        for (int i = 0; i < n; i++) {
	            doublyLinkedListStack.push(i);
	            doublyLinkedListStack.pop();
	        }
	        endTime = System.currentTimeMillis();
	        System.out.println("lista doble enlazada Stack: " + (endTime - startTime) + " ms");
	    }

}
