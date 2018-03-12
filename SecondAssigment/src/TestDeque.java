import  org.junit.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestDeque {
    private Deque<Integer> deq;

    @Before
    public void initDeque() {
        deq = new Deque<>();
    }

    @Test
    public void emptyDequeTest() {
        assertTrue(deq.isEmpty());
    }

    @Test
    public void addFirstTest() {
        deq.addFirst(1);
        deq.addFirst(2);
        deq.addFirst(3);
        assertEquals(deq.size(), 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullExceptionAddFirstTest() {
        deq.addFirst(null);
    }

    @Test
    public void addLastTest() {
        deq.addLast(1);
        deq.addLast(2);
        deq.addLast(3);
        assertEquals(deq.size(), 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullExceptionAddLastTest() {
        deq.addFirst(null);
    }

    @Test
    public void removeFirstTest() {
        deq.addFirst(1);
        deq.addFirst(2);
        deq.addFirst(3);

        int a = deq.removeFirst();
        int b = deq.removeFirst();
        int c = deq.removeFirst();

        assertEquals(a, 3);
        assertEquals(b, 2);
        assertEquals(c, 1);
    }

    @Test(expected = NoSuchElementException.class)
    public void noElementExceptionRemoveFirstTest() {
        deq.removeFirst();
    }

    @Test
    public void removeLastTest() {
        deq.addFirst(1);
        deq.addFirst(2);
        deq.addFirst(3);

        int a = deq.removeLast();
        int b = deq.removeLast();
        int c = deq.removeLast();

        assertEquals(a, 1);
        assertEquals(b, 2);
        assertEquals(c, 3);
    }

    @Test(expected = NoSuchElementException.class)
    public void noElementExceptionRemoveLastTest() {
        deq.removeLast();
    }

    @Test
    public void addLasttRemoveFirstest() {
        deq.addLast(1);
        deq.addLast(2);
        deq.addLast(3);

        int a = deq.removeFirst();
        int b = deq.removeFirst();
        int c = deq.removeFirst();

        assertEquals(a, 1);
        assertEquals(b, 2);
        assertEquals(c, 3);
    }

    @Test
    public void iteratorHasNextTest() {
        Iterator<Integer> it = deq.iterator();
        assertEquals(it.hasNext(), false);
        deq.addFirst(1);
        assertEquals(deq.iterator().hasNext(), true);
    }

    @Test
    public void nextIteratorTest() {
        deq.addLast(1);
        deq.addLast(2);
        deq.addLast(3);
        Iterator<Integer> it = deq.iterator();
        assertEquals((int)it.next(), 1);
        assertEquals((int)it.next(), 2);
        assertEquals((int)it.next(), 3);
    }

    @Test(expected = NoSuchElementException.class)
    public void ExceptionIteratorNextTest() {
        Iterator<Integer> it = deq.iterator();
        it.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void ExceptionIteratorRemoveTest() {
        Iterator<Integer> it = deq.iterator();
        it.remove();
    }
}
