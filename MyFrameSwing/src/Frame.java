import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame extends JFrame {
    public Frame(String title){
        setTitle(title);
        setBounds(300,300, 640,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton[] jb = new JButton[5];
        for(int i = 0; i<jb.length; i++){
            jb[i]=new JButton("#"+i);
        }
       // setLayout(new BorderLayout());
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
       // setLayout(new FlowLayout());
    // setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLayout(new GridLayout(2,2));
        JPanel[] jp = new JPanel[4];//4 панели
        for(int i = 0; i<jp.length;i++){
            jp[i]=new JPanel();
            add(jp[i]);
            jp[i].setBackground(new Color(i*10,80+i*15, 20+i*10));
        }
        jp[0].setLayout(new BorderLayout());
        JTextArea jta = new JTextArea();
        JScrollPane jsb = new JScrollPane(jta);
        jp[0].add(jsb);

        jp[1].setLayout(new FlowLayout());
        JRadioButton[] jrb = new JRadioButton[4];
        ButtonGroup bgr = new ButtonGroup();
        for (int i = 0; i<jrb.length; i++){
            jrb[i]= new JRadioButton("Option#"+i);
            bgr.add(jrb[i]);
            jp[1].add(jrb[i]);
        }
        JCheckBox[] jcb = new JCheckBox[4];
        for(int i = 0; i<jcb.length; i++){
            jcb[i]= new JCheckBox("Check#"+i);
            jp[1].add(jcb[i]);
        }
        jp[2].setLayout(new FlowLayout());
        String[] comboStr={"Item#1","Item#2", "Item#3", "Item#4"};
        JComboBox<String> jcombo1 = new JComboBox<String>(comboStr);
        JComboBox<String> jcombo2 = new JComboBox<String>(comboStr);
        JButton jb1 = new JButton("Стереть");
        jp[2].add(jb1);
        jp[2].add(jcombo1);
        jp[2].add(jcombo2);
        jcombo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jcombo1.getSelectedItem().toString());
            }
        });
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText("");
            }
        });

        jp[3].setLayout(null);
        JSlider js = new JSlider();
        JLabel jlab = new JLabel("Value 50");
        js.setMaximum(100);
        js.setMinimum(0);
        js.setValue(50);
        jp[3].add(jlab);
        jp[3].add(js);
        js.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jlab.setText("Value: " + js.getValue());
            }
        });
        jlab.setBounds(10,10, 100,20);
        js.setBounds(20,40,300,100);
        js.setBackground(new Color(49,250, 175));

        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenu mEdit = new JMenu("Edit");
        JMenuItem mFileNew = new JMenuItem("New");
        JMenuItem mFileExit = new JMenuItem("Exit");
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mEdit);
        mFile.add(mFileNew);
        mFile.add(mFileExit);

        mFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("BYE");
            }
        });
        setVisible(true);

}
}
