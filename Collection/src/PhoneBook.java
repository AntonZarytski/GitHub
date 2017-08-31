import java.util.ArrayList;

public class PhoneBook {
    ArrayList<Object>surname=new ArrayList <> (  );
    ArrayList<Object>number=new ArrayList<>();

    int index = 0;

    public void add(String surname, int number) {
        if(this.surname.contains(surname)){
            Object number1 = this.number.remove(this.surname.indexOf(surname));
            index--;
            this.number.add(this.surname.indexOf(surname),number1 + " " + number);
        }else {
            this.surname.add(index, surname);
            this.number.add(index, number);
            index++;
        }
    }

    public void get(String surname) {
        if (this.surname.contains(surname)){
            System.out.println("Номер(а) абонента под фамилией: " + this.surname.get(this.surname.indexOf(surname)) + ": " + this.number.get(this.surname.indexOf(surname)));
        }else {
            System.out.println ("Номера абонента с фамилией "+ surname + " не существует.");
        }
    }
}

