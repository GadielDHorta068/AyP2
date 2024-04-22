package Merkadito;

public class Cliente {
	 private int numeroCliente;
	    private int cantidadProductos;
	    private double retardo;

	    public Cliente(int numeroCliente, int cantidadProductos, double retardo) {
	        this.numeroCliente = numeroCliente;
	        this.cantidadProductos = cantidadProductos;
	        this.retardo = retardo;
	    }

	    public int getNumeroCliente() {
	        return numeroCliente;
	    }

	    public int getCantidadProductos() {
	        return cantidadProductos;
	    }

	    public double getRetardo() {
	        return retardo * cantidadProductos;
	    }
}
