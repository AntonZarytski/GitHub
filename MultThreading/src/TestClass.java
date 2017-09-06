public class TestClass {
    private static final int SIZE = 10000000;
    private static final int H = SIZE/2;
    private static final int G = SIZE/4;

    float[] arr= new float[SIZE];
    float[] arr1=new float[H];
    float [] arr2=new float[H];
    float [] arr3=new float[H];
    float [] arr4=new float[H];
    public void method1(){
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;
        }
        System.out.println(System.currentTimeMillis() - a);
    }
    public void method2(){
        arr=new float[SIZE];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy ( arr, 0, arr1,0, H);
        System.arraycopy ( arr, H, arr2, 0,H );
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;
        }
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;
        }
        System.arraycopy ( arr1,0,arr,0,H );
        System.arraycopy ( arr2,0, arr, H, H);
        System.out.println(System.currentTimeMillis() - a);
    }
    public void method3(){
        arr=new float[SIZE];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy ( arr, 0, arr1,0, G);
        System.arraycopy ( arr, G, arr2, 0,G );
        System.arraycopy ( arr, H, arr3, 0,G );
        System.arraycopy ( arr, G*3, arr4, 0,G );
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;
        }
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;
        }
        for(int i = 0; i < arr3.length; i++){
            arr3[i] = (float)(arr3[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;
        }
        for(int i = 0; i < arr4.length; i++){
            arr4[i] = (float)(arr4[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;
        }
        System.arraycopy ( arr1,0,arr,0,G);
        System.arraycopy ( arr2,0, arr, G, G);
        System.arraycopy ( arr2,0, arr, H, G);
        System.arraycopy ( arr2,0, arr, G*3, G);
        System.out.println(System.currentTimeMillis() - a);
    }

}
