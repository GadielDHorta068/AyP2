import datastructures.LinkedPositionalList;
import datastructures.PositionalList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class TestLinkedPositionalList {
    private PositionalList<String> pl = new LinkedPositionalList<String>();

    @Before
    public void setUp() throws Exception {
        pl.addLast("Ana");
        pl.addLast("Juan");
        pl.addLast("Pedro");
        pl.addLast("Sandra");
        pl.addLast("Omar");
        pl.addLast("Pedro");
        pl.addLast("Andrea");
    }

    @Test
    public void testSubList1() {
        PositionalList<String> l = new LinkedPositionalList<String>();
        l.addLast("Sandra");
        l.addLast("Omar");
        l.addLast("Andrea");
        assertIterableEquals(pl.subList("Pedro", true), l);
    }

    @Test
    public void testSubList2() {
        PositionalList<String> l = new LinkedPositionalList<String>();
        l.addLast("Ana");
        l.addLast("Juan");
        assertIterableEquals(pl.subList("Pedro", false), l);
    }

    @Test
    public void testSubList3() {
        assertTrue(pl.subList("Daniela", false).isEmpty());
        assertTrue(pl.subList("Andrea", true).isEmpty());
        assertTrue(pl.subList("Ana", false).isEmpty());
    }

    @Test
    public void test_sublist_elements_after_specified_element_right_true() {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();
        list.addLast("Ana");
        list.addLast("Juan");
        list.addLast("Pedro");
        list.addLast("Sandra");
        list.addLast("Omar");
        list.addLast("Andrea");

        LinkedPositionalList<String> sublist = list.subList("Pedro", true);
        assertEquals("(Sandra, Omar, Andrea)", sublist.toString());
    }

    @Test
    public void test_sublist_empty_when_element_not_found() {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();
        list.addLast("Ana");
        list.addLast("Juan");
        list.addLast("Pedro");

        LinkedPositionalList<String> sublist = list.subList("Daniela", true);
        assertTrue(sublist.isEmpty());
    }

}
