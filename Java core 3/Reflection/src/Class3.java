public class Class3 {
    @BeforeSuite
    public void preparing(){
        System.out.println ("Test is preparing to run in class3");
    }
   /* @BeforeSuite
    public void preparing1(){
        System.out.println ("Test is preparing111 to run in class3");
    }*/

    @Test(priority = 7)
    public void testing1(){
        System.out.println ("The first class3`s method is tested");
    }

    @Test(priority = 5)
    public void testing2(){
        System.out.println ("The second class3`s method is tested");
    }

    @Test(priority = 3)
    public void testing3(){
        System.out.println ("The third class3`s method is tested");
    }

    @AfterSuite
    public void finishing(){
        System.out.println ("Class3 testing is complited");
    }
}
