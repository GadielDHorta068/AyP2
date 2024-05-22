import net.datastructures.*;
import tp2e7.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Empleado> empleados = new UnsortedTableMap<>();
        Empleado a = new Empleado();
        a.setNombre("Micky vainilla");
        a.setDocumento(12345);
        empleados.put(a.getDocumento(),a);

        Empleado b = new Empleado();
        b.setNombre("Violencia Rivas");
        b.setDocumento(67890);
        empleados.put(b.getDocumento(),b);

        Empleado c = new Empleado();
        c.setNombre("Peter Capusotto");
        c.setDocumento(142536);
        empleados.put(c.getDocumento(),c);

        Empleado removed = empleados.remove(67890);
        System.out.println("Removed: " + removed);

        System.out.println("Keys: " + empleados.keySet());

        System.out.println("Values: " + empleados.values());

        System.out.println("Entries: ");
        for (Entry<Integer, Empleado> entry : empleados.entrySet())
            System.out.println(entry.getKey() + " => " + entry.getValue().getNombre());

        empleados = new ChainHashMap<>();
        empleados.put(a.getDocumento(),a);
        empleados.put(b.getDocumento(),b);
        empleados.put(c.getDocumento(),c);

        System.out.println("Entries: ");
        for (Entry<Integer, Empleado> entry : empleados.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue().getNombre());
        }

        empleados = new ProbeHashMap<>();
        empleados.put(a.getDocumento(),a);
        empleados.put(b.getDocumento(),b);
        empleados.put(c.getDocumento(),c);

        System.out.println("Entries: ");
        for (Entry<Integer, Empleado> entry : empleados.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue().getNombre());
        }
    }
}