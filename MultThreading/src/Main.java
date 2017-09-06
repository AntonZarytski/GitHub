public class Main {

    public static void main(String[] args) {
    TestClass tc = new TestClass ();
        tc.method1 ();
     /* tc.method2 ();
        tc.method3 ();*/
    //new Thread ( tc::method1 ).start ();
    new Thread (()->  tc.method2 ()).start ();
    //new Thread ( tc::method3 ).start ();
    }
}
