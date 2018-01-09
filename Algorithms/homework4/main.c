#include <stdio.h>
#include "searchPointForQueen.h"
#define N 8
#define M 8

void print2(int n, int m, int a[K][M]){
int i, j;
for(i = 0; i < n; i++){
    for (int j = 0; j < m ; j++) {
        printf("%5d", a[i][j]);
    }
    printf("\n");
}
}
int main() {
    int A[K][M];
    for (int j = 0; j < M ; ++j) {
        A[0][j] = 1;
    }
    for (int i = 1; i < K; ++i) {
        A[i][0] = 1;
        for (int j = 1; j < M; ++j)
            A[i][j] = A[i][j-1] + A[i - 1][j];
    }
    print2(K, M, A);
    searchPoint();
    return 0;
}