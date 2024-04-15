package tp3e5;

public class TestLista {

	 public static void main(String[] args) {
	        TestLista tester = new TestLista();
	        tester.addPos();
	        tester.testRemoveElement();
	        tester.testRemovePos();
	        tester.testConcatenate();
	        tester.testSearch();
	        tester.testEquals();
	        try {
	            tester.testClone();
	        } catch (CloneNotSupportedException e) {
	            System.out.print("Fallo la clonacion");
	            e.printStackTrace();
	        }
	        System.out.println("fin");
	    }
	public void addPos() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		list.addPos(5, 2);
		System.out.println("Prueba AddPos: " + list.toString());
	
	}

	public void testRemoveElement() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		list.removeElement(3);
		list.removeElement(4);
		System.out.println("Prueba Remove Element: " + list.toString());
	}

	
	public void testRemovePos() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.addFirst("Mate");
		list.addLast("Vigilante");
		list.addLast("Municipal");
		list.removePos(1);
		System.out.println("Prueba Remove Pos: " + list.toString());
	}

	
	public void testConcatenate() {
		SinglyLinkedList<String> list1 = new SinglyLinkedList<>();
		list1.addFirst("1");
		list1.addLast("2");
	    
		SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
		list2.addLast("Algoritmica");
		list2.addLast("Programacion");
		list1.concatenate(list2);
		System.out.println("Prueba Concatenate: " + list1.toString());
	}

	public void testSearch() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.addLast("Gato");
		list.addLast("Perro");
		list.addLast("Raton");
		list.search("Perro");
		System.out.println(list.search("Raton"));
		System.out.println(list.search("Rat"));
	}

	public void testEquals() {
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
		list1.addFirst(1);
		list1.addLast(2);
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
		list2.addFirst(1);
		list2.addLast(2);
		System.out.println("Test Equals: " + list1.equals(list2));
	}

	
	
	public void testClone() throws CloneNotSupportedException {
	SinglyLinkedList<String> original = new SinglyLinkedList<>();
	    original.addLast("Milton");
		original.addLast("Murray");
		original.addLast("Robert");
		SinglyLinkedList<String> cloned = original.clone();
		System.out.println("Prueba Clone: " + cloned.toString());
	    
	}	
}

