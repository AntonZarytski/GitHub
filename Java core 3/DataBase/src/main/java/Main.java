import java.sql.*;
import java.util.Scanner;


public class Main {


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
                if (cmd.startsWith ( "/" )) {
                    if (cmd.equalsIgnoreCase ( "/end" )) {
                        MyDataBase.disconect ();
                        break;
                    } else if (cmd.startsWith ( "/цена" )) {
                        String elements[] = cmd.split ( " " );
                        MyDataBase.getCost ( elements[ 1 ] );
                    } else if (cmd.startsWith ( "/сменитьцену" )) {
                        String elements[] = cmd.split ( " " );
                        int el = Integer.parseInt ( elements[ 2 ] );
                        MyDataBase.changeCost ( elements[ 1 ], el );
                    } else if (cmd.startsWith ( "/товарыпоцене" )) {
                        String elements[] = cmd.split ( " " );
                        int from = Integer.parseInt ( elements[ 1 ] );
                        int to = Integer.parseInt ( elements[ 2 ] );
                        if (from<to) MyDataBase.sortByPrice ( from, to );
                        else MyDataBase.sortByPrice ( to,from );
                    }
                }else System.out.println ("Введенная команда не корректна");
            }
        } ).start ();

    }

}
