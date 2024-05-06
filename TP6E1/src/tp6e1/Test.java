package tp6e1;

	
import java.util.List;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Empleado> listaEmpleados = new ArrayList<>();
		
		//Creo algunos empleados
		Empleado empleado1 = new Empleado();
        empleado1.setNombre("Juan");
        empleado1.setDocumento(12345);
        listaEmpleados.add(empleado1);

        Empleado empleado2 = new Empleado();
        empleado2.setNombre("María");
        empleado2.setDocumento(67890);
        listaEmpleados.add(empleado2);
        
        
        System.out.println("Lista de empleados:");
        for (Empleado empleado : listaEmpleados) {
            System.out.println("Nombre: " + empleado.getNombre() + ", Documento: " + empleado.getDocumento());
        }
        
        //Metodos de la interface List
        System.out.println("Tamano de la lista " + listaEmpleados.size());
        System.out.println("Lista vacia?" + listaEmpleados.isEmpty());
        System.out.println("Esta maria?" + listaEmpleados.contains(empleado2));
        //Si esta maria la borro
        if (listaEmpleados.contains(empleado2)) {
        	listaEmpleados.remove(empleado2);
        }
        for (Empleado empleado : listaEmpleados) {
            System.out.println("Nombre: " + empleado.getNombre() + ", Documento: " + empleado.getDocumento());
        }
	}

}
