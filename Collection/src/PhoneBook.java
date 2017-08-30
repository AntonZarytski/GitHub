import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PhoneBook {
    ArrayList<Object>key=new ArrayList <> (  );
    HashMap <Object, Integer> phoneBook = new HashMap <> ();

    public void add(/*HashMap <String, Integer> phoneBook,*/ String surname, int number) {
        key.add ( surname );
        System.out.println (" key.indexOf (surname) "+ surname + " "+ key.indexOf (surname));
        phoneBook.put ( key.indexOf (surname), number);
        System.out.println (phoneBook.get(key.indexOf ( surname )));

    }

    public void get(/*HashMap <String, Integer> phoneBook,*/String surname) {
        if (key.contains( surname )) {
            int i=0;
           while(i < phoneBook.size()){
              if(phoneBook.containsKey ( key.indexOf ( surname ) )&&key.get( i ).equals ( surname ))
                System.out.println ( "Номер абонента под фамилией: " + surname + ": " + phoneBook.get(i));
               i++;
               ;
           }
            System.out.println (surname + phoneBook.get(3));
            System.out.println (surname + phoneBook.get(5));
        }
    }
}

