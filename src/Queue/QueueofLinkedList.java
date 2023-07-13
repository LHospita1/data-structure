package Queue;

public class QueueofLinkedList implements Queue {
    private Node first;
    private Node last;
    private int N;

    @Override
    public void enqueue(String s) {
        Node oldlast = last;
        last = new Node();
        last.data = s;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    @Override
    public String dequeue() {
        String data = first.data;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int getSize() {
        return N;
    }

    private class Node {
        String data;
        Node next;
    }
}
