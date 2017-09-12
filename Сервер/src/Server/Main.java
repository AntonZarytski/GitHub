package Server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    static ServerSocket server = null;
    static Socket socket = null;

    public static void main(String[] args) {
        try {
            server = new ServerSocket ( 8189 );
            System.out.println ( "Server запущен, ждем клиента" );
            socket = server.accept ();//режим ожидания, возвращаяет сокед и блок выполнение кода
            System.out.println ( "Клиент подключился" );
        } catch (IOException e) {
            e.printStackTrace ();
            System.out.println ( "Не удалось запустить сервер" );
        } /*finally {
            try {
                socket.close ();
                server.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }*/
        Thread thread1 = new Thread ( new Runnable () {
            @Override
            public void run() {
                System.out.println ( "запущено1" );
                try {
                    DataInputStream in = new DataInputStream ( socket.getInputStream () );
                    DataOutputStream out = new DataOutputStream ( socket.getOutputStream () );
                    while (true) {
                        String msg = in.readUTF ();
                        System.out.println ( "Client: " + msg );
                        out.writeUTF ( "Client: " + msg ); //записывается в буфер
                        out.flush (); //достать сообщение из буфера
                        if (msg.equalsIgnoreCase ( "end" )) break;
                    }
                } catch (IOException e) {
                    e.printStackTrace ();
                    try {
                        socket.close ();
                        server.close ();
                    } catch (IOException e1) {
                        e1.printStackTrace ();
                    }
                }
            }
        } );
        thread1.start ();
    Thread thread2 = new Thread ( new Runnable () {
        @Override
        public void run() {
            System.out.println ( "запущено2" );
            Scanner sc = new Scanner ( System.in );
            try {
                DataInputStream in = new DataInputStream ( socket.getInputStream () );
                DataOutputStream out = new DataOutputStream ( socket.getOutputStream () );
                while (true) {
                    String servMsg = sc.nextLine ();
                    out.writeUTF ( "Server " + servMsg );
                    out.flush ();
                    if (servMsg.equalsIgnoreCase ( "end" )) break;
                }
            } catch (IOException e) {
                e.printStackTrace ();
                try {
                    socket.close ();
                    server.close ();
                } catch (IOException e1) {
                    e1.printStackTrace ();
                }
            }
        }
    } );
        thread2.start();
}
}
