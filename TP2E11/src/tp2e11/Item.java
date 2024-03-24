package tp2e11;

public class Item {
	 private String descripcion;
	 private double precioUnitario;
	 private int cantidad;

	 public Item(String descripcion, double precioUnitario, int cantidad) {
	    this.descripcion = descripcion;
	    this.precioUnitario = precioUnitario;
	    this.cantidad = cantidad;
	 }

	 // Getters y setters
	 public String getDescripcion() {
		 return descripcion;
	 }

	 public void setDescripcion(String descripcion) {
		 this.descripcion = descripcion;
	 }

	 public double getPrecioUnitario() {
	     return precioUnitario;
	 }

	 public void setPrecioUnitario(double precioUnitario) {
	    this.precioUnitario = precioUnitario;
	 }
	 
	 public int getCantidad() {
	    return cantidad;
	 }

	 public void setCantidad(int cantidad) {
       this.cantidad = cantidad;
     }
}
