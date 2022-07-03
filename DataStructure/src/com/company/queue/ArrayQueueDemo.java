package com.company.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.showQueue();
    }
}

class ArrayQueue {
    private int maxSize;
    private int rear;
    private int front;
    private int[] array;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        rear = -1;
        front = -1;
        array = new int[this.maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    /*添加数据到队列*/
    public void enQueue(int n) {
        if (isFull()) {
            System.out.println("queue is Full");
            return;
        }
        rear++;
        array[rear] = n;
    }

    /*出队*/
    public int outQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            System.exit(-1);
        }
        front++;
        return array[front];
    }

    /*显示队列*/
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            System.exit(-1);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n", i, array[i]);
        }
    }

    /*获取队列头元素*/
    public int getHead() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            System.exit(-1);
        }
        return array[front + 1];
    }
}
