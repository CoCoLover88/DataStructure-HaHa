package com.company.sortalgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSortDemo
{
    public static void main(String[] args)
    {
        QuickSortDemo demo = new QuickSortDemo();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int) (Math.random() * 100000);
        }
        Date startDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = simpleDateFormat.format(startDate);
        System.out.println("排序前的时间：" + startTime);
        demo.quick_sort(array);
        Date endDate = new Date();
        String endTime = simpleDateFormat.format(endDate);
        System.out.println("排序后的时间：" + endTime);
    }

    /**
     * 快速排序,划分
     *
     * @param arr
     * @param low  最左边索引
     * @param high 最右边索引
     * @return int 划分位置
     */
    int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot)
            {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    void qsort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int mid = partition(arr, low, high);
            qsort(arr, low, mid - 1);
            qsort(arr, mid + 1, high);
        }
    }

    void quick_sort(int[] arr)
    {
        qsort(arr, 0, arr.length - 1);
    }

    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
