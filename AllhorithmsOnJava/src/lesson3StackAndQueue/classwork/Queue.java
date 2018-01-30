package lesson3StackAndQueue.classwork;

public class Queue {
    private int[] queue;
    private int size;
    private int head;
    private int tail;
    private int items;

    public Queue(int size) {
        queue = new int[size];
        this.size = size;
        this.head = 0;
        this.tail = -1;
        this.items =0;
    }
    public boolean isEmpty(){
        return items == 0;
    }

    public boolean isFull(){
        return items == size;
    }

    public int getSize(){
        return items;
    }

    public void insert(int i){
        if (isFull())
            throw new RuntimeException("Queue is full");

        if (tail == size - 1)
            tail = -1;

        queue[++tail] = i;
        items++;
    }

    public int remove(){
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        int temp = queue[head++];
        if(head == size)
            head = 0;
    return head;
    }
    public int peek(){
        return queue[head];
    }

    public int[] getQueue() {
        return queue;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public void setQueue(int[] queue) {
        this.queue = queue;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getItems() {
        return items;
    }
}

