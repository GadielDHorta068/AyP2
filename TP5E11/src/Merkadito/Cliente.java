package Merkadito;

public class Cliente {
	private int Clientenum;
	private int cantidadProductos;
	private double retardo;
	
	public Cliente(int clientenum, int cantidadProductos) {
		super();
		Clientenum = clientenum;
		this.cantidadProductos = cantidadProductos;
	}
	
	public double getRetardo() {
		return retardo;
	}
}
