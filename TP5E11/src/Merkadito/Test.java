package Merkadito;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int numCajas = 3;
        int maxProductos = 2000;
        int numClientes = 50;

        Supermercado supermercado = new Supermercado(numCajas, maxProductos, numClientes);
        supermercado.simular();
	}

}
