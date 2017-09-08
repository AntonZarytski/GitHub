package secondPlan;

public class Thread2 implements Runnable {
    private long b;

    @Override
    public void run() {
        b = System.currentTimeMillis();
        System.arraycopy ( ArrUse.getArr (), 0, ArrUse.getArr1 (),0, ArrUse.getArr1 ().length);
        ArrUse.useArray (ArrUse.getArr1());
        System.arraycopy (ArrUse.getArr1(),0,ArrUse.getArr (),0, ArrUse.getArr1 ().length );
        b= (System.currentTimeMillis() - b);
    }
    public long getB() {
        return b;
    }

}
