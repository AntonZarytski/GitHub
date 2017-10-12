import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TestingArray ta = new TestingArray ();

        Integer[] arr = new Integer[]{2,4,5,6,4,9,5,6,87,8};
        System.out.println ( Arrays.toString ( ta.newArr ( arr ) ) );

        int[] arr2 = new int[]{4,1,4,4,1,1,4,4};
        System.out.println (ta.testArr ( arr2 ));
    }
}
