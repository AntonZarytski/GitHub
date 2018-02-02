package lesson5Recursia.homework.taskAboutBackpack;

import java.io.Serializable;

public class Thing implements Serializable{
    int weight;
    int cost;

    public Thing(int weight, int cost) {
        this.weight = weight;
        this.cost = cost;
    }
    @Override
    public String toString(){
        return "weight = "+ weight + " cost =" + cost+", ";
    }
}
