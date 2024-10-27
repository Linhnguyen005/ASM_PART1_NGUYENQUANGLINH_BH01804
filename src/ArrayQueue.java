class ArrayQueue {
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity) {
        array = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == array.length) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % array.length;
        array[rear] = value;
        size++;
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        front = (front + 1) % array.length;
        size--;
    }

    public void display() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[(front + i) % array.length] + " ");
        }
        System.out.println();
    }
}
