import java.io.FileInputStream;
import java.io.IOException;

public class Main1st {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream ("fileForFirstTask.txt");
            byte[] buffer = new byte[in.available ()];
            in.read ( buffer );
            for ( byte a : buffer ) {
                System.out.print ((char) a);
            }

            in.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }


    }
}
