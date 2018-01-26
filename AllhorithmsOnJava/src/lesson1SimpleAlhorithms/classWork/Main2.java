package lesson1SimpleAlhorithms.classWork;

public class Main2 {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(15);
        for (int i = 0; i <10000 ; i++) {
            myArray.insert((int)Math.round(Math.random()*10000));
        }
        myArray.display();
        myArray.sortBubble();
        System.out.println();
        //  myArray.sortInsert();
        // myArray.sortSelect();
        myArray.display();
        boolean a = myArray.hasValue(845);
        System.out.println();
        System.out.println(a);
    }
}
