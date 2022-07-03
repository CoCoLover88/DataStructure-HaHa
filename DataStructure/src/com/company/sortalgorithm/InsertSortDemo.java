package com.company.sortalgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSortDemo
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
        insertSort(array);
        Date endDate = new Date();
        String endTime = simpleDateFormat.format(endDate);
        System.out.println("排序后的时间：" + endTime);
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertSort(int[] array)
    {
        int insertValue;
        int insertIndex;
        for (int i = 1; i < array.length; i++)
        {
            insertValue = array[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < array[insertIndex])
            {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i)
            {
                array[insertIndex + 1] = insertValue;
            }
        }
    }
}
