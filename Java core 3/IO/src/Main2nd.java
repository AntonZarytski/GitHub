import java.io.*;
import java.util.Vector;

public class Main2nd {
    static FileInputStream in1;
    static FileInputStream in2;
    static FileInputStream in3;
    static FileInputStream in4;
    static FileInputStream in5;
    static FileOutputStream out;
  //  static Enumeration<FileInputStream> e;
    static Vector<FileInputStream> vin;
    static InputStream in;

    public static void main(String[] args) {
        try {
            in1 = new FileInputStream ("filesForSecondTask\\1.txt");
            in2 = new FileInputStream ("filesForSecondTask\\2.txt");
            in3 = new FileInputStream ("filesForSecondTask\\3.txt");
            in4 = new FileInputStream ("filesForSecondTask\\4.txt");
            in5 = new FileInputStream ("filesForSecondTask\\5.txt");
            out= new FileOutputStream ("filesForSecondTask\\6.txt" );
            vin = new Vector <> ();
                vin.addElement(in1);
                vin.addElement(in2);
                vin.addElement(in3);
                vin.addElement(in4);
                vin.addElement(in5);
            in = new SequenceInputStream(vin.elements());
            int i = in.read ();
            while(i!=-1){
                out.write(i);
                i=in.read ();
            }
            in.close ();
        } catch (IOException e1) {
            e1.printStackTrace ();
        }
    }
}
