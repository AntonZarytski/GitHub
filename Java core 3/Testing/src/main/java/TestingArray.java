import java.util.ArrayList;

public class TestingArray {
    private Integer[] newArr;

    public Integer[] newArr (Integer[] a ){
        ArrayList<Integer> newArrCol = new ArrayList <Integer> (  );
        int count=0;
        if(a.length<1) {
            throw new NullPointerException ( "Переданный массив пустой" );
        }
        for ( int i = 0 ; i < a.length ; i++ ) {
            if(a[i]==0)//выбрасывает NullPointerException, разве элементы не инициализируются по умолчанию 0?
                count++;
        }
        if((a.length-count)==0)
            throw new NullPointerException ( "Переданный массив пустой" );

        for ( int i = a.length-1; i > 0  ; i-- ) {
            if(a[i]==4) {
                for ( int j = i + 1 ; j < a.length ; j++ ) {
                    newArrCol.add ( a[ j ] );
                }
                newArr= new Integer[newArrCol.size ()];
                newArr = newArrCol.toArray ( newArr );
                return newArr;
            }
        }
        throw new RuntimeException (  );
    }
    public static boolean testArr(int[] a ){
        int summ=0;
        for ( int i = 0 ; i <a.length  ; i++ ) {
            if(a[i]!=4) {
                if(a[i]!=1)
                return false;
            }
            summ=summ+a[i];
        }
        if(summ/4==a.length||summ==a.length)
            return false;
        return true;
    }
}
