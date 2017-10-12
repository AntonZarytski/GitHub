import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith ( Parameterized.class )
public class TestSecondMethod {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList (new Object[][]{
// Александр расскажите пожалуйста в каких случаях мы будим передавать сюда др параемтры
                {new int[]{1, 3, 4, 5, 1}, false},
                {new int[]{1, 1, 4, 1, 1}, true},
                {new int[]{1, 1, 4, 1, 1}, true},
                {new int[]{1, 1, 1, 1, 1}, false},
                {new int[]{4, 4, 4, 4, 4}, false},
        });
    }
    private int[] a;
    private boolean b;

    public TestSecondMethod(int[] a, boolean b){
        this.a = a;
        this.b = b;
    }
    TestingArray ta;

    @Before
    public void create(){
        ta = new TestingArray ();
    }
    @Test
    public void test(){
        Assert.assertEquals (b, ta.testArr ( a ));
    }
}
