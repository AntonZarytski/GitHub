package lesson3StackAndQueue.homework;

public class Main {
    public static void main(String[] args) {
        Deqeue deqeue = new Deqeue(10);
        deqeue.pushFront(5);
        deqeue.pushFront(9);
        deqeue.pushBack(70);
        deqeue.pushBack(10);
        deqeue.print();
        deqeue.popBack();
        deqeue.popBack();
        deqeue.popBack();
        deqeue.print();
        deqeue.popFront();
        deqeue.popFront();
        deqeue.print();

        String s = "Создать программу, которая переворачивает вводимые строки";
        StringBuilder r = ReverceString.reverce(s);
        System.out.println(r.toString());

    }
}
