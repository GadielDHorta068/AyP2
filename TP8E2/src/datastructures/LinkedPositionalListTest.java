package datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedPositionalListTest {
    @Test
    public void test_correctly_updates_size_after_removal() {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E");
        list.removeAll(1, 4);
        assertEquals(2, list.size());
    }

    @Test
    public void test_maintains_order_after_removal() {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E");
        list.removeAll(1, 4);
        assertEquals("(A, E)", list.toString());
    }

    @Test
    public void test_removes_elements_within_range() {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E");
        list.removeAll(1, 3);
        assertEquals("(A, D, E)", list.toString());
    }
}