package com.company.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(7);
        stack.push(6);
        stack.push(9);

        System.out.println(stack.pop());
        System.out.println();


        stack.list();
    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return maxSize - 1 == top;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
