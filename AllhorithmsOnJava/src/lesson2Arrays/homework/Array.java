package lesson2Arrays.homework;

import java.util.Arrays;

public class Array {
    private int[] arr;
    private int size;

    public Array(int maxSize) {
        this.size = 0;
        arr = new int[maxSize];
    }

    public void insert(int value){
        if(this.size/arr.length>=0.75) {
            int[] temp = arr;
            this.arr = Arrays.copyOf(temp, temp.length*2);
        }
        arr[size] = value;
        size++;
    }

    public void delete(int value) {
        int i= getIndex(value);
        deleteByIndex(i);
    }

    public void deleteByIndex(int index){
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size] = 0;
        size--;
    }
    private int getIndex(int value){
        int i;
        for(i=0; i<size; i++)
            if (arr[i] == value)
                break;
        return i;
    }
    public int binarySearch(int value){
        int left = 0;
        int right = size-1;
        int mid;
        while(left<right){
            mid = right/2;
            if(value==arr[mid])
                return mid;
            else {
                if(value<arr[mid])
                    right = mid;
                else
                    left = mid+1;
            }
        }
        return -1;
    }

    public void print(){
        for (int i = 0; i <size ; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public void bubbleSort(){
        long t = System.currentTimeMillis();
        double count = 0;
        int size = this.size;
        for (int out = 0; out < size; out++) {
            for (int in = 0; in < size-1 ; in++) {
                if(arr[in]>arr[in+1]) {
                    swapElem(in, in + 1);
                    count++;
                }
            }
        }
        long time = System.currentTimeMillis() - t;
        System.out.println("Пузырьковая сортировка " + count + " операций за " + time +" милисекунд");

    }
    private void swapElem(int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public void insertSort(){
        long t = System.currentTimeMillis();
        double count = 0;
        for (int out = 0; out < size ; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in-1] >= temp ) {
                arr[in] = arr[in - 1];
                in--;
                count++;
            }
            arr[in] = temp;
            count++;
        }
        long time = System.currentTimeMillis() - t;
        System.out.println("Сортировка вставками " + count + " операций за " + time +" милисекунд");
    }
    public void selectSort(){
        long t = System.currentTimeMillis();
        double count = 0;
        int temp, min, in;
        for (int out = 0; out < size; out++) {
            min = out;
            for (in = out+1; in < size ; in++) {
                if(arr[in]<arr[min]) {
                    min = in;
                    count++;
                }
            }
            swapElem(out, min);
            count++;
        }

        long time = System.currentTimeMillis() - t;
        System.out.println("Сортировка выбором  " + count + " операций за " + time +" милисекунд");
    }
}
