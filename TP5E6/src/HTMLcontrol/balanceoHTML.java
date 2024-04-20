package HTMLcontrol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class balanceoHTML {
    public static void main(String[] args) {
    	if (args.length != 1) {
            System.err.println("Uso: java BalanceoHTML <filename>");
            System.exit(1);
        }
        String filename = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        	Stack<Character> stack = new Stack<>();
        	int numeroLinea = 0;
        	
        	String linea;
        	while((linea = reader.readLine()) != null) {
        		numeroLinea++;
        		
        		for (char c : linea.toCharArray()) {
        			if (picoAbre(c)) {
        				stack.push(c);
        			}else if (picoCierra(c)) {
        				if(stack.isEmpty()) {
        					System.out.println("pico desbalanceado en la linea " + numeroLinea);
        					return;
        				}
        				char top = stack.pop();
                        if (!esPar(top, c)) {
                            System.out.println("Desbalanceo en " + numeroLinea);
                            return;
                        }
        			}
        		}
        	}
    	  
        	if (!stack.isEmpty()) {
        		System.out.println("distintos signos en " + numeroLinea);
        	} else {
                  System.out.println("Signos balanceados");
        	}
        	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //Metodos para comparar characteres
    private static boolean picoCierra(char c) {
        return c == '>';
    }
    
    private static boolean picoAbre(char c) {
        return c == '<';
    }
    
    private static boolean esPar(char open, char close) {
        return (open == '<' && close == '>');
    }
}