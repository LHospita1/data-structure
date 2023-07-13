package Stack;

public class StackofArray<Item> implements Stack {
    protected Item[] data;
    protected int size = 16;
    protected int location = 0;

    public StackofArray() {
        data = (Item[]) new Object[size];
    }

    public void push(Object s) {
        if (location == size) {
            this.resizing(size * 2);
            size = size * 2;
        }
        data[location] = (Item) s;
        location++;
    }

    @Override
    public Item pop() {
        if (location < size / 4 && location > 0) {
            this.resizing(size / 2);
            size = size / 2;
        }
        Item s = data[location - 1];
        data[location - 1] = null;
        location--;
        return s;
    }

    @Override
    public int getSize() {
        return location;
    }

    @Override
    public boolean isEmpty() {
        return data == null;
    }


    public void resizing(int newsize) {
        Item[] olddata = this.data;
        this.data = (Item[]) new Object[newsize];
        System.arraycopy(olddata, 0, data, 0, location);
    }
}
