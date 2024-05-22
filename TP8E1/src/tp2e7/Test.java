package tp2e7;

import java.util.ArrayList;

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
    
    
        //Ejercicio 10 Cargar una lista de empleados utilizando las clases creadas en el ejercicio 7 y 
        //emitir un listado de todos los empleados y sus salarios.
        //Adicionar un 10% de incremento en el listado para los EmpleadoBaseMasComision.
        
        ArrayList<Empleado> empleados = new ArrayList<>();
        System.out.println();
        System.out.println("EJERCICIO10");
        System.out.println();
        empleados.add(empleadoAsalariado);
        empleados.add(empleadoPorComision);
        empleados.add(empleadoBaseMasComision);
        empleados.add(empleadoPorHora);
        
        for (Empleado empleado : empleados) {
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Documento: " + empleado.getDocumento());
            
            // Verificar el tipo de empleado y calcular el salario
            if (empleado instanceof EmpleadoAsalariado) {
                EmpleadoAsalariado emp = (EmpleadoAsalariado) empleado;
                System.out.println("Salario: " + emp.getSalario());
            } else if (empleado instanceof EmpleadoPorComision) {
                EmpleadoPorComision emp = (EmpleadoPorComision) empleado;
                float salario = emp.getPorcentajes() * emp.getVentas() / 100;
                System.out.println("Salario: " + salario);
            } else if (empleado instanceof EmpleadoBaseMasComision) {
                EmpleadoBaseMasComision emp = (EmpleadoBaseMasComision) empleado;
                float salario = emp.getSalarioBase() + (emp.getPorcentajes() * emp.getVentas() / 100);
                // Aplicar un 10% de incremento para los EmpleadoBaseMasComision
                System.out.println("Salario sin aumento: " + salario);
                salario *= 1.1;
                System.out.println("Salario: " + salario);
            } else if (empleado instanceof EmpleadoPorHora) {
                EmpleadoPorHora emp = (EmpleadoPorHora) empleado;
                float salario = emp.getHoras() * emp.getValor();
                System.out.println("Salario: " + salario);
            }
            
            System.out.println();
        }
    }

}
