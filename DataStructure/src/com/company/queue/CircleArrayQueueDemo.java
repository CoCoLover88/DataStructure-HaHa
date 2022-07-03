package com.company.queue;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        circleArrayQueue.enQueue(10);
        circleArrayQueue.enQueue(20);
        circleArrayQueue.enQueue(30);
        circleArrayQueue.showQueue();
    }
}

//环形队列
class CircleArrayQueue {
    private int maxSize;
    private int[] array;
    private int front;
    private int rear;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    /*入队*/
    public void enQueue(int n) {
        if (isFull()) {
            System.out.println("circle is full");
            System.exit(-1);
        }
        array[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /*出队*/
    public int outQueue() {
        if (isEmpty()) {
            System.out.println("circle queue is empty");
            System.exit(-1);
        }
        int temp = array[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    /*显示队列元素*/
    public void showQueue() {
        if(isEmpty()){
            System.out.println("circle queue is empty");
            System.exit(-1);
        }
        for (int i = front; i < front + size(); i++)
            System.out.printf("array[%d]=%d\n", i % maxSize, array[i%maxSize]);
    }


    /*获取头元素*/
    public int getHead() {
        if(isEmpty()){
            System.out.println("circle queue is empty");
            System.exit(-1);
        }
        return array[front];
    }

}
