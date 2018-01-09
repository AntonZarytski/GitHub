import java.io.*;
import java.util.Scanner;

public class Main {
    static int[] arr = new int[1000];
    static int cache;
    static ObjectOutputStream out;
    static ObjectInputStream in;
    static Scanner sc;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //создание массива с рандомными значеиями от 1 до 1000
  /*      for (int i = 0; i <arr.length ; i++) {
            arr[i] = (int)Math.round(Math.random()*1000);
        }
        out = new ObjectOutputStream(new FileOutputStream("myArr.txt"));
        out.writeObject(arr);
        out.close()*/
        in = new ObjectInputStream(new FileInputStream("myArr.txt"));
        arr = (int[])in.readObject();
        in.close();

        printArray(arr);
        System.out.println();
        System.out.println("число операций при пузырьковой сортировке" + boubleSort(arr));//1236193
        System.out.println();
        printArray(arr);

        in = new ObjectInputStream(new FileInputStream("myArr.txt"));
        arr = (int[])in.readObject();
        in.close();

        System.out.println();
        System.out.println("число операций при улучшеной пузырьковой сортировке" + boubleSortMod(arr));//736693
        System.out.println();
        printArray(arr);

        in = new ObjectInputStream(new FileInputStream("myArr.txt"));
        arr = (int[])in.readObject();
        in.close();

        System.out.println();
        System.out.println("число операций при шейкерной сортировке" + shakerSort(arr));//1236193
        printArray(arr);
        System.out.println();

        System.out.println("Введите число для поиска");
        sc = new Scanner(System.in);
        int val = sc.nextInt();
        System.out.println("Индекс " + val + " в массиве " + binarySearch(arr, val));
    }

    static void printArray(int[] arr){
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i] + " ");
            if(i%40==0)
                System.out.println();
        }
    }

    static int boubleSort(int[] arr){
        int count = 0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-1 ; j++) {
                count++;
                if(arr[j]>arr[j+1]){
                    count++;
                    cache = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = cache;
                }
            }
        }
        return count;
    }

    static int boubleSortMod(int[] arr){
        int count = 0;
        int a = 1;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-a ; j++) {
                count++;
                if(arr[j]>arr[j+1]){
                    count++;
                    cache = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = cache;
                }
            }
            a++;
        }
        return count;
    }

    static int shakerSort(int[] arr){
        int count = 0;
        int a = 1;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-a; j++) {
                count++;
                if(arr[j]>arr[j+1]){
                    count++;
                    cache = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = cache;
                }
            }
            for (int j = arr.length-a; j >0  ; j--) {
                count++;
                if(arr[j]<arr[j-1]){
                    count++;
                    cache = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = cache;
                }
            }
            a++;
        }
        return count;
    }
    static int binarySearch(int[] arr, int val){
        int L = 0, R=arr.length-1;
        int m = L + (R-L)/2;
        while(L<=R && arr[m] != val){
            if(arr[m]<val)
                L = m + 1;
            else
                R = m - 1;
            m = L + (R-L)/2;

        }
        if(arr[m] == val)
            return m;
        else
        return -1;
    }
}
