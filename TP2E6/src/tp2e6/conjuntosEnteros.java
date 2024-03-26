package tp2e6;

public class conjuntosEnteros {
	private int[] enteros;
	private boolean[] bools;
	int i = 0;
	
	//creo el constructor y los parametros
	public conjuntosEnteros(int[] ints, boolean[] booleans) {
		enteros = ints;
		bools = booleans;
		 i = 0;
	}
	//Constructor vacio
	public conjuntosEnteros() {
        enteros = new int[101]; // Arreglo para enteros del rango 0 a 100
        bools = new boolean[101]; // Arreglo para booleanos del rango 0 a 100
         i = 0;
	}

    public void insertarElemento(int nuevo) {
        //insertarElemento - inserta un nuevo entero k en el conjunto (a[k] en true)
        if (nuevo >= 0 && nuevo <= 100) { // Asegura que k esté en el rango válido
            bools[nuevo] = true; // Marca a[k] como true
            enteros[i] = nuevo; // meto el entero en el arreglo
            i++;
        } else {
            System.out.println("El número " + nuevo + " no esta en el rango permitido."); // Manejo de error si k está fuera del rango
        }
    }

    public void eliminarElemento(int entrante) {
        //elimina el entero k del conjunto (a[k] en false)
    	bools[entrante] = false;
    	for (int j = 0 ;j <101 ;j++) {
    		if (enteros[j] == entrante) {
    			enteros[j] = 0;
    			for (int k = i; k<100 ;k++) {
    				enteros[k] = enteros[k+1];
    			}
    		}
    	}
    }

    public String aStringConjunto() {
        //devuelve una cadena que muestra los elementos que están en el conjunto separados por espacios. 
    	
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < bools.length; i++) {
            if (bools[i]) {
                resultado.append(i).append(" "); // Agregar el elemento al resultado seguido de un espacio
            }
        }
        return resultado.toString().trim(); // Eliminar el espacio adicional al final y devolver la cadena
    }

    public boolean esIgualA(conjuntosEnteros primero, conjuntosEnteros segundo) {
        //determino si dos conjuntos son iguales
    	
        // Verifico si los arreglos tienen la misma longitud
        if (primero.bools.length != segundo.bools.length) {
            return false;
        }
        
        if (primero.enteros.length != segundo.enteros.length) {
            return false;
        }
        for (int i = 0; i < 101; i++) {
            if (primero.bools[i] != segundo.bools[i]) {
                return false; // Si algún elemento es diferente, los arreglos no son iguales
            }
        }
        return true;
    }

    public conjuntosEnteros union(conjuntosEnteros primero, conjuntosEnteros segundo) {
        //creo un tercer conjunto con la union de dos conjuntos
    	conjuntosEnteros tercero = new conjuntosEnteros();
    	for (int k=0; k<101; k++) {
    		tercero.bools[k] = primero.bools[k] || segundo.bools[k];	//Operacion OR
    		if (tercero.bools[k] == true ) {
    			tercero.insertarElemento(k);
    		}
    	}
    	return tercero;
    }

    public conjuntosEnteros interseccion(conjuntosEnteros primero, conjuntosEnteros segundo) {
        //creo un tercer conjunto con la interseccion de dos conjuntos
    	conjuntosEnteros tercero = new conjuntosEnteros();
    	for (int k=0; k<101; k++) {
    		tercero.bools[k] = primero.bools[k] && segundo.bools[k];	//Operacion AND
    		if (tercero.bools[k] == true ) {
    			tercero.insertarElemento(k);
    		}
    	}
    	return tercero;
    }
    

    public conjuntosEnteros diferencia(conjuntosEnteros primero, conjuntosEnteros segundo) {
        //creo un tercer conjunto con todos los elementos que estan en el primer elemento y no estan en el segundo
    	conjuntosEnteros tercero = new conjuntosEnteros();
    	for (int k=0; k<101; k++) {
    		tercero.bools[k] = primero.bools[k] && !segundo.bools[k];	//Operacion AND negado B
    		if (tercero.bools[k] == true ) {
    			tercero.insertarElemento(k);
    		}
    	}
    	return tercero;
    }
}

