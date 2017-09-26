package FirstTask;

public class TestClass<T> {
    private T[] obj;
    public TestClass(T[] o){
        obj = o;
    }

    public T[] getObj() {
        return obj;
    }

    public void setObj(T[] obj) {
        this.obj = obj;
    }
    void changeElements(T[] o, int firstIndex, int secondIndex){
        T a = o[firstIndex];
        o[firstIndex] = o[secondIndex];
        o[secondIndex] = a;
    }
}
