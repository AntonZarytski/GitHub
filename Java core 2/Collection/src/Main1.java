
public class Main1 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook ();
        phoneBook.add ( "Зарицкий", 5939795 );
        phoneBook.add ( "Махонь", 2168033 );
        phoneBook.add ( "Пушкин", 4545434 );
        phoneBook.add ( "Иванов", 14849122 );
        phoneBook.add ("Сидоров", 56465465);
        phoneBook.add ( "Дудник", 4711904 );
        phoneBook.add ( "Иванов", 2345789 );
        phoneBook.add ( "Титов", 2975454 );
        phoneBook.add ( "Сидоров", 4717461 );
        phoneBook.add ( "Иванов", 1117892 );

        phoneBook.get ( "Зарицкий" );
        phoneBook.get ("Пупкин");
        phoneBook.get ("Иванов");
        phoneBook.get("Сидоров");
        phoneBook.get("Титов");
    }
}
