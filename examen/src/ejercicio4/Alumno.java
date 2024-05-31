package ejercicio4;

public class Alumno {
    private int legajo;
    private String nombre;

    Alumno(int l, String n) {
        legajo = l;
        nombre = n;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarMateria(Materia materia) {

    }
}

