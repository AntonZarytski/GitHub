package com.company;

public class Main {
 static int count = 0;
 static int solutionCount = 0;
 static int binNumber[] = new int[100];

    public static void main(String[] args) {
        //Зарицкий Антон
        //Задача 3*
        System.out.println("минимум " + getNum(3,20) + " шагов");
        System.out.println("минимум " + getSolution(3, 20) + " путей");
        // Задача 2 степень с рекурсией почемуто не получилась
        powNumWitoutRec(7,6);
        //  System.out.println(powNumWithRec(7,6));
        // Задача 1
        toBinSystem(16);
        printBinNumber(binNumber);

    }

      static int getNum(int from, int to){
        from++;
        count++;
        if(from!=to && from<to){
            getNum(from*3,to);
            }
    return count;
    }

    static int getSolution(int from, int to){
        while(from<to){
            if(from*2 <= to){
            if(from*2==to){
            solutionCount++;
            }
            getSolution(from*2, to);
            }
        from++;
        if(from==to)solutionCount++;
        }
    return solutionCount;
    }
static void powNumWitoutRec(int a, int b){
        int cache = a;
        if(b==0){
            System.out.println(1);
            return;
        }
        for(int i = 1; i<b; i++  ){
            a=a*cache;
            }
        System.out.println(a);
}

/*static int powNumWithRec(int a, int b){
        powNumWithRec(a, b-1);
        int cache = a;
          a=a*cache;
        return  a;
}*/
static int[] toBinSystem(int num){
        int i = 0;
        int size = 0;
        if(num>0){
            binNumber[i++] = num%2;
            num/=2;
            toBinSystem(num);
        }
       return binNumber;
}
static void printBinNumber(int[] binNum){
    boolean print= false;
    for(int i = binNum.length-1; i>0; i--){
        if(binNum[i]==1){
            print = true;
        }
        if(print)
            System.out.print(binNum[i]);
    }
}
}

