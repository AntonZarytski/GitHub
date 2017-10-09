import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int stposition = 0;
    private int position=0;
    private static int CARS_COUNT;
    private static CountDownLatch readies = new CountDownLatch (MainClass.CARS_COUNT);
    private static CyclicBarrier readyToStart = new CyclicBarrier ( MainClass.CARS_COUNT );
    private static CountDownLatch finished = new CountDownLatch (MainClass.CARS_COUNT);

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            readies.countDown ();
            readyToStart.await ();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        finished.countDown ();
        stposition++;
        position = stposition;
    }

    public static CountDownLatch getReadies() {
        return readies;
    }

    public static CountDownLatch getFinished() {
        return finished;
    }
    public int getPosition(){
        return position;
    }
}

