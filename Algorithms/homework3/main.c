#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define maxN 1000
void printArray(int arr[]);
int boubleSort(int arr[]);
int boubleSortMod(int arr[]);
int shakerSort(int arr[]);
int binarySearch(int arr[], int vol);
// Зарицкий Антон
int main() {

    srand(time(NULL));
    int arr[maxN];
    FILE *in, *out;
   // in = fopen("data.txt", "w");
    out = fopen("data.txt", "r");
  //  for (int i = 0; i <maxN ; ++i) {
   //     arr[i] = rand()%1000;
     //   fprintf(in,"%d\n",arr[i]);
   // }
    for (int i = 0; i <maxN ; ++i) {
        if(fscanf(out, "%d", &arr[i]) == EOF) break;
    }
    fclose(out);
    puts("array before sort");
    printArray(arr);
    puts("");
    // вопрос, правильно ли сделана шекерная сортировка, почему колличество операций при шекерной и пузырьковой сортьировкой одинаково
    //задание №1
    //printf("count of operations on boubleSort = %d ", boubleSort(arr) );// 1248894
    //printf("count of operations on boubleSortMod = %d ", boubleSortMod(arr) );//749394
    //задание №2
    printf("count of operations on shakerSort = %d ", shakerSort(arr) );//1248894
    puts("");
    printArray(arr);
    //задание №3
    puts("Enter number fo search");
    int val;
    scanf("%d", &val);
    if(binarySearch(arr, val)==-1)
        puts("number is not found");
    else printf("index of %d == %d", val, binarySearch(arr, val));
    return 0;
}
void swap (int *x, int *y){
    int z = *x;
    *x = *y;
    *y = z;
}
void printArray(int arr[]){
   // int size = sizeof(arr)/sizeof(int);
    for(int i = 0; i<maxN; i++){
        printf("%d ", arr[i]);
        if(i%30==0)
            printf("\n");
    }
}
int boubleSort(int arr[]){
    int count = 0;
   // int size = sizeof(arr)/sizeof(int);
    for (int i = 0; i<maxN; ++i) {
        for (int j = 0; j <maxN - 1 ; ++j) {
            count++;
            if(arr[j] > arr[j + 1]){
                count++;
                swap(&arr[j], &arr[j+1]);
            }
        }
    }
    return count;
}

int boubleSortMod(int arr[]){
    int count = 0;
    int a = 1;
    int cache;
    for (int i = 0; i <maxN ; i++) {
        for (int j = 0; j <maxN-a ; j++) {
            count++;
            if(arr[j]>arr[j+1]){
                count++;
                swap(&arr[j], &arr[j+1]);
            }
        }
        a++;
    }
    return count;
}

int shakerSort(int arr[]){
    int count = 0;
    int a = 1;
    for (int i = 0; i <maxN ; i++) {
        for (int j = 0; j <maxN-a; j++) {
            count++;
            if(arr[j]>arr[j+1]){
                count++;
                swap(&arr[j], &arr[j+1]);

            }
        }
        for (int j = maxN-a; j >0  ; j--) {
            count++;
            if(arr[j]<arr[j-1]){
                count++;
                swap(&arr[j], &arr[j-1]);
            }
        }
        a++;
    }
    return count;
}
int binarySearch(int arr[], int val){
    int L = 0, R=maxN-1;
    int m = L + (R-L)/2;
    while(L<=R && arr[m] != val){
        if(arr[m]<val)
            L = m + 1;
        else
            R = m - 1;
        m = L + (R-L)/2;

    }
    if(arr[m] == val)
        return m;
    else
        return -1;
}



