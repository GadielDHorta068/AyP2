package tp2e6;

import java.util.Random;

public class testConjuntosEnteros {
	public static void main(String[] args) {
        // Crear dos conjuntos para probar
        conjuntosEnteros conjunto1 = new conjuntosEnteros();
        conjuntosEnteros conjunto2 = new conjuntosEnteros();

        // Agrego elementos en conjunto1
        conjunto1.insertarElemento(10);
        conjunto1.insertarElemento(20);
        conjunto1.insertarElemento(30);

        // Agrego elementos en conjunto2
        conjunto2.insertarElemento(20);
        conjunto2.insertarElemento(40);
        conjunto2.insertarElemento(50);

        // Pruebo el m�todo aStringConjunto
        System.out.println("Conjunto 1: " + conjunto1.aStringConjunto());
        System.out.println("Conjunto 2: " + conjunto2.aStringConjunto());

        // Pruebo el m�todo esIgualA
        System.out.println("�Conjunto 1 es igual a Conjunto 2? " + conjunto1.esIgualA(conjunto1, conjunto2));

        // Pruebo el m�todo union
        conjuntosEnteros union = conjunto1.union(conjunto1, conjunto2);
        System.out.println("Uni�n de Conjunto 1 y Conjunto 2: " + union.aStringConjunto());

        // Pruebo el m�todo interseccion
        conjuntosEnteros interseccion = conjunto1.interseccion(conjunto1, conjunto2);
        System.out.println("Intersecci�n de Conjunto 1 y Conjunto 2: " + interseccion.aStringConjunto());

        // Pruebo el m�todo diferencia
        conjuntosEnteros diferencia = conjunto1.diferencia(conjunto1, conjunto2);
        System.out.println("Diferencia entre Conjunto 1 y Conjunto 2: " + diferencia.aStringConjunto());
    }
}
