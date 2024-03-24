package tp2e11;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
    	 // Crear una lista de PorPagar que incluye empleados y facturas
        ArrayList<PorPagar> porPagarList = new ArrayList<>();

        // Agregar empleados a la lista
        porPagarList.add(new Empleado("Juan", 2000));
        porPagarList.add(new Empleado("María", 2500));

        // Agregar facturas a la lista
        porPagarList.add(new Factura(1500));
        porPagarList.add(new Factura(2000));

        // Calcular los importes a pagar
        double totalAPagar = 0;
        for (PorPagar porPagar : porPagarList) {
            totalAPagar += porPagar.obtenerPago();
        }

        // Imprimir el total a pagar
        System.out.println("Total a pagar: " + totalAPagar);
    }

}
