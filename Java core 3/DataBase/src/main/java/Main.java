import java.sql.*;
import java.util.Scanner;


public class Main {

    static Connection connection;// интерфейс отвечающий за подкдючение к БД
    static Statement stmt;//позволяет осылать в бд запросы
    static ResultSet rs;
    public static void main(String[] args)  {
        try {
            MyDataBase products = new MyDataBase ();
            System.out.println ("База данных создана");
        } catch (SQLException e) {
            System.out.println ("Не удалось создать базу данных");
            e.printStackTrace ();
        }
        new Thread (()->{
            Scanner sc = new Scanner (System.in);
            while(true){
            String cmd = sc.nextLine ();
                if (cmd.equalsIgnoreCase ("end")){
                    MyDataBase.disconect ();
                    break;
                }
            if (cmd.startsWith ( "/цена" )) {
                String elements[] = cmd.split ( " " );
                MyDataBase.seeCoast ( elements[1] );
            }
            }
        } ).start ();

    }

}
