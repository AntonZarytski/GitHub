package lesson3StackAndQueue.homework;

public class PriorityQueue {
    private int maxSize;
    private int [] queueArray;
    private int items;

    public PriorityQueue (int i){
        maxSize = i;
        queueArray = new int[maxSize];
        items = 0;
    }
    public void insert ( int item ){
        int i;
        if (items==0)
            queueArray [items++] = item;
        else{
            for ( i = items-1 ; i >= 0 ; i--){
                if ( item > queueArray[i])
                    queueArray [i+1] = queueArray [i];
                else
                    break;
            }
            queueArray[i+1] = item;
            items++;
        }
    }
    public int remove (){
        return queueArray[--items];
    }
    public long peek (){
        return queueArray[items-1];
    }
    public boolean isEmpty (){
        return (items==0);
    }
    public boolean isFull (){
        return (items==maxSize);
    }
}
