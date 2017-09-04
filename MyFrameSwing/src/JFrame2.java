import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrame2 extends JFrame{
    public JFrame2(String title){
        setTitle(title);
        setBounds(300,300,640,480);
        //setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(new GridLayout(2,1));
        JPanel jp1 = new JPanel();
        add(jp1);
        JTextPane taText = new JTextPane();
        jp1.add(taText);
        JPanel jp2 = new JPanel(new GridLayout(1,2),true);
        add(jp2);
        TextField tfMessage = new TextField();
        JButton jbSend = new JButton("Отправить");
        jbSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = tfMessage.getText();
                taText.setText(s);
                tfMessage.setText("");
            }
        });
        tfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = tfMessage.getText();
                taText.setText(s +"\n");
                tfMessage.setText("");
            }
        });
        jp2.add(tfMessage);
        jp2.add(jbSend);


        setVisible(true);
    }
}
