import java.sql.*;



public class Main {

    static Connection connection;// интерфейс отвечающий за подкдючение к БД
    static Statement stmt;//позволяет осылать в бд запросы
    public static void main(String[] args) {
        try {
            connect ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS 'products' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'prodid' INTEGER NOT NULL, 'title' TEXT NOT NULL, 'coast' INTEGER);");
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        //"create table if not exists 'Products'('id' integer primary key autoincrement not null, 'prodid' integer not null, 'tittle' text not null, 'cost' integer not null);")
        disconect ();
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
