package Aplicacion;

import net.datastructures.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
		Position<String> p1, p2, p3, p4, p5, p6;

		p1 = t.addRoot("X");
		p2 = t.addLeft(p1, "+");
		p3 = t.addRight(p1, "3");
		p4 = t.addLeft(p2, "5");
		p5 = t.addRight(p4, "");
		p6 = t.addRight(p2, "2");

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
		for (int i = 0; i < t.height(p1) + 1; i++) {
			System.out.println();
			System.out.println("Imprimir nivel " + i);
			for (Position<String> p : t.postorder()) {
				if (t.depth(p) == i) {
					System.out.print(p.getElement() + " ");
				}
			}
		}
	}
}
