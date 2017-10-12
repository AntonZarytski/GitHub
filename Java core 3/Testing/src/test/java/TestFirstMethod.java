import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFirstMethod{

    TestingArray ta;
    @Before
    public void create(){
        ta=new TestingArray ();
    }
    @Test
    public void test1(){
        Integer[] a = {1,5,3,6};
        Integer[] b = {5,76,4,6,4,1,5,3,6};
        Assert.assertArrayEquals ( a, ta.newArr ( b ));
    }
    @Test
    public void test2(){
        Integer[] a = {5,6,6,8};
        Integer[] b = {5,76,47,43,4,5,6,6,8};
        Assert.assertArrayEquals ( a, ta.newArr ( b ));
    }
    @Test(expected = RuntimeException.class)
    public void test3(){
        Integer[] b = {5,76,47,43,5,6,6,8};
        ta.newArr ( b );
    }
    @Test(expected = NullPointerException.class)
    public void test4(){
        Integer[] b = {};
        ta.newArr ( b );
    }
    @Test(expected = NullPointerException.class)
    public void test5(){
        Integer[] b = new Integer[20];
        ta.newArr ( b );
    }
}