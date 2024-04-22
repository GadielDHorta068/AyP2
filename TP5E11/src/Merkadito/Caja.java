package Merkadito;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Caja {
	private int numCaja;
	private List<Cliente> clientesEnCola;
	private double retardo;
	
	public Caja(int numCaja) {
		super();
		this.numCaja = numCaja;
		this.clientesEnCola = new ArrayList<>();
		this.retardo = new Random().nextDouble();
	}
	
	public void agregarCliente(Cliente cliente) {
		clientesEnCola.add(cliente);
	}
	
	public void atender(Cliente cliente) {
		double tiempoAtencion = cliente.getRetardo() + retardo;
		//llevar algo mas?
	}
	
	public List<Cliente> getClientes(){
		return clientesEnCola;
	}
}
