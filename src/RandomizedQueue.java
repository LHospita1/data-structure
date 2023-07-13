import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] data;
    private int size = 16;
    private int location = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        data = (Item[]) new Object[size];
    }

    // unit testing (required)
    public static void main(String[] args) {
//        RandomizedQueue data = new RandomizedQueue();
//        StdOut.println(data.isEmpty());
//        for (int i = 0; i < 20; i++) {
//            data.enqueue(i);
//        }
//        StdOut.println(data.sample());
//        StdOut.println(data.size());
//        Iterator iter = data.iterator();
//        while (iter.hasNext()) {
//            StdOut.print(iter.next() + " ");
//        }
//        StdOut.println();
//        for (int i = 0; i < 20; i++) {
//            StdOut.print(data.dequeue() + " ");
//        }
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return location == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return location;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        } else {
            if (location == size) {
                this.resizing(size * 2);
                size = size * 2;
            }
            data[location++] = item;
        }
    }

    // remove and return a random item
    public Item dequeue() {
        if (location == 0) {
            throw new java.util.NoSuchElementException();
        } else {
            int ram = StdRandom.uniformInt(location);
            Item s = data[ram];
            Item k = data[--location];
            data[ram] = k;
            data[location] = null;
            return s;
        }
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (location == 0) {
            throw new java.util.NoSuchElementException();
        } else {
            int ram = StdRandom.uniformInt(location);
            return data[ram];
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RQIterator();
    }

    private void resizing(int newsize) {
        Item[] olddata = this.data;
        this.data = (Item[]) new Object[newsize];
        System.arraycopy(olddata, 0, data, 0, location);
    }

    private class RQIterator implements Iterator<Item> {
        final int amount = location;
        final int[] order = StdRandom.permutation(amount);
        int s = 0;

        public boolean hasNext() {
            return s != amount;
        }

        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            } else {
                return data[order[s++]];
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
