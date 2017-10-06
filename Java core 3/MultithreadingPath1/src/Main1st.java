
public class Main1st {
    private static final Object mon = new Object ();
    private static char nextChar = 'A';
    public static void main(String[] args) {
        Thread t1 = new Thread ( ()->{
            try {
            for (int i = 0; i<5; i++) {
                synchronized (mon) {
                    while (nextChar != 'A') {
                        mon.wait ();
                    }
                    System.out.print ( 'A' );
                    nextChar = 'B';
                    mon.notifyAll ();
                }
            }
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        } );

        Thread t2 = new Thread ( ()-> {
            try {
            for (int i = 0; i<5; i++){
                synchronized (mon) {
                    while (nextChar != 'B') {

                        mon.wait ();

                    }
                    System.out.print ( 'B' );
                    nextChar = 'C';
                    mon.notifyAll ();
                }
            }
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        } );

        Thread t3 = new Thread ( ()-> {
            try {
            for(int i = 0; i<5; i++){
                synchronized (mon) {
                    while (nextChar != 'C') {
                        mon.wait ();
                    }
                    System.out.println ( 'C' );
                    nextChar = 'A';
                    mon.notifyAll ();
                }
            }
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        } );
        t1.start ();
        t2.start ();
        t3.start ();
    }
}
