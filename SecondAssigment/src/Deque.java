//import java.util.Iterator;
import java.lang.IllegalArgumentException;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class Deque<Item> implements Iterable<Item>  {
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    private Node first;
    private Node last;
    private int n;

    public Deque() {
        first = null;
        last = null;
        n = 0;
    }                           // construct an empty deque
    public boolean isEmpty()  {
        return n == 0;
    }               // is the deque empty?
    public int size() {
        return n;
    }                      // return the number of items on the deque

    public void addFirst(Item item)  {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            first = new Node();
            first.item = item;
            last = first;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        n++;
    }         // add the item to the front
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            first = new Node();
            first.item = item;
            last = first;
        } else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            oldLast.next = last;
            last.prev = oldLast;
        }


        n++;
    }           // add the item to the end
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item item = first.item;
        if (n == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        n--;
        return item;
    }               // remove and return the item from the front
    public Item removeLast()   {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item item = last.item;
        if (n == 1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }

        n--;
        return item;
    }               // remove and return the item from the end
    public Iterator<Item> iterator()  {
        return new DequeIterator();
    };        // return an iterator over items in order from front to end


    private class DequeIterator implements Iterator<Item> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;

            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}