import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrame2 extends JFrame{
    public JFrame2(String title){
        setTitle(title);
        setBounds(300,300,480,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        GridBagConstraints c =  new GridBagConstraints();
        JLabel jl = new JLabel("Чат");
        c.gridx = 0;//координата начала по x
        c.gridy = 0;//координата начала по y
        c.gridwidth  = GridBagConstraints.REMAINDER;// сколько клеток занимает в длинну
        c.gridheight = 80;// сколько клеток загимает в высоту
        c.weightx = 1.0;//растяжение по x
        c.weighty = 0.8;//растяжение по y
        c.anchor = GridBagConstraints.NORTH;//где будит располагаться
        c.fill   = GridBagConstraints.BOTH;// ориентация
        c.insets = new Insets(5, 5, 0, 5);// отступы
        c.ipadx = 0;// масштаб по x
        c.ipady = 0;// масштаб по y
        JTextArea taText= new JTextArea();//23 25
        gbl.setConstraints(taText, c);
        add(taText,c);
        taText.add(jl);
        taText.setBackground(new Color(217, 250, 241));
        GridBagConstraints c2 =  new GridBagConstraints(0,81,70,20,1.0,0.02,GridBagConstraints.SOUTHWEST,GridBagConstraints.BOTH,new Insets(0, 5, 5, 0),0,0);
        JTextField tfMessage = new JTextField();//29
        tfMessage.setBackground(new Color(217, 250, 241));
        gbl.setConstraints(tfMessage, c2);
        add(tfMessage,c2);
        tfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = tfMessage.getText();
                taText.setText(s +"\n");
                tfMessage.setText("");
            }
        });

        GridBagConstraints c3 =  new GridBagConstraints(71,81,30,20,0.1,0.02,GridBagConstraints.SOUTHEAST,GridBagConstraints.BOTH,new Insets(0, 0, 5, 5),0,0);
        JButton jbSend = new JButton("Отправить");
        gbl.setConstraints(jbSend, c3);
        add(jbSend,c3);
        jbSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = tfMessage.getText();
                taText.setText(s);
                tfMessage.setText("");
            }
        });

        setVisible(true);
    }
}
