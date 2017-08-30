import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    ArrayList<Object>key=new ArrayList <> (  );
    HashMap <Object, Integer> phoneBook = new HashMap <> ();
    int index = 0;

    public void add(/*HashMap <String, Integer> phoneBook,*/ String surname, int number) {
        key.add ( surname );
        phoneBook.put ( index, number);
        index++;
    }

    public void get(/*HashMap <String, Integer> phoneBook,*/String surname) {
        if (key.contains( surname )) {
            int i=0;
           while(i < phoneBook.size()){
              if(key.get( i ).equals ( surname ))
                System.out.println ( "Номер абонента под фамилией: " + key.get(i) + ": " + phoneBook.get(i));
               i++;
               ;
           }
        }else{
            System.out.println ("Номера абонента с фамилией "+ surname + "не существует.");
        }
    }
}

