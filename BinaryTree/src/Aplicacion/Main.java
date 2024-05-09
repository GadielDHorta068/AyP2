package Aplicacion;

import net.datastructures.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();

		Position<String> p1, p2, p3, p4, p5, p6;

		p1 = t.addRoot("A");
		p2 = t.addLeft(p1, "B");
		p3 = t.addRight(p1, "F");
		p4 = t.addLeft(p2, "C");
		p5 = t.addRight(p4, "E");
		p6 = t.addRight(p2, "A");

		System.out.println("Preorden");
		for (Position<String> p : t.preorder()) {
			System.out.print(p.getElement() + " ");
		}
		System.out.println();
		System.out.println("Enorden");
		for (Position<String> p : t.inorder()) {
			System.out.print(p.getElement() + " ");
		}
		System.out.println();
		System.out.println("Posorden");
		for (Position<String> p : t.postorder()) {
			System.out.print(p.getElement() + " ");
		}

		System.out.println();
		System.out.println("breadthfirst");
		for (Position<String> p : t.breadthfirst()) {
			System.out.print(p.getElement() + " ");
		}
		System.out.println();
		System.out.println("Height de p5 " + t.height(p5));
		System.out.println("Depth de p5 " + t.depth(p5));
		
		System.out.println(t.sibling(p1));
		
		System.out.println();
		System.out.println("Imprimir nivel");
		for (Position<String> p : t.postorder()) {
			if (t.depth(p) == 3){
				System.out.print(p.getElement() + " ");
		}
			
		}
	}

}
