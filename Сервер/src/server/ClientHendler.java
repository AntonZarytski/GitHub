package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHendler {
    private MyServer myServer;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private String userName;
    private String nickName;
    private String userPassword;
    private BaseAuthService baseAuth;

    public ClientHendler(MyServer myServer,Socket socket){
        this.myServer = myServer;
        this.socket = socket;
        try {
            in = new DataInputStream ( socket.getInputStream () );
            out = new DataOutputStream ( socket.getOutputStream () );

        } catch (IOException e) {
            e.printStackTrace ();
        }
        new Thread (()-> {
            try {
                String inmsg;
                while (true) {
                    inmsg = in.readUTF ();
                    if (inmsg.startsWith ( "/auth" )) {
                        String[] elements = inmsg.split ( " " );
                        userName = elements[ 1 ];
                        userPassword = elements[ 2 ];
                        nickName = elements[ 3 ];
                        baseAuth = new BaseAuthService(userPassword,nickName);
                        System.out.println (userName+" "+nickName+" "+userPassword);
                        if (nickName != null&&userName!=null&&userPassword!=null) {
                            if (!BaseAuthService.getUserData ().containsKey (userName)) {
                            BaseAuthService.getUserData().put ( userName,baseAuth.getEntries ());
                            sendMessage ( "/authisok");
                            MyServer.broadCastMsg ( nickName + " зашол в чат" );
                            MyServer.subscribeMe ( this );
                            break;
                            }else sendMessage ( "Учетная запись уже занята" );
                        }else sendMessage ( "Введены не корректные данные при авторизации" );
                    } else sendMessage ( "Для начала нужно авторизоваться" );
                }
                    while (true) {
                        inmsg = in.readUTF ();
                        if (inmsg.equalsIgnoreCase ( "end" )) {
                            socket.close ();
                            break;
                        }
                        MyServer.broadCastMsg ( inmsg );
                    }
            }catch (IOException e){
                try {
                    MyServer.unsubscribeMe (this);
                    socket.close ();
                } catch (IOException e1) {
                    e1.printStackTrace ();
                }
                e.printStackTrace ();
            }
        } ).start ();
    }
    public void sendMessage(String msg){
        try {
            out.writeUTF (msg);
            out.flush ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
    public String getNickName() {
        return nickName;
    }
    public void newClient (){

    }
}
