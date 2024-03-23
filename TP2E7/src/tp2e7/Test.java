package tp2e7;

public class Test {

    public static void main(String[] args) {
        // Crear instancia de EmpleadoAsalariado
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado();
        empleadoAsalariado.setNombre("Juan");
        empleadoAsalariado.setDocumento(123456);
        empleadoAsalariado.setSalario(2000);

        // Mostrar información de EmpleadoAsalariado
        System.out.println("Empleado Asalariado:");
        System.out.println("Nombre: " + empleadoAsalariado.getNombre());
        System.out.println("Documento: " + empleadoAsalariado.getDocumento());
        System.out.println("Salario Mensual: " + empleadoAsalariado.getSalario());

        // Crear instancia de EmpleadoPorHora
        EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora();
        empleadoPorHora.setNombre("María");
        empleadoPorHora.setDocumento(789012);
        empleadoPorHora.setHorasTrabajadas(40);
        empleadoPorHora.setValorHora(15);

        // Mostrar información de EmpleadoPorHora
        System.out.println("\nEmpleado Por Hora:");
        System.out.println("Nombre: " + empleadoPorHora.getNombre());
        System.out.println("Documento: " + empleadoPorHora.getDocumento());
        System.out.println("Horas Trabajadas: " + empleadoPorHora.getHoras());
        System.out.println("Valor Hora: " + empleadoPorHora.getValor());

        // Crear instancia de EmpleadoPorComision
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision();
        empleadoPorComision.setNombre("Carlos");
        empleadoPorComision.setDocumento(456789);
        empleadoPorComision.setPorcentaje(10);
        empleadoPorComision.setVentas(5000);

        // Mostrar información de EmpleadoPorComision
        System.out.println("\nEmpleado Por Comisión:");
        System.out.println("Nombre: " + empleadoPorComision.getNombre());
        System.out.println("Documento: " + empleadoPorComision.getDocumento());
        System.out.println("Porcentaje de Comisión: " + empleadoPorComision.getPorcentajes() + "%");
        System.out.println("Ventas Brutas: " + empleadoPorComision.getVentas());

        // Crear instancia de EmpleadoBaseMasComision
        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision(1000);
        empleadoBaseMasComision.setNombre("Ana");
        empleadoBaseMasComision.setDocumento(987654);
        empleadoBaseMasComision.setPorcentaje(15);
        empleadoBaseMasComision.setVentas(8000);

        // Mostrar información de EmpleadoBaseMasComision
        System.out.println("\nEmpleado Base más Comisión:");
        System.out.println("Nombre: " + empleadoBaseMasComision.getNombre());
        System.out.println("Documento: " + empleadoBaseMasComision.getDocumento());
        System.out.println("Porcentaje de Comisión: " + empleadoBaseMasComision.getPorcentajes() + "%");
        System.out.println("Ventas Brutas: " + empleadoBaseMasComision.getVentas());
        System.out.println("Salario Base: " + empleadoBaseMasComision.getSalarioBase());
    }

}
