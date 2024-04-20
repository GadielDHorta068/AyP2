package fibonacci;

public class Recursivo2 {
    public static int fibonacci(int n, int prev, int actual) {
        if (n == 0) {
            return prev;
        }
        if (n == 1) {
            return actual;
        }
        return fibonacci(n - 1, actual, prev + actual);
	}
}
