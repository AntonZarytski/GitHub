#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
// 1. Реализовать простейшую хэш-функцию. На вход функции подается строка, на выходе сумма кодов символов.
unsigned long
int hash(unsigned char *str) {
    unsigned int hash = 0;
    int c;

    while (c = *str++)
        hash += c;

    return hash;
}
/*
2.	Переписать программу, реализующее двоичное дерево поиска.
а) Добавить в него обход дерева различными способами;
б) Реализовать поиск в двоичном дереве поиска;
*/

typedef int T;
typedef struct Node {
    T data;
    struct Node *left;
    struct Node *right;
    struct Node *parent;
} Node;
// Распечатка двоичного дерева в виде скобочной записи
void printTree(Node *root) {
    if (root)
    {
        printf("%d", root->data);
        if (root->left || root->right)
        {
            printf("(");

            if (root->left)
                printTree(root->left);
            else
                printf("NULL");

            printf(",");

            if (root->right)
                printTree(root->right);
            else
                printf("NULL");

            printf(")");
        }
    }
}


// Создание нового узла
Node* getFreeNode(T value, Node *parent) {
    Node* tmp = (Node*) malloc(sizeof(Node));
    tmp->left = tmp->right = NULL;
    tmp->data = value;
    tmp->parent = parent;
    return tmp;
}

// Вставка узла
void insert(Node **head, int value) {
    Node *tmp = NULL;
    if (*head == NULL)
    {
        *head = getFreeNode(value, NULL);
        return;
    }

    tmp = *head;
    while (tmp)
    {
        if (value> tmp->data)
        {
            if (tmp->right)
            {
                tmp = tmp->right;
                continue;
            }
            else
            {
                tmp->right = getFreeNode(value, tmp);
                return;
            }
        }
        else if (value< tmp->data)
        {
            if (tmp->left)
            {
                tmp = tmp->left;
                continue;
            }
            else
            {
                tmp->left = getFreeNode(value, tmp);
                return;
            }
        }
        else
        {
            exit(2);// дерево построено неправильно
        }
    }
}
//a
void preOrderTravers(Node* root) {
    if (root) {
        printf("%d ", root->data);
        preOrderTravers(root->left);
        preOrderTravers(root->right);
    }
}
//a
void preOrderTraversLRRoot(Node* root) {
    if (root) {
        preOrderTraversLRRoot(root->left);
        printf("%d ", root->data);
        preOrderTraversLRRoot(root->right);
    }
}
//a
void preOrderTraversLRRight(Node* root) {
    if (root) {
        preOrderTraversLRRight(root->left);
        preOrderTraversLRRight(root->right);
        printf("%d ", root->data);
    }
}
//б
// не могу понять почему дерево строится только с одной ветвью 1(NULL,3(NULL,9(NULL,27(NULL,81(NULL,243(NULL,729))))))
int searchNum(Node* root, int num){
    if (root){
        int serch = root->data;
        if(serch > num)
        searchNum(root->right, num);
        else if (serch < num)
        searchNum(root->left, num);
        else return root->data;
    } else return -1;
}

int main() {
    // 1
    char* sting = "stringForHash";
    printf("%d", hash(sting));
    printf("\n");

    Node *Tree = NULL;
    FILE* file = fopen("data.txt", "r");
    if (file == NULL)
    {
        puts("Can't open file!");
        exit(1);
    }
    int count;
    fscanf(file, "%d", &count); // Считываем количество записей
    int i;
    for(i = 0; i < count; i++)
    {
        int value;
        fscanf(file, "%d", &value);
        insert(&Tree, value);
    }
    fclose(file);
    printTree(Tree);
    printf("\nPreOrderTravers:");
    preOrderTraversLRRoot(Tree);
    printf("%d", searchNum(Tree, 27));

    return 0;
}