package ejercicio11;

public class TestCrearEmpleados {
    // Creación de un supervisor
    Empleado supervisor = new Empleado(101, "Supervisor", 40, 25.0, null);

    // Creación de un empleado
    Empleado empleado = new Empleado(102, "Empleado", 35, 20.0, supervisor);
}
