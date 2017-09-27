import java.sql.*;
import java.util.Scanner;


public class Main {

    static Connection connection;// интерфейс отвечающий за подкдючение к БД
    static Statement stmt;//позволяет осылать в бд запросы
    static ResultSet rs;
    public static void main(String[] args)  {
        try {
            MyDataBase products = new MyDataBase ();
        } catch (SQLException e) {
            System.out.println ("Не удалось создать базу данных");
            e.printStackTrace ();
        }
        new Thread (()->{
            Scanner sc = new Scanner (System.in);
            while(true) {
                String cmd = sc.nextLine ();
                //MyDataBase.getCoast ( cmd );
                if (cmd.equalsIgnoreCase ( "end" )) {
                    MyDataBase.disconect ();
                    break;
                }
                if (cmd.startsWith ( "/цена" )) {
                    String elements[] = cmd.split ( " " );
                    MyDataBase.getCost ( elements[ 1 ] );
                }
                if (cmd.startsWith ( "/сменитьцену" )) {
                    String elements[] = cmd.split ( " " );
                    int el = Integer.parseInt ( elements[ 2 ] );
                    MyDataBase.changeCost ( elements[ 1 ], el );
                }
                if (cmd.startsWith ( "/товарыпоцене" )) {
                    String elements[] = cmd.split ( " " );
                    int from = Integer.parseInt ( elements[1]);
                    int to = Integer.parseInt ( elements[2]);
                    MyDataBase.sortByPrice ( from,to );
                }
            }
        } ).start ();

    }

}
