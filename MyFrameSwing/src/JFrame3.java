import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrame3 extends JFrame{
    public JFrame3(String title){
        setTitle(title);
        setBounds(0,0, 640,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        JButton jb = new JButton("кнопа 1");
        TextField jb1 = new TextField();
        JTextField tf = new JTextField();
        add(jb, BorderLayout.WEST);
        add(jb1, BorderLayout.SOUTH);
        add(tf, BorderLayout.CENTER);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = jb1.getText();
                tf.setText(s);
                jb1.setText("");
            }
        });
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = jb1.getText();
                tf.setText(s);
                jb1.setText("");
            }
        });

        setVisible(true);
    }
}