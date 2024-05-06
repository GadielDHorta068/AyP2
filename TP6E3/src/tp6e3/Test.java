package tp6e3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Empleado> listaEmpleados = new Deque();

		// Creo algunos empleados
		Empleado empleado1 = new Empleado();
		empleado1.setNombre("Juan");
		empleado1.setDocumento(12345);
		listaEmpleados.addFirst(empleado1);

		Empleado empleado2 = new Empleado();
		empleado2.setNombre("María");
		empleado2.setDocumento(67890);
		listaEmpleados.addLast(empleado2);

		// Metodos de la interface List
		System.out.println("Tamano de la lista " + listaEmpleados.size());
		System.out.println("Lista vacia?" + listaEmpleados.isEmpty());
		System.out.println("Elemento superior " + listaEmpleados.peekFirst());	
	} 

}
