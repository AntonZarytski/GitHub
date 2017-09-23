import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String words[]= new String[12];
        for (int i=0;i<words.length; i++){
            words[i]="word" + Integer.toString ( i );
        }
        words[1]="word";
        words[4]="word";
        words[7]="word";
        words[8]="word";
        words[10]="word";
        HashMap<String, Integer> hmWords = new HashMap<>();
        for(int i = 0; i<words.length; i++ ){
            Integer frequency = hmWords.get(words[i]);
            hmWords.put(words[i], frequency == null ? 1 : frequency + 1);
        }
        System.out.println(hmWords);
        System.out.println(hmWords.get("word"));
        System.out.println ("Уникальные слова: и колличество их повторений " + hmWords + " .Колличество уникальных слов: " + hmWords.size () );
    }

}
