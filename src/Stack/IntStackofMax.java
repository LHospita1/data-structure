package Stack;

public class IntStackofMax {
    private Node first;
    private int max = 0;
    private boolean c = false;

    public IntStackofMax() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(int i) {
        if (i > max) {
            max = i;
            c = true;
        }
        Node oldfirst = first;
        Node Newfirst = new Node();
        Newfirst.next = oldfirst;
        Newfirst.data = i;
        first = Newfirst;
    }


    public int pop() {
        int s = first.data;
        first = first.next;
        if (s == max) c = false;
        return s;
    }


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

    public int returnmax() {
        if (c) {
            return max;
        } else if (first == null) {
            return 0;
        } else if (first.next != null) {
            Node check = first;
            max = 0;
            do {
                if (check.data > max) {
                    max = check.data;
                }
                check = check.next;
            } while (check.next != null);
            c = true;
            return max;
        } else return first.data;
    }

    private class Node {
        int data;
        Node next;
    }
}

