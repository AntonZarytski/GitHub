package lesson3StackAndQueue.homework.answer;

import lesson3StackAndQueue.classwork.Queue;

public class DeqeueAnswer extends Queue {

    public DeqeueAnswer(int size) {
        super(size);
    }

    public void enqueueTail(int i) {
        super.insert(i);
    }

    public void enqueueHead(int i) {
        if (isFull())
            throw new RuntimeException("Queue is full");

        if (getHead() == 0)
            setTail(getSize());

        getQueue()[getHead() - 1] = i;
        setHead(getHead() - 1);
        setItems(getItems() + 1);
    }

    public int dequeueHead() {
        return super.remove();
    }

    public int dequeueTail() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");

        int temp = getQueue()[getTail()];
        setTail(getTail() + 1);
        if (getTail() == getSize())
            setTail(0);

        setItems(getItems() - 1);
        return temp;
    }


}

