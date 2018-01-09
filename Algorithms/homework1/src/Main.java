public class Main {
    public static void main(String[] args) {
        int i = 201234;
        double j = 245604.29465756756;
        String s = String.format("уровень %,d из %,.2f", i, j );
        System.out.println(s);

        String g = String.format("%, d", i);
        System.out.println(g);
    }
}
