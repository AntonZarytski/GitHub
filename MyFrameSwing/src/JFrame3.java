import javax.swing.*;
import java.awt.*;

public class JFrame3 extends JFrame {

    private JPanel panel1;
    private JButton отправитьButton;
    private JTextField textField2;
    private JTextArea textArea1;
    private JRadioButton radioButton1;
    private JButton button1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button2;
    private JTextField textField3;
    private JRadioButton radioButton2;

    public JFrame3(String title){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);
        setBounds(20,20,1024,1024);
        //setResizable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx=100;
        gbc1.gridy=100;
        gbc1.gridwidth=200;
        gbc1.gridheight=500;

        add(panel1);
        add(отправитьButton);
        add(textField2,gbc1);
        add(textArea1,gbc1);
        setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
