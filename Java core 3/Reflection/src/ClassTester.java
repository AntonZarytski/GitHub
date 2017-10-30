import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class ClassTester {
    private final static int MIN_PRIORITY = 1;
    private final static int MAX_PRIORITY = 10;

    public  static void start(Class<?> c) throws InvocationTargetException, IllegalAccessException, InstantiationException {

            Object ob = c.newInstance ();
            Map<Integer, Method> map = sort(c);
            for (Integer key : map.keySet()) {
                map.get(key).invoke(ob);
            }
        }

    private static Map<Integer, Method> sort(Class c){
        Method[] methods = c.getDeclaredMethods ();
        Map<Integer, Method> map = new TreeMap<> ();
        for ( int i = 0 ; i <methods.length  ; i++ ) {
            if(methods[i].getAnnotation ( BeforeSuite.class )!=null){
                if(map.containsKey ( MAX_PRIORITY-10 ))
                    throw new RuntimeException ("The BeforeSuite method already in use" );
                else {
                    map.put ( MAX_PRIORITY-10, methods[i]);
                }
            }
            if(methods[i].getAnnotation ( AfterSuite.class )!=null){
                if(map.containsKey ( MIN_PRIORITY+10 ))
                    throw new RuntimeException ("The AfterSuite method already in use" );
                else map.put ( MIN_PRIORITY+10, methods[i]);
            }
            if (methods[i].getAnnotation(Test.class) != null) {
                map.put(Math.abs(methods[i].getAnnotation ( Test.class ).priority ()-10), methods[i]);
            }
        }
        return map;
    }
}


