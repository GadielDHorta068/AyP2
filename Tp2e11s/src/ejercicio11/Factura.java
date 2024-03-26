package ejercicio11;

public class Factura implements PorPagar {

	private String proveedor;
	private int numero;
	private String fecha;
	
	private Item[] articulos;
	private int numItems;
    
    //Creo el constructor para una factura completa
    public Factura(String proveedor, int numero, String fecha) {
        articulos = new Item[10];
        numItems = 0;
        
        this.proveedor = proveedor;
        this.numero = numero;
        this.fecha = fecha;
    }
	
	public void agregarItem(String descripcion, int cantidad, double precioUnitario) {
		articulos[numItems] = new Item(descripcion, cantidad, precioUnitario);
		numItems++;
	}
	
	public double porPagar() {
		double total = 0;
		for (int i=0; i< numItems; i++) {
			Item item = articulos[i];
			total += item.cantidad * articulos[i].precioUnitario;
		}
		return total;
	}
	
	@Override
	public String toString() {
		String detalle = "";
        for (int i=0; i< numItems; i++) {
        	
        	Item item = articulos[i];
        	detalle += "\n" + "Descripcion"+  " \n "+  item.descripcion
        			+ "		Canitdad" + item.cantidad
        			+ "		Precio Unitario" + item.precioUnitario
        			+ "		Total $" + item.cantidad * articulos[i].precioUnitario
        			+ "\n";
        }
		
		return " \n "+"Factura proveedor: " + proveedor + ", numero: " + numero + ", fecha: " + fecha + ", cantArticulos: "
				+ numItems + ", articulos: "+ " \n "+ detalle + " \n " ;
	}
	
	
	private class Item {
		private String descripcion;
		private int cantidad;
		private double precioUnitario;
		
		public Item(String descripcion, int cantidad, double precioUnitario) {
			this.descripcion = descripcion;
			this.cantidad = cantidad;
			this.precioUnitario = precioUnitario;
		}
		
		@Override
		public String toString() {
			return "Item descripcion:" + descripcion + ", cantidad:" + cantidad + ", precioUnitario:" + precioUnitario;
		}
	}
}



