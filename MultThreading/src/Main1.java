public class Main1 implements Runnable{
    private static final int SIZE = 10000000;
    private static final int H = SIZE/2;
    static float[] arr = new float[SIZE];
    static float[] arr1=new float[H];
    static float [] arr2=new float[H];
    static long b;
    static long c;

    public static void main(String[] args) {
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        method1 ();
        System.out.println("1й метод выполнялся "+ (System.currentTimeMillis() - a));

        Main1 m = new Main1 ();
        Thread mt1 = new Thread ( m );
        Method2 m2 = new Method2 ();
        Thread mt2 = new Thread ( m2 );
        mt1.start ();
        mt2.start ();
        try {
            mt1.join ();
            mt2.join ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.out.println("2й метод выполнялся "+ (c + b));
    }
    public static void method1 (){
        useArray ( arr );
    }
    public static void useArray( float arr[]){
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;
        }
    }
    @Override
    public void run() {
        b = System.currentTimeMillis();
        System.arraycopy ( arr, 0, arr1,0, H);
        useArray (arr1);
        System.arraycopy ( arr1,0,arr,0,H );
        b= (System.currentTimeMillis() - b);
    }
public static class Method2 implements Runnable{
    @Override
    public void run() {
        c = System.currentTimeMillis();
        System.arraycopy ( arr, H, arr2, 0,H );
        useArray (arr2);
        System.arraycopy ( arr2,0, arr, H, H);
        c= (System.currentTimeMillis() - c);
    }
}
}

