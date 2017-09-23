import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<String, ArrayList <Integer>> phoneBook = new HashMap<>();
    int index = 0;
    public void add(String surname, Integer number) {
        if (!phoneBook.containsKey(surname)) {
            phoneBook.put(surname, new ArrayList<>());
        }
        phoneBook.get(surname).add(number);
    }
    public void get(String surname){
        if (phoneBook.containsKey(surname)){
            System.out.println("Номер(а) абонента под фамилией: "+ surname + ": " + phoneBook.get(surname));
        }
    }
}
