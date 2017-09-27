import java.sql.*;

public class MyDataBase {
    static Connection connection;// интерфейс отвечающий за подкдючение к БД
    static Statement stmt;//позволяет осылать в бд запросы
    static ResultSet rs;
    static PreparedStatement ps;
    public MyDataBase()throws SQLException {
        try {
            connect ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        stmt.execute ( "DELETE FROM 'products'" );
        stmt.execute("CREATE TABLE IF NOT EXISTS 'products' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'prodid' TEXT NOT NULL, 'title' TEXT NOT NULL, 'coast' INTEGER);");

        connection.setAutoCommit ( false );
        for (int i = 1; i<=10000; i++){
            stmt.executeUpdate("INSERT INTO 'products'('prodid', 'title', 'coast') VALUES ('товар"+i+"', 'товар"+i+"','"+i*10+"');" );
        }
        connection.commit ();
        connection.setAutoCommit ( true );
        System.out.println ("База данных создана");
    }
    public static void getCost(String product){
        int с;
        try {
            //rs = stmt.executeQuery ( "SELECT coast FROM products WHERE title='"+product+"'");
            ps = connection.prepareStatement ("SELECT coast FROM products WHERE title=?");
            ps.setString ( 1, product );
            rs = ps.executeQuery ();
            do{
                if (rs.next ()) {
                    с = rs.getInt ( 1 );
                    System.out.println ( "Цена товара " + product + " " + с + "." );
                } else {
                    System.out.println ( "Такого товара не обнаружено." );
                    break;
                }
            }while (false);
        } catch (SQLException e) {
            e.printStackTrace ();
        }

    }
    public static void changeCost(String product, int newPrice){
        try {
            ps = connection.prepareStatement ( "UPDATE products SET coast = ? WHERE title = ?");
            ps.setInt ( 1,newPrice );
            ps.setString ( 2,product );
            ps.executeUpdate ();
            getCost ( product );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
    public static void sortByPrice(int fromPrice, int toPrice){
        try {
            ps = connection.prepareStatement ( "SELECT * FROM products WHERE coast>?");
            ps.setInt ( 1,fromPrice );
            ps.executeQuery ();
            ps = connection.prepareStatement ( "SELECT * FROM products WHERE coast<?");
            ps.setInt ( 1,toPrice );
            rs = ps.executeQuery ();
            System.out.println ("Список товаров в диапазоне стоимости от " + fromPrice + " до " + toPrice+":");
            while (rs.next ()) {
                System.out.println (rs.getString ( 3 )+" стоимостью " +rs.getInt ( 4 ));
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
