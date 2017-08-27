import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) throws MyArraySizeException {
        String a[][] = new String[ 4 ][ 4 ];
        String b[][] = new String[ 3 ][ 4 ];
        String c[][] = new String[ 4 ][ 3 ];
        for ( int i = 0 ; i < a.length ; i++ ) {
            for ( int j = 0 ; j < a[ i ].length ; j++ ) { a[i][j]="2";}
        }
        a[ 0][ 2 ] = "sss";
        System.out.println (arr(a));
    }

    public static int arr(String arr[][]) throws MyArraySizeException {
        if (arr.length != 4) {
            throw new MyArraySizeException ( "Число строк массива меньше 4х" );
        }
        for ( int i = 0 ; i < arr.length ; i++ ) {
            if (arr[ i ].length != 4) {
                throw new MyArraySizeException ( "Число столбцов массива меньше 4х" );
            }
        }
        int sum=0;
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++){
                    try {
                         sum = sum + Integer.parseInt(arr[i][j]);
                    }catch (NumberFormatException e){
                        System.out.println ("не удалось выполнить преобразование ячейки массива "+"["+i+"]"+"["+j+"]");
                    }
            }
        }
        return sum;
    }
}
