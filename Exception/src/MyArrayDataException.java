import java.sql.SQLOutput;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException (String description){
        super(description);
    }
    public void printStackTrace() {
        System.out.println ("не удалось преобразовать");
    }
}
