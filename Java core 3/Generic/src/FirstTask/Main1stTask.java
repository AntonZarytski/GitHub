package FirstTask;

public class Main1stTask {

    public static void main(String[] args) {
        Integer[] arr = {2,4,6,8,10};
	    TestClass<Integer> obj1 = new TestClass <> ( arr);
        System.out.println (obj1.getObj ()[0] + " " + obj1.getObj ()[4]);
	    obj1.changeElements ( obj1.getObj (), 0, 4 );
        System.out.println (obj1.getObj ()[0] + " " + obj1.getObj ()[4]);

        String[] arr2 = {"H", "E", "L", "L", "O", "!"};
        TestClass<String> obj2 = new TestClass <> ( arr2 );
        System.out.println (obj2.getObj ()[0] + " " + obj2.getObj ()[4]);
        obj2.changeElements ( obj2.getObj (), 0, 4 );
        System.out.println (obj2.getObj ()[0] + " " + obj2.getObj ()[4]);
    }
}
