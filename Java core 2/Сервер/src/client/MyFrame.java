package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyFrame extends JFrame {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private JTextArea text;
    private JTextField msg;
    private JButton send;
    private JPanel jpAuth;
    private JButton jbAuth;
    private JTextField userName;
    private JPasswordField userPassword;
    private JTextField nickName;
    private boolean isAuthorised;

    public void setAuthorised(boolean authorised) {
        isAuthorised = authorised;
        jpAuth.setVisible (!isAuthorised);
    }

    public MyFrame(String tittle, String host, int port) throws IOException {
        socket = new Socket ( host, port );
        in = new DataInputStream (socket.getInputStream ());
        out = new DataOutputStream (socket.getOutputStream ());
        setTitle ( tittle );
        setBounds ( 300,300,480,640 );
        setLayout ( new BorderLayout (  ) );
        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        jpAuth = new JPanel ( new GridLayout ( 1,4 ) );
        jbAuth = new JButton ( "Войти в чат" );
        userName = new JTextField ( "Логин" );
        userName.addFocusListener ( new FocusAdapter () {
            @Override
            public void focusGained(FocusEvent e) {
                if(userName.getText ().equals ( "Логин" )) {
                    userName.setText ( "" );
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (userName.getText ().isEmpty ()) {
                    userName.setText ( "Логин" );
                }
            }
        } );
        userPassword = new JPasswordField ( "Пароль" );
        userPassword.addActionListener ( new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                try {
                    out.writeUTF ( "/auth" + " " + userName.getText() + " " + userPassword.getText ()+ " " + nickName.getText ());
                    out.flush ();
                    userName.setText ( "" );
                    userPassword.setText ( "" );
                } catch (IOException e1) {
                    e1.printStackTrace ();
                }
            }
        } );
        userPassword.addFocusListener ( new FocusListener () {
            @Override
            public void focusGained(FocusEvent e) {
                if(userPassword.getText ().equals ( "пароль" )) {
                    userPassword.setText ( "" );
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(userPassword.getText().isEmpty ()){
                    userPassword.setText ( "пароль" );
                }
            }
        } );
        nickName = new JTextField ( "Имя пользователя" );
        nickName.addFocusListener ( new FocusListener () {
            @Override
            public void focusGained(FocusEvent e) {
                if(nickName.getText ().equals ( "Имя пользователя" )) {
                    nickName.setText ( "" );
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(nickName.getText().isEmpty ()){
                    nickName.setText ( "Имя пользователя" );
                }
            }
        } );
        jpAuth.add(userName);
        jpAuth.add(userPassword);
        jpAuth.add(nickName);
        jpAuth.add(jbAuth);
        setAuthorised ( false );
        jbAuth.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    out.writeUTF ( "/auth" + " " + userName.getText() + " " + userPassword.getText ()+ " " + nickName.getText ());
                    out.flush ();
                    userName.setText ( "" );
                    userPassword.setText ( "" );
                } catch (IOException e1) {
                    e1.printStackTrace ();
                }
            }
        } );
        add(jpAuth, BorderLayout.PAGE_START);
        text = new JTextArea (  );
        text.setEditable ( false );
        add(text, BorderLayout.CENTER);
        JPanel jp = new JPanel ( new BorderLayout (  ) );
        add(jp, BorderLayout.SOUTH);
        msg = new JTextField (  );
        jp.add(msg, BorderLayout.CENTER);
        send = new JButton ( "Отправить" );
        jp.add(send, BorderLayout.EAST);

        msg.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = msg.getText ();
                sendMsg (s);
            }
        } );
        send.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = msg.getText ();
                sendMsg (s);
            }
        } );
        Thread thread1 = new Thread ( new Runnable () {
            @Override
            public void run() {
                    try {
                        String inputMsg;
                        while (true){
                            inputMsg = in.readUTF ();
                            if(inputMsg.startsWith ("/authisok")) {
                                setAuthorised (true);
                            }
                            break;
                        }
                        text.setCaretPosition ( text.getDocument ().getLength () );
                        while (true) {
                            inputMsg = in.readUTF ();
                            text.append ( inputMsg + "\n" );
                            text.setCaretPosition ( text.getDocument ().getLength () );
                        }
                    } catch (IOException e) {
                        try {
                            socket.close ();
                        } catch (IOException e1) {
                            e1.printStackTrace ();
                        }
                        isAuthorised = false;
                        sendMsg ("end");
                        e.printStackTrace ();
                    }
                }
        } );
        thread1.setDaemon ( true );
        thread1.start ();
        setVisible ( true );
    }
    public void sendMsg(String message){
        try {
            out.writeUTF ( message );
            out.flush ();
            msg.setText ("");
        } catch (IOException e1) {
            System.out.println ("Ощибка отправки сообщения");
        }
    }
}
