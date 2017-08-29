import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String words[]= new String[12];
        for (int i=0;i<words.length; i++){
            words[i]="word" + Integer.toString ( i );
            System.out.println (words[i]);
        }
        words[1]="word";
        words[4]="word";
        words[7]="word";
        words[8]="word";
        words[10]="word";

        HashSet<String> hsWords = new HashSet<String> (12  );
        for(String w:words){
            hsWords.add(w);
        }
        System.out.println ("Уникальные слова: " + hsWords + " колличество уникальных слов: " + hsWords.size () );

    }

}
