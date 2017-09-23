public class Method2 implements Runnable{
    static ArrUse arr = new ArrUse ();

    @Override
    public void run() {
        System.arraycopy ( arr.getArr (), 0, arr.getArr1 (),0, arr.getArr1 ().length);
        arr.calculateArr (arr.getArr1());
        System.arraycopy (arr.getArr1(),0,arr.getArr (),0, arr.getArr1 ().length );
    }

    static class SecondArr implements Runnable{

        @Override
        public void run() {
            System.arraycopy ( arr.getArr (),arr.getArr2 ().length, arr.getArr2 (), 0,arr.getArr2 ().length );
            arr.calculateArr (arr.getArr2 ());
            System.arraycopy ( arr.getArr2 (),0, arr.getArr (), arr.getArr2 ().length, arr.getArr2 ().length);
        }
    }
}
