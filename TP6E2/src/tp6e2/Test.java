package tp6e2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Empleado> listaEmpleados = new Stack();

		// Creo algunos empleados
		Empleado empleado1 = new Empleado();
		empleado1.setNombre("Juan");
		empleado1.setDocumento(12345);
		listaEmpleados.push(empleado1);

		Empleado empleado2 = new Empleado();
		empleado2.setNombre("María");
		empleado2.setDocumento(67890);
		listaEmpleados.push(empleado2);

		// Metodos de la interface List
		System.out.println("Tamano de la lista " + listaEmpleados.size());
		System.out.println("Lista vacia?" + listaEmpleados.isEmpty());
		System.out.println("Elemento superior " + listaEmpleados.peek());	
	} 

}
