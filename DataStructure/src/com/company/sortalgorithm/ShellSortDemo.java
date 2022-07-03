package com.company.sortalgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSortDemo
{
    public static void main(String[] args)
    {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int) (Math.random() * 100000);
        }
        Date startDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = simpleDateFormat.format(startDate);
        System.out.println("排序前的时间：" + startTime);
        shellSort(array);
        Date endDate = new Date();
        String endTime = simpleDateFormat.format(endDate);
        System.out.println("排序后的时间：" + endTime);
    }

    /**
     * 希尔排序
     *
     * @param array
     */
    public static void shellSort(int[] array)
    {
        int i, j, inc, key;
        for (inc = array.length / 2; inc > 0; inc /= 2)
        {
            for (i = inc; i < array.length; i++)
            {
                key = array[i];
                for (j = i; j >= inc && key < array[j - inc]; j -= inc)
                    array[j] = array[j - inc];
                array[j] = key;
            }
        }
    }
}
