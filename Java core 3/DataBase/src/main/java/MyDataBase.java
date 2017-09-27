import java.sql.*;
import java.util.Scanner;

public class MyDataBase {
    static Connection connection;// интерфейс отвечающий за подкдючение к БД
    static Statement stmt;//позволяет осылать в бд запросы
    static ResultSet rs;
    public MyDataBase()throws SQLException {
        try {
            connect ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        stmt.execute ( "DELETE FROM 'products'" );
        stmt.execute("CREATE TABLE IF NOT EXISTS 'products' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'prodid' TEXT NOT NULL, 'title' TEXT NOT NULL, 'coast' INTEGER);");

        connection.setAutoCommit ( false );
        int a;
        for (int i = 1; i<=10000; i++){
            a = stmt.executeUpdate("INSERT INTO 'products'('prodid', 'title', 'coast') VALUES ('товар"+i+"', 'товар"+i+"','"+i*10+"');" );
        }
        connection.setAutoCommit ( true );
    }
    public static void seeCoast(String product){
        int coast;
        try {
            //rs = stmt.executeQuery ( "SELECT 'coast' FROM 'products' WHERE tittle='"+product+"');");
            rs = stmt.executeQuery ( "SELECT 'coast' FROM 'products' WHERE 'tittle'='"+product+"'");
            while (rs.next ()) {
                coast = rs.getInt ( 1 );
                System.out.println ( "Цена товара " + product + " " + coast );
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

    }
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName ( "org.sqlite.JDBC" );// подгружаем класс по его имени
        // регистрация драйвера
        connection = DriverManager.getConnection ( "jdbc:sqlite:products.db" );// в конце можно через запятую добавить логин\пароль
        stmt = connection.createStatement ();
        System.out.println ("Подключено к БД");
    }
    public static void disconect(){
        try {
            connection.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
