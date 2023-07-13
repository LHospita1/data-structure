package Queue;

import Stack.StackofLinkedList;

public class QueueofStack implements Queue {
    StackofLinkedList data = new StackofLinkedList();
    StackofLinkedList util = new StackofLinkedList();


    @Override
    public void enqueue(String s) {
        data.push(s);
    }

    @Override
    public String dequeue() {
        String s = null;
        if (util.isEmpty()) {
            while (!data.isEmpty()) {
                util.push(data.pop());
            }
            s = (String) util.pop();
        } else {
            s = (String) util.pop();
        }
        return s;
    }

    @Override
    public boolean isEmpty() {
        return !(util.isEmpty() && data.isEmpty());
    }

    @Override
    public int getSize() {
        return util.getSize() + data.getSize();
    }
}
