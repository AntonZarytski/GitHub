package lesson4LinkedSets.homework;

import lesson4LinkedSets.classwork.Node;

public class LinkedList {
    private Node first;
    public Node last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void pushFirst(String name, int age) {
        if (size < 1) {
            Node newNode = new Node(name, age);
            this.first = newNode;
            this.last = newNode;
            size++;
        } else {
            Node second = first;
            Node newNode = new Node(name, age);
            this.first = newNode;
            newNode.next = second;
            newNode.previous = null;
            second.previous = newNode;
            size++;
        }
    }
    public void pushLast(String name, int age){
        if (size < 1) {
            Node newNode = new Node(name, age);
            this.first = newNode;
            this.last = newNode;
            size++;
        } else {
            Node penult = last;
            Node newNode = new Node(name, age);
            this.last = newNode;
            newNode.next = null;
            newNode.previous = penult;
            penult.next = newNode;
            size++;
        }
    }
    public boolean pushAfter(String nameAfter, String addingName, int age){
        Node previous = find(nameAfter);
        if (previous == null)
            return false;
        Node current = new Node(addingName, age);
        current.next = previous.next;
        previous.next = current;
        size++;
        return true;
    }
    public boolean pushBefore(String nameBefore, String addingName, int age){
        Node next = find(nameBefore);
        if (next == null)
            return false;
        Node current = new Node(addingName, age);
        current.previous = next.previous;
        next.previous = current;
        size++;
        return true;
    }

    public Node popFirst() {
        if (isEmpty()) return null;
        Node current = first;
        first = current.next;
        first.previous = null;
        size--;
        return current;
    }
    public Node popLast(){
        if (isEmpty())return null;
        Node current = last;
        last = current.previous;
        last.next = null;
        size--;
        return current;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder("{ ");
        while (current != null) {
            sb.append(current.toString());
            current = current.next;
            sb.append((current == null) ? " ]" : ",\n");
        }
        return sb.toString();
    }

    public Node find(String name) {
        Node current = first;
        while (!current.name.equals(name)) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public Node delete(String name) {
        Node deleting = find(name);
        if (deleting==null)
            return null;
        Node previous = deleting.previous;
        Node next = deleting.next;
        if (deleting==first){
            next.previous=null;
            first = next;
            return deleting;
        }
        if (deleting==last){
            previous.next=null;
            last = previous;
            return deleting;
        }
        previous.next=next;
        next.previous=previous;
        return deleting;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }
    public Iterator getIterator(){
        return new Iterator(this);
    }

    public int getSize() {
        return size;
    }
}
