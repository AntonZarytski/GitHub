
public class MainClass {
    public static final int CARS_COUNT = 20;
    static Car[] cars;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            Car.getReadies ().await ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            Car.getFinished ().await ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println ("Победил: " + getWiner ());
    }
    public static String getWiner(){
        String winer=null;
        for ( int i = 0 ; i < cars.length  ; i++ ) {
            if (cars[i].getPosition ()==1) {
                winer = cars[ i ].getName ();
                return winer;
            }
        }
        return null;
    }
}
