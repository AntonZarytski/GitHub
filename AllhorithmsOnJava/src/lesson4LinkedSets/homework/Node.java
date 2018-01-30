package lesson4LinkedSets.classwork;

public class Node{
    public String name;
    public int age;
    public Node next;
    public Node previous;

    public Node (String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return "(name " + this.name + " age " + this.age +")";
    }

    }
