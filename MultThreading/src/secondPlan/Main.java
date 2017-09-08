package secondPlan;

public class Main {
    public static void main(String[] args) {
       ArrUse.arrTo1(ArrUse.getArr());
       ArrUse.useArray(ArrUse.getArr());
       Thread1 thr1 = new Thread1 ();
       Thread2 thr2 = new Thread2 ();
       Thread thread1 = new Thread ( thr1 );
       Thread thread2 = new Thread ( thr2 );
       thread1.start ();
       thread2.start ();
        try {
            thread1.join ();
            thread2.join ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.out.println ("2й метод выполнялся " + thr1.getC ()+thr2.getB ());
    }
}
