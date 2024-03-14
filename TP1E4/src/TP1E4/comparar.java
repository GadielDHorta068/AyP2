package TP1E4;

public class comparar {
    public static String calcular(int a) {
    	float modulo;
    	String res;
    	
    	modulo = a % 2;
    	
    	if (modulo == 0) {
    		res = "Es par";
    	}else {
    		res = "Es Impar";
    	}
    	return res;
    }
}
