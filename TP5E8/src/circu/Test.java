package circu;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayCircularQueue<Integer> queue = new ArrayCircularQueue<>(5);

	        // Agregar elementos al final
	        queue.addLast(1);
	        queue.addLast(2);
	        queue.addLast(3);
	        queue.addLast(4);
	        queue.addLast(5);

	        // Mostrar elementos
	        System.out.println("Elementos en la cola:");
	        while (!queue.isEmpty()) {
	            System.out.println(queue.removeFirst());
	        }

	        // Agregar elementos al principio
	        queue.addFirst(6);
	        queue.addFirst(7);

	        // Mostrar elementos
	        System.out.println("Elementos en la cola después de agregar al principio:");
	        while (!queue.isEmpty()) {
	            System.out.println(queue.removeFirst());
	        }

	        // Probar rotación
	        queue.addLast(8);
	        queue.addLast(9);
	        queue.addLast(10);
	        System.out.println("Elementos en la cola antes de la rotación:");
	        System.out.println(queue.first());
	        System.out.println(queue.last());
	        queue.rotate();
	        System.out.println("Elementos en la cola después de la rotación:");
	        System.out.println(queue.first());
	        System.out.println(queue.last());
	}

}
