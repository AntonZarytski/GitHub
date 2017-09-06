public class MyRunableClass extends Thread{

    public synchronized void method1 (){
        System.out.println ("m1 is started");
        for(int i =0; i<10; i++){
            System.out.println (i);
            try {
                Thread.sleep ( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println ("s1 is finished");
    }
    public synchronized void method2 (){
        System.out.println ("m2 is started");
        for (int i = 0; i<10; i++){
            System.out.println (i);
            try {
                Thread.sleep (1000 );
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println ("m2 is finished");
    }

}