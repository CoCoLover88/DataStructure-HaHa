package com.company.sortalgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 80000);
        }
        System.out.println("冒泡排序前：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        System.out.println("冒泡排序后：");
        Date startDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = simpleDateFormat.format(startDate);
        System.out.println("排序前的时间：" + startTime);
        bubbleSortOpt(array);
        Date endDate = new Date();
        String endTime = simpleDateFormat.format(endDate);
        System.out.println("排序后的时间：" + endTime);
    }

    /**
     * 冒泡排序
     * 升序
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    /**
     * 冒泡排序算法优化
     *
     * @param array
     */
    public static void bubbleSortOpt(int[] array) {
        boolean flag = true;
        for (int i = 0; i < array.length - 1 && flag; i++) {
            flag = false;
            for (int j = i + 1; j < array.length - i; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                    flag = true;
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
