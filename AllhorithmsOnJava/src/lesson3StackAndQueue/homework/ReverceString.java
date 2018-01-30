package lesson3StackAndQueue.homework;

public class ReverceString {

    public static StringBuilder reverce(String string){
        char[] arr = string.toCharArray();
        Stack stack = new Stack(arr.length);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i <arr.length;  i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i <arr.length ; i++) {
            answer.append(stack.pop());
        }
        return answer;
    }

}
class Stack {
    private char[] stack;
    private int size;
    private int head;

    public Stack(int size) {
        if(size<=1) throw new RuntimeException("Too small for stack " + size);
        this.size = size;
        this.stack = new char[size];
        this.head = -1;
    }
    public boolean isEmpty(){
        return this.head == -1;
    }
    public boolean isFull(){
        return  this.size -1 == head;
    }
    public void push(char i){
        if(isFull()) {
            this.size *= 2;
            char[] newStack = new char[this.size];
            System.arraycopy(this.stack, 0, newStack, 0, this.stack.length);
            this.stack=newStack;
        }
        this.stack[++this.head] = i;
    }


    public char pop(){
        if(isEmpty())throw new RuntimeException("Stack is empty");
        return this.stack[this.head--];
    }
    public char peek(){
        if(isEmpty())throw new RuntimeException("Stack is empty");
        return this.stack[this.head];
    }
}


