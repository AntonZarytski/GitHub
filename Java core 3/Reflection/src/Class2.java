public class Class2 {
    @BeforeSuite
    public void preparing(){
        System.out.println ("Test is preparing to run in class2");
    }

    @Test(priority = 7)
    public void testing1(){
        System.out.println ("The first class2`s method is tested");
    }

    @Test
    public void testing2(){
        System.out.println ("The second class2`s method is tested");
    }

    @Test(priority = 3)
    public void testing3(){
        System.out.println ("The third class2`s method is tested");
    }

    @AfterSuite
    public void finishing(){
        System.out.println ("Class2 testing is complited");
    }
}
