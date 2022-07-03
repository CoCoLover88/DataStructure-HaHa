package com.company.sortalgorithm;

import java.util.Arrays;

public class MergeSortDemo
{
    static int count = 0;

    public static void main(String[] args)
    {
        int[] arr = new int[8000];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int) Math.random() * 8000;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp)
    {
        if (left < right)
        {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并方法
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp)
    {
        count++;
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right)
        {
            if (arr[i] <= arr[j])
            {
                temp[t] = arr[i];
                t++;
                i++;
            } else
            {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        while (i <= mid)
        {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right)
        {
            temp[t] = arr[j];
            j++;
            t++;
        }

        //将temp元素拷贝到arr
        t = 0;
        int tempLeft = left;

        while (tempLeft <= right)
        {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
