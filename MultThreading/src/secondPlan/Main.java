package secondPlan;

public class Main {
    public static void main(String[] args) {
        ArrUse arrUse = new ArrUse ();
        long b = System.currentTimeMillis();
        arrUse.calculateArr (arrUse.getArr());
        System.out.println("1й метод выполнялся "+ ((System.currentTimeMillis() - b)));
       Method2 firstPartOfArr = new Method2 ();
       Method2.SecondArr secondPartOfArr = new Method2.SecondArr ();
       Thread thread1 = new Thread ( firstPartOfArr);
       Thread thread2 = new Thread (secondPartOfArr );
       long a = System.currentTimeMillis();
       thread1.start ();
       thread2.start ();
        try {
            thread1.join ();
            thread2.join ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.out.println("2й метод выполнялся "+ ((System.currentTimeMillis() - a)));
    }
}
