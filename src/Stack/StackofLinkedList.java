package Stack;

public class StackofLinkedList<item> implements Stack {
    Node first;

    public StackofLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Object item) {
        Node oldfirst = first;
        Node Newfirst = new Node();
        Newfirst.next = oldfirst;
        Newfirst.data = (item) item;
        first = Newfirst;
    }

    @Override
    public item pop() {
        item s = first.data;
        first = first.next;
        return s;
    }

    @Override
    public int getSize() {
        if (first == null) return 0;
        Node check = first;
        int size = 1;
        while (check.next != null) {
            check = check.next;
            size++;
        }
        return size;
    }

    private class Node {
        item data;
        Node next;
    }
}

