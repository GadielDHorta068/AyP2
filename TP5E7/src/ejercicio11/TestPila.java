package ejercicio11;

import java.util.Stack;

public class TestPila {
	public static <E> void main(String[] args) {
		Stack<Empleado> stacke = new Stack<>();
		Stack<Factura> stackf = new Stack<>();
		
		Empleado supervisor = new Empleado(101, "Supervisor", 40, 25.0, null);
	    stacke.push(supervisor);
		Empleado empleado = new Empleado(102, "Empleado", 35, 20.0, supervisor);
		stacke.push(empleado);
        
		Factura factura1 = new Factura("Proveedor1", 1234, "2024-03-26");
        stackf.push(factura1);
		factura1.agregarItem("Producto 1", 2, 10.50);
        factura1.agregarItem("Producto 2", 1, 20.75);
        factura1.agregarItem("Producto 3", 3, 5.99);
    	
        
        Factura factura2 = new Factura("Proveedor2", 4321, "2024-03-26");
        stackf.push(factura2);
        factura2.agregarItem("Producto 1", 6, 1.50);
        factura2.agregarItem("Producto 2", 5, 2.75);
        factura2.agregarItem("Producto 3", 4, 5.80);
        
        PorPagar[] pagos = new PorPagar[4];
        pagos[0] = factura1;
        pagos[1] = factura2;
        pagos[2] = supervisor;
        pagos[3] = empleado;
        
        double pagar = 0;
        for (int i= 0; i< stacke.size(); i++) {
            pagar += stacke.pop().porPagar() ;
        }
        
        for (int i= 0; i< stackf.size(); i++) {
            pagar += stackf.pop().porPagar() ;
        }
        System.out.println("Importe a pagar: $" + pagar);
	
	}
}
