public class MyRunableClass2 {
    private Object lock1=new Object ();
    public void method1() {
        System.out.println ( "m1 is started" );
        for ( int i = 0 ; i < 3 ; i++ ) {
            System.out.println ( i );
            try {
                Thread.sleep ( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println ( "m1 is finished" );
        synchronized (lock1) {
            System.out.println ( "m2 is started" );
            for ( int i = 0 ; i < 10 ; i++ ) {
                System.out.println ( i );
                try {
                    Thread.sleep ( 1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
            System.out.println ( "m2 is finished" );
        }
    }
}

