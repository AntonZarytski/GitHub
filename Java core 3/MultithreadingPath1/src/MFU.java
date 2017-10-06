public class MFU {
    private static int countOfPrint;
    private static int countOfScan;
    private final Object print;
    private final Object scan;


    public MFU(){
       countOfPrint =1;
       countOfScan =1;
       print = new Object();
       scan = new Object();
    }
    public void print() {
        Thread t1 = new Thread ( () -> {
            synchronized (print) {
                System.out.println ( "Печатаю лист " + countOfPrint );
                try {
                    Thread.sleep ( 500 );
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                System.out.println ( "Напечатал лист " + countOfPrint );
                countOfPrint++;
            }
        } );
        t1.start ();
    }

    public void scan() {
        Thread t2 = new Thread ( () -> {
            synchronized (scan) {
                System.out.println ( "Сканирую лист " + countOfScan );
                try {
                    Thread.sleep ( 500);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                System.out.println ( "Отсканировал лист " + countOfScan );
                countOfScan++;
            }
        } );
        t2.start ();
    }

}
