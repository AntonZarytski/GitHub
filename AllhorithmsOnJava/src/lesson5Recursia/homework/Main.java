package lesson5Recursia.homework;

import lesson5Recursia.homework.taskAboutBackpack.BackPack;
import lesson5Recursia.homework.taskAboutBackpack.Thing;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*int x = povRec(4,5);
        System.out.println(x);*/
        BackPack backPack = new BackPack(40);
        Thing[] things = new Thing[100];
        //fillAndWriteArray(things);
        things = readArray();
        System.out.println(Arrays.toString(things));
        ArrayList<Thing> thingsList = new ArrayList<>(Arrays.asList(things));
        backPack.cooseTheCostestThings(thingsList);
        System.out.println(backPack.toString());
        System.out.println("Суммарная стоимость " + backPack.getTotalCost());
        System.out.println("Суммарный вес " + backPack.getCurrentWeight());

    }

    private static Thing[] readArray() throws IOException, ClassNotFoundException {
        Thing[] things;ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Array.txt"));
        things = (Thing[])ois.readObject();
        ois.close();
        return things;
    }

    private static void fillAndWriteArray(Thing[] things) throws IOException {
        for (int i = 0; i <things.length ; i++) {
            things[i] = new Thing((int)Math.round(1+Math.random()*10), (int)Math.round(Math.random()*50));
        }
        File array = new File("Array.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(array));
        oos.writeObject(things);
        oos.close();
    }

    private static int povRec(int x, int n){
        if (n==0)
            return 1;
        if (n==1)
            return x;
        return x*povRec(x,n-1);
    }
}
