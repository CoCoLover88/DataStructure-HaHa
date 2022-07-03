package com.company.searchalgorithm;

public class InsertSearchDemo
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 4, 6, 8, 10, 13, 14, 23};
        System.out.println(insertSearch(arr, 0, arr.length - 1, 13));
    }

    /**
     * 插值查找
     * @param arr
     * @param left
     * @param right
     * @param val
     * @return
     */
    public static int insertSearch(int[] arr, int left, int right, int val)
    {
        System.out.println("count");
        if (left > right || val < arr[left] || val > arr[right])
            return -1;
        int mid = left + (right - left) * (val - arr[left]) / (arr[right] - arr[left]);
        if (val < arr[mid])
            return insertSearch(arr, left, mid - 1, val);
        else if (val > arr[mid])
            return insertSearch(arr, mid + 1, right, val);
        else
            return mid;
    }
}
