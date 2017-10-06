import java.io.FileWriter;
import java.io.IOException;

public class Main2nd {
    public static void main(String[] args) {
        try {
            FileWriter out = new FileWriter ( "FileFor2ndTask.txt" );

        Thread t1 = new Thread ( ()->{
            for(int i = 0; i<10; i++){
                try {
                    out.write ( "1"+" " );
                    out.flush ();
                    Thread.sleep ( 20 );
                } catch (IOException e) {
                    e.printStackTrace ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        } );

        Thread t2 = new Thread ( ()-> {
            for(int i = 0; i<10; i++){
                try {
                    out.write ( "2"+" " );
                    out.flush ();
                    Thread.sleep ( 20 );
                } catch (IOException e) {
                    e.printStackTrace ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        } );

        Thread t3 = new Thread ( ()-> {
            for(int i = 0; i<10; i++){
                try {
                    out.write ("3"+" " );
                    out.flush ();
                    Thread.sleep ( 20 );
                } catch (IOException e) {
                    e.printStackTrace ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        } );

        t1.start ();
        t2.start ();
        t3.start ();

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
