package com.company.stack;

//栈实现算式计算
public class Calculator {
    public static void main(String[] args) {
        ArrayStackC numStack = new ArrayStackC(10);
        ArrayStackC opStack = new ArrayStackC(10);
        String expression = "3-2*6-2";
        char ch = ' ';
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        char op = ' ';
        int res = 0;
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            /*ch为数字*/
            if (!isOp(ch)) {
                numStack.push(ch - 48);
            } else {
                /*ch为符号*/
                if (opStack.isEmpty()) {
                    opStack.push(ch);
                } else {
                    if (priority(ch) <= priority((char) opStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        op = (char) opStack.pop();
                        res = cal(num1, num2, op);
                        numStack.push(res);
                        opStack.push(ch);
                    } else {
                        opStack.push(ch);
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        while (true) {
            if (opStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            op = (char) opStack.pop();
            res = cal(num1, num2, op);
            numStack.push(res);
        }
        System.out.println("计算结果为：" + numStack.pop());
    }

    //判断操作符优先级
    public static int priority(char op) {
        if (op == '*' || op == '/') {
            return 1;
        } else if (op == '+' || op == '-') {
            return 0;
        } else {
            System.out.println("计算符错误");
            return -1;
        }
    }


    //判断是否为操作符
    public static boolean isOp(char ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

    //计算
    public static int cal(int num1, int num2, char op) {
        int res = 0;
        switch (op) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}

class ArrayStackC {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    ArrayStackC(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return maxSize - 1 == top;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /*查看栈顶元素*/
    public int peek() {
        return stack[top];
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
