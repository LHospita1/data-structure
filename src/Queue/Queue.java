package Queue;

public interface Queue {
    void enqueue(String s);

    String dequeue();

    boolean isEmpty();

    int getSize();
}
