package lesson2Arrays.homework;

public class Main {
    public static void main(String[] args) {
        //1000000 элементов даже не смог дождаться за час поэтому только 100к
        //Почему то сортировка выбором больше всего времени тянет
        //Пузырьковая сортировка 2.508911807E9 операций за 59004 милисекунд
        //Сортировка вставками 7.513437509E9 операций за 14717 милисекунд
        //Сортировка выбором  3391238.0 операций за 152667 милисекунд
        Array array = new Array(100000);

        for (int i = 0; i < 100000; i++) {
            array.insert((int) Math.round(Math.random() * 100000));
        }
        array.bubbleSort();
        for (int i = 0; i <100000; i++) {
            array.insert((int)Math.round(Math.random()*100000));
        }
        array.insertSort();
        for (int i = 0; i <100000; i++) {
            array.insert((int)Math.round(Math.random()*100000));
        }

        array.selectSort();
    }
}
