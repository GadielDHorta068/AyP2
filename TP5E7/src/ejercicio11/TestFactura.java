package ejercicio11;

public class TestFactura {
    public static void main(String[] args) {
        // Creación de una instancia de Factura
        Factura factura = new Factura("Proveedor1", 1234, "2024-03-26");

        // Agregar algunos artículos a la factura
        factura.agregarItem("Producto 1", 2, 10.50);
        factura.agregarItem("Producto 2", 1, 20.75);
        factura.agregarItem("Producto 3", 3, 5.99);

        // Mostrar la información de la factura
        System.out.println(factura);
        System.exit(0);
        
    }
}
