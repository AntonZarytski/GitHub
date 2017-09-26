package ThirdTask;

public class MainThirdTask {
    public static void main(String[] args) {
        Box<Apple> box = new Box ();
        for ( int i = 0; i<11; i++ ){ box.putToBox ( new Apple () ); }
        Box<Apple> box2 = new Box <> ();
        box2.putToBox ( new Apple () );
        System.out.println (box.getWeight () + " " + box2.getWeight ());
        System.out.println (box.compare ( box2 ));
        box.peeperToAnotherBox ( box2 );
        System.out.println (box2.getWeight () +" "+box.getWeight ());
        Box<Orange>box3 = new Box <> ();
        for ( int i = 0; i<8; i++ ){ box3.putToBox ( new Orange () ); }
        System.out.println (box3.getWeight ());
        System.out.println (box2.compare ( box3 ));
    }
}
