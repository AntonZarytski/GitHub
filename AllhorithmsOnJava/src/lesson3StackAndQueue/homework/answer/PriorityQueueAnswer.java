package lesson3StackAndQueue.homework.answer;

import lesson3StackAndQueue.classwork.Queue;

public class PriorityQueueAnswer extends Queue {

    public PriorityQueueAnswer(int size) {
        super(size);
    }

    @Override
    public int remove() {
        int temp = getQueue()[0];
        System.arraycopy(getQueue(), 1, getQueue(), 0, getSize());
        setSize(getSize() - 1);
        return temp;

    }

    @Override
    public void insert(int newVal) {
        if (isFull())
            throw new RuntimeException("Queue is full");

        int i;
        for (i = 0; i < getSize(); i++)
            if (getQueue()[i] > newVal) break;

        System.arraycopy(getQueue(), i, getQueue(), i + 1, getSize() - i);
        getQueue()[i] = newVal;
        setSize(getSize() + 1);

    }
}

