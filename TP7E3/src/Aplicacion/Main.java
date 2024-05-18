package Aplicacion;

import net.datastructures.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
     
        Position<String> p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17;
        
        // Raíz
        p1 = t.addRoot("*");	
		for (Position<String> p : t.inorder()) {
			System.out.print(p.getElement() + " ");
		}
		System.out.println();
        
        // División izquierda del árbol
        p2 = t.addLeft(p1, "/");		
		for (Position<String> p : t.inorder()) {
			System.out.print(p.getElement() + " ");
		}
		System.out.println();

		// Multiplicación izquierda
        p3 = t.addLeft(p2, "*");
        p4 = t.addLeft(p3, "+");
        p5 = t.addRight(p3, "-");
		for (Position<String> p : t.inorder()) {
			System.out.print(p.getElement() + " ");
		}
		System.out.println();
		
        t.addLeft(p4, "5");
        t.addRight(p4, "2");
        
        t.addLeft(p5, "2");
        t.addRight(p5, "1");
		for (Position<String> p : t.inorder()) {
			System.out.print(p.getElement() + " ");
		}
		System.out.println();
        // Suma derecha de la división
        p6 = t.addRight(p2, "+");
        
		for (Position<String> p : t.inorder()) {
			System.out.print(p.getElement() + " ");
		}
		System.out.println();
        
        // Suma izquierda de la suma derecha
        p7 = t.addLeft(p6, "+");
        t.addLeft(p7, "2");
        t.addRight(p7, "9");
        
		for (Position<String> p : t.inorder()) {
			System.out.print(p.getElement() + " ");
		}
		System.out.println();
		
        // Resta derecha de la suma derecha
        p8 = t.addRight(p6, "-");
        p9 = t.addLeft(p8, "-");
        
        t.addLeft(p9, "7");
        t.addRight(p9, "2");
        
        t.addRight(p8, "1");
        
		for (Position<String> p : t.inorder()) {
			System.out.print(p.getElement() + " ");
		}
		System.out.println();
        // Multiplicación derecha de la raíz
        t.addRight(p1, "8");
		for (Position<String> p : t.inorder()) {
			System.out.print(p.getElement() + " ");
		}
		
		
		for (int i = 0; i < t.height(p1) + 1; i++) {
			System.out.println();
			System.out.println("Imprimir nivel " + i);
			for (Position<String> p : t.postorder()) {
				if (t.depth(p) == i) {
					System.out.print(p.getElement() + " ");
				}
			}
		}
		
		System.out.println();
		System.out.println("Formula");
		for (Position<String> p : t.postorder()) {
			System.out.print(p.getElement() + " ");
		}
		System.out.println();
		
		System.out.println("Calculo el resultado usando Postorder");
		System.out.println(calculoPila(t));
		
		System.out.println();
		
		System.out.println("breadth original");
		for (Position<String> p : t.breadthfirst()) {
			System.out.print(p.getElement() + " ");
		}
		
		System.out.println();
		System.out.println("breadth por pila en metodo");
		for (Position<String> p : t.breadthfirstStack()) {
			System.out.print(p.getElement() + " ");
		}
	}
	
	
	public static double calculoPila(LinkedBinaryTree<String> t) {
		Stack<Double> stack = new Stack<>();
		
		for (Position<String> p : t.postorder()) {
			String element = p.getElement();
			if(operador(element)) {
				double right = stack.pop();
				double left = stack.pop();
				stack.push(calcular(element, left,  right));
			}
			else {
				stack.push(Double.parseDouble(element));
			}
		}
		return stack.pop();
	}
	
	private static boolean operador(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}
	
	private static double calcular(String operator, double left, double right) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
