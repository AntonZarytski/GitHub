package SecondTask;

import java.util.ArrayList;

public class Main2ndTask {
    public static void main(String[] args) {
        Integer[] i = {2,4,6,8,10,15,20,25,30};
        String[] s = {"H", "E", "L", "L", "O", "!"};
        TestClass2<Integer> obj1 = new TestClass2 <> ( i );
        TestClass2<String> obj2 = new TestClass2 <> ( s );
        ArrayList<Integer> arrlist1 = new ArrayList <> (  );
        // как реализовать что бы в arrlist1`е в параметрах был <?>, что бы любой массив можно было переложить в него?
        obj1.copyArraytoArrayList ( obj1.getObj (), arrlist1 );
        System.out.println (arrlist1.toString ());
        ArrayList<String> arrlist2 = new ArrayList <> (  );
        obj2.copyArraytoArrayList ( obj2.getObj (), arrlist2 );
        System.out.println (arrlist2.toString ());
    }
}
