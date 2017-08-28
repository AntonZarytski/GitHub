public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String a[][] = new String[ 4 ][ 4 ];
        for ( int i = 0 ; i < a.length ; i++ ) {
            for ( int j = 0 ; j < a[ i ].length ; j++ ) { a[i][j]="2";}
        }
        //a[ 0][ 2 ] = "sss"; проверка на преоброзование String в int
        System.out.println (arr(a));
    }

    public static int arr(String arr[][]) throws MyArraySizeException, MyArrayDataException {
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
                        throw new MyArrayDataException ("не удалось выполнить преобразование ячейки массива "+"["+i+"]"+"["+j+"]");
                    }
            }
        }
        return sum;
    }
}
