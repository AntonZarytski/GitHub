import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(String s){
        setTitle ( s );
        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        setBounds ( 500,500,1280,720 );// координаты создания и разрешение окна
        setVisible ( true );
    }
}
