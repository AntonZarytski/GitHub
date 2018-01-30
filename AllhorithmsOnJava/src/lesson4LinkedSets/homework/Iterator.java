package lesson4LinkedSets.homework;

import lesson4LinkedSets.classwork.Node;

public class Iterator {
    private LinkedList list;
    private Node current;
    private static int count;
    private static int size;

    public Iterator(LinkedList list) {
        this.list = list;
        count = 0;
        size = list.getSize();
        this.current = reset();
    }
    //reset() - перемещение в начала списка
    //next() - перемещение к следующему элемента
    // getCurrent()
    // atEnd() - находится ли элемент в конце
    // insertAfter()
    // insertBefore()
    // deleteCurrent()

    public Node reset() {
        count=0;
        size = list.getSize();
        current = list.getFirst();
        return current;
    }
    public Node goToEnd(){
        current = list.getLast();
        return current;
    }

    public boolean hasNext() {
        if (current.next != null && count<=size) {
            if (count==0) {
                count++;
                return true;
            }
            count++;
            current = current.next;
            return true;
        } else return false;
    }
    public boolean hasPrevious(){
        if (current.previous!=null){
            current = current.previous;
            return true;
        }else return false;
    }
    public Node getCurrent(){
        return current;
    }
    public boolean isEnd(){
        if (current.next==null)
            return true;
        else return false;
    }
    public void insertAfter(String nameAfter, String addingName, int age){
        list.pushAfter(nameAfter,addingName, age);
    }
    public void insertBefore(String nameBefore, String addingName ,int age){
        list.pushBefore(nameBefore,addingName, age);
    }
    public Node deleteBefore(String name){
        Node deleting = list.find(name).previous;
        String deletingName = deleting.name;
        list.delete(deletingName);
        return deleting;
    }

}
