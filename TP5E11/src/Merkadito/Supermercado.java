package Merkadito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Supermercado {
	private List<Caja> cajas;
	private int limiteProductos;
	private List<Cliente> clientes;
	private double timeSimulacion;
	
	
	public Supermercado(int cajas, int limiteProductos, int numclientes) {
		
		this.cajas = new ArrayList<>();
		for (int i= 0; i < cajas; i++) {
		//	cajas.add(new Caja());
		}
		this.limiteProductos = limiteProductos;
		this.clientes = new ArrayList<>();
		for (int i=0; i< numclientes; i++) {
			clientes.add(new Cliente(i, new Random().nextInt(limiteProductos) +1));
		}
	}
	
	public void simular() {
		while (!clientes.isEmpty()) {
			Cliente cliente = clientes.remove(0);
			Caja cajaMenosOcupada = cajas.stream().min((caja1, caja2) -> Integer.compare(caja1.getClientes().size(), caja2.getClientes().size()))
                    .orElse(null);
			if (cajaMenosOcupada != null) {
				cajaMenosOcupada.atender(cliente);
			}
		}
		
		for(Caja caja : cajas) {
			while(!clientes.isEmpty()) {
				Cliente cliente = caja.getClientes().remove(0);
				caja.atender(cliente);
				timeSimulacion += cliente.getRetardo();
			}	
		}
		reporte();
	}
	public void reporte() {
		//Tirar stats facheras
		System.out.println("gracias vuelva prontos");
	}
	
}
