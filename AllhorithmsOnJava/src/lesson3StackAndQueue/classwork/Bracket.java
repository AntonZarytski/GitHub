package lesson3StackAndQueue.classwork;

public class Bracket {

    private static void error(char ch, int i){
        System.out.println("Error: " + ch + "at: " + i);
    }

    public static boolean check(String input){
        int size = input.length();
        Stack st = new Stack(size);

        for (int i = 0; i < size; i++) {
            char ch = input.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(' || ch == '<'){
                st.push(ch);
            }else if (ch == '}' || ch == ']' || ch == ')' || ch == '>'){
                if (st.isEmpty()){
                    error(ch, i);
                    break;
                }
                char c = st.peek();
                if ((ch == '}' && c == '{') ||
                        (ch == ']' && c == '[') ||
                        (ch == ')' && c == '(') ||
                        (ch == '>' && c == '<')){
                    st.pop();
                    return true;
                }
            }
        }
        if (!st.isEmpty()) {
            error(st.peek(), size - 1);
            return false;
        }
        return false;
    }
}
