package TP1E3;

public class comparar {
    public static String calcular(int a, int b) {
    	String resultado;
        if (a > b) {
            resultado = a + " es más grande";
        } else if (a < b) {
            resultado = b + " es más grande";
        } else {
            resultado = "Son iguales";
        }
        
        return resultado;
    }
}
