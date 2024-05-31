import datastructures.AbstractBinaryTree;
import datastructures.LinkedBinaryTree;
import datastructures.Position;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAbstractBinaryTree {
    private LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
    private Position<String> p, q, r, s, t;

    @Before
    public void setUp() throws Exception {

        p = tree.addRoot("F");
        q = tree.addLeft(p, "B");
        tree.addLeft(q, "A");
        r = tree.addRight(q, "D");
        tree.addLeft(r, "C");
        s = tree.addRight(p, "G");
        t = tree.addRight(s, "I");
        tree.addRight(r, "E");
        tree.addLeft(t, "H");
    }

    @Test
    public void testIsLeft() {
        assertTrue(tree.isLeft(r, t));
        assertTrue(tree.isLeft(p, s));
        assertTrue(tree.isLeft(q, s));
    }

    @Test
    public void testNotIsLeft() {
        assertFalse(tree.isLeft(null, null));
        assertFalse(tree.isLeft(p, null));
        assertFalse(tree.isLeft(null, r));
        assertFalse(tree.isLeft(p, p));
        assertFalse(tree.isLeft(t, q));
        assertFalse(tree.isLeft(p, r));
    }
}
