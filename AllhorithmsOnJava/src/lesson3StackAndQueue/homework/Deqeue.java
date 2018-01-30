package lesson3StackAndQueue.homework;

public class Deqeue {
    private int[] dequeue;
    private int size;
    private int head;
    private int tail;
    public Deqeue(int size) {
        this.dequeue = new int[size];
        this.size = size;
        this.head = size;
        this.tail = 0;
    }

    public void pushBack(int i){
        if (isFull())throw new RuntimeException("Dequeue is full");
        dequeue[++tail] = i;
    }

    public void pushFront(int i){
        if (isFull())throw new RuntimeException("Dequeue is full");
       dequeue[--head] = i;
    }

    public int popFront(){
        if(isEmpty())throw new RuntimeException("Dequeue is empty");
        int temp = dequeue[size-1];
        for (int i = size-1; i >0 ; i--) {
            dequeue[i]=dequeue[i-1];
        }
        head++;
        dequeue[0]=0;
        return temp;
    }
    public int popBack(){
        if(isEmpty())throw new RuntimeException("Dequeue is empty");
        int temp = dequeue[0];
        for (int i = 0; i <size-1 ; i++) {
            dequeue[i]=dequeue[i+1];
        }
        tail--;
        dequeue[size-1]=0;
        return temp;
    }


    public int peekBack(){
        if(isEmpty())throw new RuntimeException("Dequeue is empty");
        return dequeue[0];
    }

    public int peekFront(){
        if(isEmpty())throw new RuntimeException("Dequeue is empty");
        return this.dequeue[size-1];
    }

    public boolean isFull(){
        return(head-tail==0);
    }

    public boolean isEmpty(){
        for (int i = 0; i < dequeue.length ; i++) {
            if (dequeue[i] != 0)
                return false;
        }
        return true;
    }
    public void print(){
        for (int i = 0; i < dequeue.length ; i++) {
            if(dequeue[i]==0)
                continue;
            System.out.print(dequeue[i] + " ");
        }
        System.out.println();
    }
}
