package lesson4LinkedSets.classwork;

public class RelatedList {
    public Node first;
    int size;

    public RelatedList() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String name, int age) {
        Node newNode = new Node(name, age);
        newNode.next = first;
        first = newNode;
    }

    public Node pop() {
        if (isEmpty()) return null;
        Node temp = first;
        first = first.next;
        return temp;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder("[ ");
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
        Node current = first;
        Node previous = first;

        while (!current.name.equals(name)) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }
}

