package ThirdTask;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> box;

    public Box() {
        this.box = new ArrayList <> (  );
    }

    void putToBox(T f){
        box.add ( f );
    }

    float getWeight(){
        if(!box.isEmpty ()) {
            float f = box.get ( 0 ).mass;
            return box.size () * f;
        }
        return 0;
    }
    boolean compare(Box<? extends T> box){
        if (getWeight ()==box.getWeight ())
            return true;
        return false;
    }
    void peeperToAnotherBox( Box<? super T> peeperBox){
        peeperBox.box.addAll ( box );
        box.clear ();
    }
}
