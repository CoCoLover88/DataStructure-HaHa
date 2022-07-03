package com.company.stack;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.list();

        System.out.println(stack.pop());
    }
}

class LinkedListStack {
    private StackNode top;

    public LinkedListStack() {
        top = null;
    }

    //入栈
    public void push(int value) {
        StackNode node = new StackNode(value);
        node.next = top;
        top = node;
    }

    //出栈
    public int pop() {
        if (top == null) {
            throw new RuntimeException("stack empty");
        }
        int value = top.value;
        top = top.next;
        return value;
    }

    //遍历栈
    public void list() {
        StackNode tempNode=top;
        while (tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }

}

class StackNode {
    int value;
    StackNode next;

    StackNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "value=" + value +
                '}';
    }
}
