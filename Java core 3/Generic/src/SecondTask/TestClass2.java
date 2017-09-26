package SecondTask;

import java.util.ArrayList;

public class TestClass2<T extends Object> {
    private T[] obj;

    public TestClass2(T[] obj) {
        this.obj = obj;
    }

    public T[] getObj() {
        return obj;
    }

    public void setObj(T[] obj) {
        this.obj = obj;
    }
    void copyArraytoArrayList (T[] o, ArrayList <T> a){
        for(int i = 0; i<o.length; i++){
            a.add ( o[i] );
        }
    }
}
