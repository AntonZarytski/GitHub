package thirdTask;

import java.io.*;

public class ReadTheText {
    private InputStream in;
    private byte[] buffer;
    ReadTheText (String path){
        try {
            in = new BufferedInputStream (new FileInputStream ( path ));
            buffer = new byte[in.available ()];
            in.read (buffer, 0, buffer.length);
            in.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public void readText(int numOfPage){
        int truePage = numOfPage-1;
        int readOf = truePage*1800;
            for ( int a = readOf; a<readOf+1800; a++ ) {
                if(a%140==0) System.out.println ();
                System.out.print ((char) buffer[a]);
            }
    }
}
