import java.util.HashMap;

public class PhoneBook {
    HashMap <String, Integer> phoneBook= new HashMap <> (  );
    public PhoneBook(){
        HashMap <String, Integer> phoneBook= new HashMap <> (  );
    }

    public void add(/*HashMap <String, Integer> phoneBook,*/ String surname, int number ){
        phoneBook.put(surname,number);
    }
    public void get(/*HashMap <String, Integer> phoneBook,*/String surname) {
        if (phoneBook.containsKey ( surname )) {
            System.out.println ( "Номер абонента под фамилией: " + surname + ": " + phoneBook.get ( surname ) );
        }else{
            System.out.println ("Абонента под фамилией " + surname + " в справочнике не найдено");
        }
    }

}
