package tp1e20;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub                                              
	        // declaración de números complejos
	        complejo c1 = new complejo(1.0, 1.0);
	        complejo c2 = new complejo(2.0, 2.0);
	        complejo c3;
	        // operadores aritméticos
	        c3 = c1.suma(c2);
	        System.out.println(c1 + " + " + c2 + " = " + c3);
	        c3 = c1.resta(c2);
	        System.out.println(c1 + " - " + c2 + " = " + c3);
	        c3 = c1.dividir(c2);
	        System.out.println(c1 + " / " + c2 + " = " + c3);
	        c3 = c1.multiplicar(c2);
	        System.out.println(c1 + " * " + c2 + " = " + c3);
	        c3 = c1.multiplicar(3.5);
	        System.out.println(c1 + " * 3.5 = " + c3);
	        if (c2.equals(c3)) {
	            System.out.println(c2 + " igual que " + c3);
	        } else {
	            System.out.println(c2 + " distinto que " + c3);
	        }
	}

}
