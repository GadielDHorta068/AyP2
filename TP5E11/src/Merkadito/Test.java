package Merkadito;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int numCajas = 4;
        int maxProductos = 15;
        int numClientes = 80;

        Supermercado supermercado = new Supermercado(numCajas, maxProductos, numClientes);
        supermercado.simular();
	}

}
