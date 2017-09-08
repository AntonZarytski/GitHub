package secondPlan;

public class ArrUse {
    private static final int SIZE = 10000000;
    private static final int H = SIZE / 2;
    private static float[] arr = new float[ SIZE ];
    private static float[] arr1 = new float[ H ];
    private static float[] arr2 = new float[ H ];

    public static void arrTo1(float arr[]){
        for ( int i = 0 ; i < arr.length ; i++ ) {
            arr[ i ]=1;
        }
    }
    public static void useArray(float arr[]) {
        for ( int i = 0 ; i < arr.length ; i++ ) {
            arr[ i ] = (float) (arr[ i ] * Math.sin ( 0.2f + i / 5 ) * Math.cos ( 0.2f + i / 5 ) * Math.cos ( 0.4f + i / 2 ));
        }
    }

    public static float[] getArr() {
        return arr;
    }

    public static float[] getArr1() {
        return arr1;
    }

    public static float[] getArr2() {
        return arr2;
    }

}
