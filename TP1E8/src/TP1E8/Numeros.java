package TP1E8;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Numeros {

    int positivos;
    int negativos;
    int ceros;

    List<Integer> lista = new ArrayList<>();

    public static void main(String[] args) {
        Numeros numeros = new Numeros(); // Crear una instancia de la clase Numeros
        Scanner myScanner = new Scanner(System.in);

        // Cargar todos los elementos en la lista
        for (int i = 0; i < 10; i++) {
            System.out.println("Escribir nuevo numero");
            numeros.lista.add(myScanner.nextInt());
        }

        // Llamar al m�todo recorrerLista()
        numeros.recorrerLista();

        // Imprimir los resultados
        System.out.println("Cantidad de n�meros positivos: " + numeros.positivos);
        System.out.println("Cantidad de n�meros negativos: " + numeros.negativos);
        System.out.println("Cantidad de ceros: " + numeros.ceros);
    }

    // Recorre la lista en busca de n�meros
    public void recorrerLista() {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == 0) {
                ceros++;
            } else if (lista.get(i) > 0) {
                positivos++;
            } else {
                negativos++;
            }
        }
    }
}

/*Escribir un programa que lee diez n�meros e
 *  imprima la cantidad de n�meros negativos, positivos y ceros. */
