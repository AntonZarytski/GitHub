package lesson4LinkedSets.homework;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i <10 ; i++) {
            linkedList.pushFirst("people" + i, i);
        }
        Iterator iterator = linkedList.getIterator();
       /* while (iterator.hasNext()){
            System.out.println(iterator.getCurrent().toString());
        }
        iterator.reset();*/
        while (iterator.hasNext()) {
            iterator.insertAfter("people5", "kot", 99);
        }
        iterator.reset();
        while (iterator.hasNext()){
            System.out.println(iterator.getCurrent().toString());
        }
    }
}
