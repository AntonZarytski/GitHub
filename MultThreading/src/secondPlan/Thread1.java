package secondPlan;

public class Thread1 implements Runnable {
    private long c;

    public void run() {
        c = System.currentTimeMillis();
        System.arraycopy ( ArrUse.getArr (), ArrUse.getArr2 ().length, ArrUse.getArr2 (), 0,ArrUse.getArr2 ().length );
        //secondPlan.ArrUse.arrTo1 ( secondPlan.ArrUse.getArr2() );
        ArrUse.useArray (ArrUse.getArr2 ());
        System.arraycopy ( ArrUse.getArr2 (),0, ArrUse.getArr (), ArrUse.getArr2 ().length, ArrUse.getArr2 ().length);
        c= (System.currentTimeMillis() - c);
    }
    public float getC() {
        return c;
    }
}
