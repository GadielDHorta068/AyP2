package tp2e11;

import java.util.ArrayList;

public class Factura implements PorPagar {
 /*Crear la clase Factura que tiene el nombre del proveedor,
  *  número de factura, fecha de compra y una lista de ítems que tiene la descripción,
  *   el precio unitario y la cantidad comprada.  */
	
	private String nombreProveedor;
	private int numFactura;
	private String fechaCompra;
	private ArrayList<Item> items;
	private double montoTotal;
	
	public Factura(double montoTotal) {
		this.montoTotal = montoTotal;
	}
    public double obtenerPago() {
        return montoTotal;
    }
	
    public Factura(String nombreProveedor, int numeroFactura, String fechaCompra) {
        this.nombreProveedor = nombreProveedor;
        this.numFactura = numeroFactura;
        this.fechaCompra = fechaCompra;
        this.items = new ArrayList<>();
    }
    
    //geters seters de items
    public void agregarItem(Item item) {
        items.add(item);
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }
    //Demas seters geters
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getNumeroFactura() {
        return numFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numFactura = numeroFactura;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
