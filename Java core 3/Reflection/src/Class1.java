public class Class1 {
    @BeforeSuite
    public void preparing(){
        System.out.println ("Test is preparing to run in class1");
    }

    @Test(priority = 7)
    public void testing1(){
        System.out.println ("The first class1`s method is tested");
    }

    @Test(priority = 5)
    public void testing2(){
        System.out.println ("The second class1`s method is tested");
    }

    @Test(priority = 3)
    public void testing3(){
        System.out.println ("The third class1`s method is tested");
    }

    @AfterSuite
    public void finishing(){
        System.out.println ("Class1 testing is complited");
    }
}
