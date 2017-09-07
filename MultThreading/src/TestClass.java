public class TestClass {
    private static final int SIZE = 10000000;
    private static final int H = SIZE/2;
    private static final int G = SIZE/4;

    float[] arr;
    float[] arr1=new float[H];
    float [] arr2=new float[H];
    float [] arr3=new float[G];
    float [] arr4=new float[G];
    float [] arr5=new float[G];
    float [] arr6=new float[G];
    public void method1(){
        arr=new float[SIZE];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        useArray ( arr );
        System.out.println("1й метод выполнялся "+ (System.currentTimeMillis() - a));
    }
    public void method2(){
        arr=new float[SIZE];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy ( arr, 0, arr1,0, H);
        System.arraycopy ( arr, H, arr2, 0,H );
        useArray (arr1);
        useArray (arr2);
        System.arraycopy ( arr1,0,arr,0,H );
        System.arraycopy ( arr2,0, arr, H, H);
        System.out.println("2й метод выполнялся "+ (System.currentTimeMillis() - a));
    }
    public void method3(){

        arr=new float[SIZE];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy ( arr, 0, arr3,0, G);
        System.arraycopy ( arr, G, arr4, 0,G );
        System.arraycopy ( arr, H, arr5, 0,G );
        System.arraycopy ( arr, G*3, arr6, 0,G );
        useArray (arr3);
        useArray (arr4);
        useArray (arr5);
        useArray (arr6);
        System.arraycopy ( arr3,0,arr,0,G);
        System.arraycopy ( arr4,0, arr, G, G);
        System.arraycopy ( arr5,0, arr, H, G);
        System.arraycopy ( arr6,0, arr, G*3, G);
        System.out.println("3й метод выполнялся "+ (System.currentTimeMillis() - a));
    }
    public void useArray( float arr[]){
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;
        }
    }

}
