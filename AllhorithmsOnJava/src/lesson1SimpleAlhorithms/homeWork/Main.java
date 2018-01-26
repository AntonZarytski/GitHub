package lesson1SimpleAlhorithms.homeWork;

public class Main {
    public static void main(String[] args) {
        System.out.println(exp(3,3));
        System.out.println(expRec(3,4));

        Double[] arr = {13.2, 78.741, 14.1,7.5, 23.0,5.0, -18.5, -11.0,4.7 ,15.8};
        Integer[] arr1 = {13, 18, 14,7, 23,5, -18, -11,4 ,15};
        System.out.println(searchMin(arr));
        System.out.println(searchMin(arr1));

        System.out.println(searchAver(arr));
        System.out.println(searchAver(arr1));
    }
    /**степень без рекурсии O(n)*/
    public static int exp(int base, int index){
        int result = 1;
        if (index==0)
            return result;
        else if(index==1)
            return base;
        for (int i = 0; i < index ; i++) {
            result = result*base;
        }
        return result;
    }
    /**степень с рекурсией O(n)*/
    public static int expRec(int base, int index){
        if (index==0)
            return 1;
        else if (index==1)
            return base;
        return base*expRec(base, index-1);
    }
    /**нахождение минимального элемента массива O(n)*/
    public static <T extends Number> Double searchMin(T[] arr){
        double min=arr[0].doubleValue();
        // вопрос. Почему нельзя применять арифмитические и логические действия с Т без каста .doubleValue()?
        for (T anArr : arr) {
            if (anArr.doubleValue() < min) {
                min = anArr.doubleValue();
            }
        }
        return min;
    }
    /**нахождение среднего арефмитического всеъ элементов массива O(n)*/
    public static <T extends Number> Double searchAver(T[] arr){
        double summ=0;
        for (T anArr : arr) {
            summ += anArr.doubleValue();
        }
        return summ/arr.length;
    }
}


