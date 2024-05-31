import datastructures.LinkedPositionalList;
import datastructures.PositionalList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        PositionalList<String> pl = new LinkedPositionalList<String>();

        pl.addLast("Ana");
        pl.addLast("Juan");
        pl.addLast("Pedro");
        pl.addLast("Sandra");
        pl.addLast("Omar");
        pl.addLast("Pedro");
        pl.addLast("Andrea");

        pl.subList("Pedro", true);
    }
}