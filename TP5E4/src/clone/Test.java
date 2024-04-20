package clone;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SinglyLinkedStack<Integer> originalStack = new SinglyLinkedStack<>();
        originalStack.push(1);
        originalStack.push(2);
        originalStack.push(3);
        
		SinglyLinkedStack<Integer> clonedStack = originalStack.clone();
		
		// Imprimimos la pila original
		System.out.println("Pila Original:");
		printStack(originalStack);
		
		// Imprimimos la pila clonada
		System.out.println("Pila clonada:");
		printStack(clonedStack);
		
		// Modificamos la pila original
		originalStack.push(4);
		
		// Imprimimos nuevamente la pila original
		System.out.println("pila original impresa:");
		printStack(originalStack);
		
		// Imprimimos nuevamente la pila clonada
		System.out.println("Pila clonada despues de cambiar la original:");
		printStack(clonedStack);
    }
    
    private static <E> void printStack(SinglyLinkedStack<E> stack) {
        SinglyLinkedStack<E> tempStack = new SinglyLinkedStack<>();
        while (!stack.isEmpty()) {
            E element = stack.pop();
            System.out.println(element);
            tempStack.push(element);
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
	}
}
