package com.company.sortalgorithm;

import java.util.Arrays;

public class RadixSortDemo
{
    public static void main(String[] args)
    {
        int[] array = new int[]{201, 1, 10, 5, 9};
        radixSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 基数排序-未能实现对负数进行排序
     * @param arr
     * @param length
     */
    public static void radixSort(int[] arr, int length)
    {
        int i, max = arr[0], base = 1;
        /*1.找出数组中最大的数*/
        for (i = 1; i < length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        int[] temp = new int[length];

        while (max / base > 0)
        {
            int[] bucket = new int[10];
            for (i = 0; i < length; i++)
            {
                bucket[arr[i] / base % 10]++;
            }
            for (i = 1; i < 10; i++)
            {
                bucket[i] += bucket[i - 1];
            }
            for (i = length - 1; i >= 0; i--)
            {
                temp[bucket[arr[i] / base % 10] - 1] = arr[i];
                bucket[arr[i] / base % 10]--;
            }
            for (i = 0; i < length; i++)
            {
                arr[i] = temp[i];
            }
            base = base * 10;
        }
    }
}
