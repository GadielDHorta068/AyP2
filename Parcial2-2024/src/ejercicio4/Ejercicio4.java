package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Ejercicio4 {
    public static void main(String[] args) {
        TreeMap<Materia, List<Alumno>> materias = new TreeMap<>();
        Alumno alumno1 = new Alumno(12345678, "Juan");
        Alumno alumno2 = new Alumno(87654321, "María");
        Alumno alumno3 = new Alumno(12348765, "Pedro");

        Materia algebra = new Materia("Algebra", 1);
        Materia AyP2 = new Materia("Análisis y Programación 2", 2);

        asignarAlumno(materias, algebra, alumno1);
        asignarAlumno(materias, AyP2, alumno2);

        mostrarAlumnos(materias);
    }

    public static void asignarAlumno(TreeMap<Materia, List<Alumno>> materias, Materia materia, Alumno alumno) {
        if (materias.containsKey(materia)) {
            materias.get(materia).add(alumno);
        } else {
            List<Alumno> alumnos = new ArrayList<>();
            alumnos.add(alumno);
            materias.put(materia, alumnos);
        }
    }

    public static void mostrarAlumnos(TreeMap<Materia, List<Alumno>> materias) {
        System.out.println(materias.keySet());
    }
}



