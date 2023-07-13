import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node front;
    private Node back;
    private int size;

    // construct an empty deque
    public Deque() {
        front = null;
        back = null;
    }

    // unit testing (required)
    public static void main(String[] args) {
//        Deque data = new Deque();
//        StdOut.println(data.isEmpty());
//        for (int i = 0; i < 20; i++) {
//            data.addFirst(i);
//        }
//        for (int i = 1; i < 15; i++) {
//            data.addLast(i);
//        }
//        StdOut.println(data.removeFirst());
//        StdOut.println(data.removeFirst());
//        Iterator iter = data.iterator();
//        try {
//            iter.remove();
//        } catch (UnsupportedOperationException e) {
//            e.printStackTrace();
//        }
//        while (iter.hasNext()) {
//            Object item = iter.next();
//            StdOut.println(item);
//        }
//        StdOut.println(data.size());
//        StdOut.println(data.isEmpty());
    }

    // is the deque empty?
    public boolean isEmpty() {
        return front == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        size++;
        Node newfront = new Node(item);
        if (front == null) {
            front = newfront;
            back = front;
        } else {
            newfront.next = front;
            front.last = newfront;
            front = newfront;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        size++;
        Node newback = new Node(item);
        if (back == null) {
            back = newback;
            front = back;
        } else {
            back.next = newback;
            newback.last = back;
            back = newback;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (this.isEmpty()) throw new java.util.NoSuchElementException();
        size--;
        Item inform = front.data;
        front = front.next;
        return inform;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (this.isEmpty()) throw new java.util.NoSuchElementException();
        size--;
        Item inform = back.data;
        back = back.last;
        return inform;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node check = front;

        public boolean hasNext() {
            return check != null;
        }

        public Item next() {
            if (!this.hasNext()) throw new java.util.NoSuchElementException();
            Item inform = check.data;
            check = check.next;
            return inform;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {
        Node next = null;
        Node last = null;
        Item data;

        public Node(Item dat) {
            this.data = dat;
        }
    }
}
