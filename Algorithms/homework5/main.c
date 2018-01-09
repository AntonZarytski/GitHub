#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <locale.h>
// реализация стека
typedef struct stack {
    int value;
    struct stack * next;
} node_t, stack_t;

int is_empty(stack_t ** top) {
    return *top == NULL;
}

void push(stack_t ** top, int value) {
    node_t *node = (node_t *)malloc(sizeof(node_t));

    node->value = value;
    node->next = NULL;

    if(!is_empty(top))
        node->next = *top;
    (*top) = node;
}

char pop(stack_t **top) {
    node_t *node;
    char cache;
    if(!is_empty(top)) {
        node = *top;
        cache = node->value;
        *top = (*top)->next;
        free(node);
        node = NULL;
        return cache;
    }
}

void print(stack_t **top) {
    node_t *node;
    for(node = *top; node != NULL; node = node->next)
        printf("%c ", node->value);
    printf("\b\b\b   \n");
}

// задание 5 реализация очереди

typedef struct queue {
    int a[1000];
    int head;    //Индекс первого элемента.
    int tail;    //Индекс элемента, следующего за последним.

    void push(int x) {
        a[tail] = x;
        tail++;
    }

    int pop() {
        if (head != tail) {
            head++;
            return a[head - 1];
        } else {
            puts("Ошибка извлечения");
        }
    }
    int is_empty() {
        if (head == tail)
            return 1;
        else return 0;
    }
};

void checkBkt(char arr[], stack_t **top){
    char cache;
    for (int i = 0; i < sizeof(arr) ; ++i) {
        if(arr[i]==")" || arr[i]=="}" || arr[i]=="]" || arr[i]==">"){
            cache = pop(&top);
            if(cache == ")" && arr[i+1] !=")" || arr[i+1]!="}" || arr[i+1]!="]" || arr[i+1]!=">" ){
                if(pop(&top) == "(")
                    continue;
            }
            if(cache == "}" && arr[i+1] !=")" || arr[i+1]!="}" || arr[i+1]!="]" || arr[i+1]!=">" ){
                if(pop(&top) == "{")
                    continue;
            }
            if(cache == "]" && arr[i+1] !=")" || arr[i+1]!="}" || arr[i+1]!="]" || arr[i+1]!=">" ){
                if(pop(&top) == "[")
                    continue;
            }
            if(cache == ">" && arr[i+1] !=")" || arr[i+1]!="}" || arr[i+1]!="]" || arr[i+1]!=">" ){
                if(pop(&top) == "<")
                    continue;
            }
        } else {
            printf("invalid input \n");
            return;
        }
        printf("correct input \n");
    }
}

int main()
{
    stack_t *s = NULL; /* указатель на вершину первого стека */

    //Задача 3 Не могу проверить работы программы, т.к. стек реализован не правильно и я не смог разобраться почему(гдето теряются символы)
    //Написал алгоритм, как мне кажется, верным
    char *string = "(((({}[]))))";
    for(int i = 0; i < sizeof(string); ++i)
        push(&s, string[i]);
    checkBkt(string, s);

    printf("contents of thestack: \n");
    print (&s);

    return 0;
}


