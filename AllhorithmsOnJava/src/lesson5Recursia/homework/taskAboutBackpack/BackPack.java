package lesson5Recursia.homework.taskAboutBackpack;

import java.util.ArrayList;

public class BackPack {
    private ArrayList<Thing> things;
    private int maxWeight;
    private int countOfThings;

    public BackPack(int maxWeight) {
        this.things = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public int getCurrentWeight() {
        int summ = 0;
        for (int i = 0; i < things.size(); i++) {
            summ = summ + things.get(i).weight;
        }
        return summ;
    }

    public int getTotalCost() {
        int summ = 0;
        for (int i = 0; i < things.size(); i++) {
            summ = summ + things.get(i).cost;
        }
        return summ;
    }

    public boolean addThing(Thing thing) {
        if (thing != null) {
            if (checkWeight(thing)) {
                things.add(thing);
                countOfThings++;
                return true;
            } else return false;
        } else return false;
    }

    public boolean checkWeight(Thing thing) {
        if (thing != null)
            return getCurrentWeight() + thing.weight < maxWeight;
        else return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BackPack : ");
        for (int i = 0; i < things.size(); i++) {
            sb.append(things.get(i).toString());
        }
        return sb.toString();
    }

    public void cooseTheCostestThings(ArrayList<Thing> things) {
        if (getCurrentWeight() < maxWeight) {
            //если текущий самый дорогой предмет не помещается
            if (!checkWeight(findCostestThin(things))) {
                if (things.size() != 0) {
                    //удаляем все элементы у которого вес больше минимально вмесщаемого
                    int filter = maxWeight - getCurrentWeight();
                    deleteThingsFromWeight(things, filter);
                }
            }
            if (things.size() != 0) {
                addThing(findCostestThin(things));
                cooseTheCostestThings(things);
            }
        }
    }

    private Thing findCostestThin(ArrayList<Thing> things) {
        if (things.size() != 0) {
            Thing theCostestThing = things.get(0);
            int maxCost = 0;
            int i;
            int index = 0;
            for (i = 0; i < things.size(); i++) {
                if (things.get(i).cost > maxCost) {
                    maxCost = things.get(i).cost;
                    //сохраняем самую дорогую вещь
                    theCostestThing = things.get(i);
                    index = i;
                }
                // удаляем что бы исключить ее из расчета
            }
            things.remove(index);
            things.trimToSize();
            return theCostestThing;
        } else return null;
    }

    private void deleteThingsFromWeight(ArrayList<Thing> things, int weight) {
        things.removeIf(x -> x.weight > weight);
        things.trimToSize();
    }
}
