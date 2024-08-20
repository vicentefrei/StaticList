public class StaticList {
    private int[] data;
    private int size;


    public StaticList(int size) {
        this.data = new int[size];
        this.size = 0;
    }


    public void clear() {
        this.size = 0;
    }


    public void add(int data) {
        if (isFull()) {
            throw new IllegalStateException("List is full");
        }
        this.data[size] = data;
        size++;
    }


    public void add(int data, int pos) {
        if (isFull()) {
            throw new IllegalStateException("List is full");
        }
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        for (int i = size; i > pos; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[pos] = data;
        size++;
    }


    public int remove(int pos) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        int removedData = this.data[pos];

        for (int i = pos; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        size--;
        return removedData;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public boolean isFull() {
        return size == data.length;
    }


    public void setData(int data, int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        this.data[pos] = data;
    }


    public int getData(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return this.data[pos];
    }


    public int getSize() {
        return size;
    }


    public int find(int data) {
        for (int i = 0; i < size; i++) {
            if (this.data[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StaticList list = new StaticList(10);


        list.add(5);
        list.add(10);
        list.add(15);

        System.out.println("Element at position 1: " + list.getData(1));
        list.add(20, 1);
        System.out.println("Element at position 1 after insert: " + list.getData(1));

        list.remove(2);
        System.out.println("Size after removal: " + list.getSize());
    }
}
