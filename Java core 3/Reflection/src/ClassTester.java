import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ClassTester {
    private static int beforesuiteCount=0;
    private static int aftersuiteCount=0;

    public static void start(Class c) throws InvocationTargetException, IllegalAccessException, InstantiationException {
            Object ob = c.newInstance ();
        Method[] methods = c.getDeclaredMethods ();
        for ( Method o: methods) {
          //  if(beforesuiteCount==0) {
                if (o.isAnnotationPresent (BeforeSuite.class)) {
                    o.invoke ( ob );
                    beforesuiteCount++;
              //  }else throw new RuntimeException ( "BeforeSuit`s method already implemented" );
            }
//            o.getAnnotation ( Test.class ).priority ();
            if(o.isAnnotationPresent ( Test.class ))
                o.invoke ( ob );

          //  if(aftersuiteCount==0) {
                if(o.isAnnotationPresent ( AfterSuite.class ))
                    o.invoke ( ob );
                  aftersuiteCount++;
          //  }else throw new RuntimeException ( "AfterSuit`s method already implemented" );
        }
    }
}
