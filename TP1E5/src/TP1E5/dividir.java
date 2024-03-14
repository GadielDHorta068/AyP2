package TP1E5;

public class dividir {
    public static String calcular(int a, int b) {
    	String resultado;
    	float resto;
    	resto = a % b;
    	
        if (resto == 0) {
            resultado = "Los numeros son multiplo";
        }else {
        	resultado = "Los numeros no son multiplos";
        }
        
        return resultado;
    }
}
