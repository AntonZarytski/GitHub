public class Main3rd {

    public static void main(String[] args) {
        MFU mfu = new MFU ();
        for (int i =0; i<20; i++){
            int a = (int) Math.round ( Math.random () );
            if(a==0)mfu.scan ();
            if(a==1)mfu.print ();
        }
    }
}
