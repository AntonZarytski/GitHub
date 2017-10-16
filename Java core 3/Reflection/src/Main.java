import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
    Class c = Class1.class;
    ClassTester.start ( c );
  /*  Class c2 = Class2.class;
    ClassTester.start ( c2 );
    Class c3 = Class3.class;
    ClassTester.start ( c3 );*/
    }
}
