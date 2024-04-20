package tp2e10;
import singlyStack.*;

public class Test<E> {

    public static void main(String[] args) {
    	SinglyLinkedStack<Empleado> linkedListStack = new SinglyLinkedStack<Empleado>();
    	
    	// Crear instancia de EmpleadoAsalariado
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado();
        empleadoAsalariado.setNombre("Juan");
        empleadoAsalariado.setDocumento(123456);
        empleadoAsalariado.setSalario(2000);

        linkedListStack.push(empleadoAsalariado);
        
        // Crear instancia de EmpleadoPorHora
        EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora();
        empleadoPorHora.setNombre("María");
        empleadoPorHora.setDocumento(789012);
        empleadoPorHora.setHorasTrabajadas(40);
        empleadoPorHora.setValorHora(15);

        linkedListStack.push(empleadoPorHora);

        // Crear instancia de EmpleadoPorComision
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision();
        empleadoPorComision.setNombre("Carlos");
        empleadoPorComision.setDocumento(456789);
        empleadoPorComision.setPorcentaje(10);
        empleadoPorComision.setVentas(5000);

        linkedListStack.push(empleadoPorComision);
        
        // Crear instancia de EmpleadoBaseMasComision
        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision(1000);
        empleadoBaseMasComision.setNombre("Ana");
        empleadoBaseMasComision.setDocumento(987654);
        empleadoBaseMasComision.setPorcentaje(15);
        empleadoBaseMasComision.setVentas(8000);

        linkedListStack.push(empleadoBaseMasComision);
        float sueldosTotal = 0;
        for (int i = 0; i< linkedListStack.size(); i++) {
        	sueldosTotal += linkedListStack.pop().getSalario();
        }
        System.out.println(sueldosTotal);
       }

}
