package clone;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Crear una instancia de ArrayStack
        ArrayStack<Integer> originalStack = new ArrayStack<>();
        originalStack.push(1);
        originalStack.push(2);
        originalStack.push(3);
        originalStack.pop();

        // Clonar la instancia original
        ArrayStack<Integer> clonedStack = originalStack.clone();

        // Mostrar los elementos del original y del clon
        System.out.println("Original Stack:");
        while (!originalStack.isEmpty()) {
            System.out.println(originalStack.pop());
        }

        System.out.println("\nCloned Stack:");
        while (!clonedStack.isEmpty()) {
            System.out.println(clonedStack.pop());
        }
	}

}
