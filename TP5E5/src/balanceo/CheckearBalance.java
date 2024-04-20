package balanceo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class CheckearBalance {
    public static void main(String[] args) {
    	if (args.length != 1) {
            System.err.println("Uso: java BalanceChecker <filename>");
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
        			if (parentesisAbre(c) || corcheteAbre(c) || llaveAbre(c)) {
        				stack.push(c);
        			}else if (parentesisCierra(c) || corcheteCierra(c) || llaveCierra(c)) {
        				if(stack.isEmpty()) {
        					System.out.println("Signo sin pareja en la linea " + numeroLinea);
        					return;
        				}
        				/* Nota a mi futuro, aca la teca
        				 * Aca agarro el tope elemento que tendria que estar
        				 * en la pila, que deberia ser el par para el simbolo de cierre encontrado
        				 */
        				char top = stack.pop();
                        if (!esPar(top, c)) {
                            System.out.println("Desbalanceo en " + numeroLinea);
                            return;
                        }
        			}
        		}
        	}
        	  
        	if (!stack.isEmpty()) {
        		System.out.println("distintos signos de apertura en " + numeroLinea);
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
	private static boolean parentesisAbre(char c) {
        return c == '(';
    }

    private static boolean parentesisCierra(char c) {
        return c == ')';
    }

    private static boolean corcheteAbre(char c) {
        return c == '[';
    }

    private static boolean corcheteCierra(char c) {
        return c == ']';
    }

    private static boolean llaveAbre(char c) {
        return c == '{';
    }

    private static boolean llaveCierra(char c) {
        return c == '}';
    }
    
    private static boolean picoCierra(char c) {
        return c == '>';
    }
    
    private static boolean picoAbre(char c) {
        return c == '<';
    }
    
    
    private static boolean esPar(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }
}
