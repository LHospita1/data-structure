package Queue;

public class QueueofArray implements Queue {
    int capacity = 16;
    String[] data = new String[capacity];
    int amount = 0;
    int head = 0;

    @Override
    public void enqueue(String s) {
        if (amount == capacity) this.resize(capacity * 2);
        data[amount++] = s;
    }

    @Override
    public String dequeue() {
        if (amount < capacity / 4) this.resize(capacity / 2);
        String s = data[head];
        data[head++] = null;
        return s;
    }

    @Override
    public boolean isEmpty() {
        return amount == 0 && head == amount;
    }

    @Override
    public int getSize() {
        return amount;
    }

    public void resize(int num) {
        String[] newdata = new String[num];
        int j = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                newdata[j] = data[i];
                j++;
            }
        }
        data = newdata;
        head = 0;
        amount = j;
        capacity = num;
    }
}
