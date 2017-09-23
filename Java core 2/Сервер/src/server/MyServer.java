package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class MyServer {
    private ServerSocket server = null;
    private Socket clientSocket = null;
    private Scanner sc;
    private static Vector <ClientHendler> clients;
    private AuthService authService;
    public AuthService getAuthService(){
        return authService;
    }

    public MyServer(int port) {
        new Thread ( ()-> {
            try {
                server = new ServerSocket ( port );
                System.out.println ( "сервер запущен" );
/*                authService = new BaseAuthService ();
                authService.start ();*/
                clients = new Vector <> ();
                while (true) {
                    clientSocket = server.accept ();
                    subscribeMe ( new ClientHendler ( this, clientSocket ) );
                    System.out.println ( "Клиент подключен" );
                }
            } catch (IOException e) {
                e.printStackTrace ();
                System.out.println ( "Не удалось запустить сервер" );
                try {
                    clientSocket.close ();
                    server.close ();
                    authService.stop ();
                } catch (IOException e1) {
                    e1.printStackTrace ();
                }
            }
        }).start ();

        Thread thread2 = new Thread ( new Runnable () {
            @Override
            public void run() {
                    try {
                        sc = new Scanner ( System.in );
                        String outMsg;
                        while (true) {
                            outMsg = sc.nextLine ();
                            broadCastMsg ( "Сервер " + outMsg );
                        }
                    } catch (Exception e) {//?
                        try {
                            clientSocket.close ();
                            server.close ();
                        } catch (IOException e1) {
                            e1.printStackTrace ();
                        }
                    }
            }
        } );
        thread2.start ();
    }
    public static void broadCastMsg(String msg){
        for(ClientHendler c: clients){
            c.sendMessage (msg);
        }
    }
    public synchronized boolean isNickBusy(String nick){
        for ( ClientHendler c: clients ){
            if(c.getNickName().equals(nick))return true;
        }
        return false;
    }
    public static void subscribeMe (ClientHendler c){
        clients.add (c);
    }
    public static void unsubscribeMe(ClientHendler c){
        clients.remove (c);
    }
}

