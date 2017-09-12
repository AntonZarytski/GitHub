package Client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



public class JFrame2 extends JFrame {
    private GridBagLayout gbl;
    private JTextArea taText;
    private JTextField tfMessage;
    private JButton jbSend;
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public JFrame2(String title) {
        try{
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        }   catch (IOException e) {
            e.printStackTrace ();
        }
        setTitle ( title );
        setBounds ( 300, 300, 480, 480 );
        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        setResizable ( false );
        gbl = new GridBagLayout ();
        setLayout ( gbl );
        GridBagConstraints c = new GridBagConstraints ();
        c.gridx = 0;//координата начала по x
        c.gridy = 0;//координата начала по y
        c.gridwidth = GridBagConstraints.REMAINDER;// сколько клеток занимает в длинну
        c.gridheight = 70;// сколько клеток загимает в высоту
        c.weightx = 1.0;//растяжение по x
        c.weighty = 0.8;//растяжение по y
        c.anchor = GridBagConstraints.NORTH;//где будит располагаться
        c.fill = GridBagConstraints.BOTH;// ориентация
        c.insets = new Insets ( 5, 5, 0, 5 );// отступы
        c.ipadx = 0;// масштаб по x
        c.ipady = 0;// масштаб по y
        taText = new JTextArea ();//23 25
        taText.setEditable ( false );
        gbl.setConstraints ( taText, c );
        add ( taText, c );
        taText.setBackground ( new Color ( 217, 250, 241 ) );
        GridBagConstraints c2 = new GridBagConstraints ( 0, 81, 70, 20, 1.0, 0.02, GridBagConstraints.SOUTHWEST, GridBagConstraints.BOTH, new Insets ( 0, 5, 5, 0 ), 0, 0 );
        tfMessage = new JTextField ("Введите сообщение:");
        tfMessage.setBackground ( new Color ( 217, 250, 241 ) );
        gbl.setConstraints ( tfMessage, c2 );
        add ( tfMessage, c2 );
        tfMessage.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tfMessage.getText ().trim ().isEmpty ()){
                    sendMsg ();
                    tfMessage.grabFocus ();
                }
            }
        } );

        GridBagConstraints c3 = new GridBagConstraints ( 71, 81, 30, 20, 0.1, 0.02, GridBagConstraints.SOUTHEAST, GridBagConstraints.BOTH, new Insets ( 0, 0, 5, 5 ), 0, 0 );
        jbSend = new JButton ( "Отправить" );
        gbl.setConstraints ( jbSend, c3 );
        add ( jbSend, c3 );
        jbSend.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                    sendMsg ();
            }
        } );
        tfMessage.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            tfMessage.setText("");
            }
        });
        Thread thread1 = new Thread ( new Runnable () {
            @Override
            public void run(){
                try{
                    while(true) {
                        synchronized (this) {
                            String msg = in.readUTF ();
                            System.out.println ( msg );
                            taText.append ( msg + "\n" );
                        }
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
        thread1.start ();

        JMenuBar mainMenu = new JMenuBar ();
        JMenu mFile = new JMenu ( "File" );
        JMenuItem miFileExit = new JMenuItem ( "Exit" );
        setJMenuBar ( mainMenu );
        mainMenu.add(mFile);
        mFile.add(miFileExit);
        miFileExit.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println ("End");
                    out.flush ();
                    socket.close ();
                    out.close ();
                    in.close ();
                    System.exit ( 0 );
                } catch (IOException exc) {

                }
            }
        } );
        addWindowListener ( new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    System.out.println ("End");
                    out.flush ();
                    socket.close ();
                    out.close ();
                    in.close ();
                    System.exit ( 0 );
                } catch (IOException exc) {
                }
            }
        } );
        setVisible ( true );
    }
    public synchronized void sendMsg(){
        String msg = tfMessage.getText();
        tfMessage.setText("");
        try{
            out.writeUTF(msg);
            out.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}