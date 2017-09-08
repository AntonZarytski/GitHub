package secondPlan;

public class ArrUse {
    private static final int SIZE = 10000000;
    private static final int H = SIZE / 2;
    private float[] arr = new float[ SIZE ];
    private float[] arr1 = new float[ H ];
    private float[] arr2 = new float[ H ];
    ArrUse(){
        for ( int i = 0 ; i < arr.length ; i++ ) {
            arr[ i ]=1;
        }
    }
    public static float[] calculateArr(float arr[]) {
        for ( int i = 0 ; i < arr.length ; i++ ) {
            arr[ i ] = (float) (arr[ i ] * Math.sin ( 0.2f + i / 5 ) * Math.cos ( 0.2f + i / 5 ) * Math.cos ( 0.4f + i / 2 ));
        }
        return arr;
    }

    public float[] getArr() {
        return arr;
    }

    public float[] getArr1() {
        return arr1;
    }

    public float[] getArr2() {
        return arr2;
    }

}
