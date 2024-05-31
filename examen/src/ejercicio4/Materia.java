package ejercicio4;

public class Materia implements Comparable {
    private int codigo;
    private String descripcion;

    public Materia(String descripcion, int codigo) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    @Override
    public int compareTo(Materia materia) {
        return 0;
    }
}
