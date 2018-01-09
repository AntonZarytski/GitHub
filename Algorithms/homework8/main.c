#include <stdio.h>
#include <malloc.h>

void quickSort(int *s_arr, int first, int last);
void countSort(int *array, int n, int min, int max);
int* mergeSort(int *up, int *down, unsigned int left, unsigned int right);

int main() {
    //Задача 1
    int a[] = {10, 0, 75, 43, 15, 25, 2, 27, 43};
    quickSort(a, 0, 8);
    for (int i = 0; i < 9 ; ++i) {
        printf("%d ", a[i]);
    }

    puts("");
    //Задача 2
    int b[] = {10, 0, 75, 43, 15, 25, 2, 27, 43};
    countSort(b, 9, 0, 75);
    for (int i = 0; i < 9 ; i++) {
        printf("%d ", b[i]);
    }

    puts("");
    //Задача 3
    int c[] = {10, 0, 75, 43, 15, 25, 2, 27, 43};
    mergeSort(c,b, 0, 8);
    for (int i = 0; i < 9 ; i++) {
        printf("%d ", b[i]);
    }
    return 0;
}

void quickSort(int *s_arr, int first, int last)
{
    if (first < last)
    {
        int left = first, right = last, middle = s_arr[(left + right) / 2];
        do
        {
            while (s_arr[left] < middle) left++;
            while (s_arr[right] > middle) right--;
            if (left <= right)
            {
                int tmp = s_arr[left];
                s_arr[left] = s_arr[right];
                s_arr[right] = tmp;
                left++;
                right--;
            }
        } while (left <= right);
        quickSort(s_arr, first, right);
        quickSort(s_arr, left, last);
    }
}

void swap(int *x, int *y){
    *x ^= *y;
    *y ^= *x;
    *x ^= *y;
}
void countSort(int *array, int n, int min, int max)
{
    int i, j, z;

    int range = max - min + 1;
    int *count = malloc(range * sizeof(*array));

    for(i = 0; i < range; i++) count[i] = 0;
    for(i = 0; i < n; i++) count[ array[i] - min ]++;

    for(i = min, z = 0; i <= max; i++) {
        for(j = 0; j < count[i - min]; j++) {
            array[z++] = i;
        }
    }

    free(count);
}

int* mergeSort(int *up, int *down, unsigned int left, unsigned int right) {

    if (left == right) {
        down[left] = up[left];
        return down;
    }

    unsigned int middle = (left + right) / 2;

    int *l_buff = mergeSort(up, down, left, middle);
    int *r_buff = mergeSort(up, down, middle + 1, right);

    // слияние двух половин
    int *target = l_buff == up ? down : up;

    unsigned int width = right - left, l_cur = left, r_cur = middle + 1;
    for (unsigned int i = left; i <= right; i++) {
        if (l_cur <= middle && r_cur <= right) {
            if (l_buff[l_cur] < r_buff[r_cur]) {
                target[i] = l_buff[l_cur];
                l_cur++;
            }else{
                target[i] = r_buff[r_cur];
                r_cur++;
            }
        }else if (l_cur <= middle){
            target[i] = l_buff[l_cur];
            l_cur++;
        }else{
            target[i] = r_buff[r_cur];
            r_cur++;
        }
    }
    return target;
}