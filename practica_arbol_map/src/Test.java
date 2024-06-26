import datastructures.*;


public class Test {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        @Test
        public void test_path_from_root_to_leaf() {
            LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
            Position<Integer> root = tree.addRoot(1);
            Position<Integer> left = tree.addLeft(root, 2);
            Position<Integer> right = tree.addRight(root, 3);
            Position<Integer> leaf = tree.addLeft(left, 4);
            List<Position<Integer>> path = tree.path(root, leaf);
            assertEquals(3, path.size());
            assertEquals(root, path.get(0));
            assertEquals(left, path.get(1));
            assertEquals(leaf, path.get(2));
        }

        @Test
        public void test_path_between_sibling_nodes() {
            LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
            Position<Integer> root = tree.addRoot(1);
            Position<Integer> left = tree.addLeft(root, 2);
            Position<Integer> right = tree.addRight(root, 3);
            List<Position<Integer>> path = tree.path(left, right);
            assertEquals(3, path.size());
            assertEquals(left, path.get(0));
            assertEquals(root, path.get(1));
            assertEquals(right, path.get(2));
        }

        @Test
        public void test_path_between_nodes_with_common_ancestor() {
            LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
            Position<Integer> root = tree.addRoot(1);
            Position<Integer> left = tree.addLeft(root, 2);
            Position<Integer> right = tree.addRight(root, 3);
            Position<Integer> leftLeft = tree.addLeft(left, 4);
            Position<Integer> rightRight = tree.addRight(right, 5);
            List<Position<Integer>> path = tree.path(leftLeft, rightRight);
            assertEquals(5, path.size());
            assertEquals(leftLeft, path.get(0));
            assertEquals(left, path.get(1));
            assertEquals(root, path.get(2));
            assertEquals(right, path.get(3));
            assertEquals(rightRight, path.get(4));
        }

        @Test
        public void test_path_from_node_to_itself() {
            LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
            Position<Integer> root = tree.addRoot(1);
            List<Position<Integer>> path = tree.path(root, root);
            assertEquals(1, path.size());
            assertEquals(root, path.get(0));
        }
    }

    /*
     * Retorna una lista con la expresi�n postfija de un �rbol de expresiones
     * Si el operando es una variable busca su valor en el Map v
     * Si la variable no existe lanza la excepci�n: ArithmeticException indicando
     * el  nombre de la variable que no existe.
     */
    public static List<String> postfixExpression(LinkedBinaryTree<String> t,
                                                 Map<String, Double> v) {

        return null;
    }
}
