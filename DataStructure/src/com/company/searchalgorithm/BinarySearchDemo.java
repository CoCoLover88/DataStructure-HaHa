package com.company.searchalgorithm;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchDemo
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 4, 6, 8, 10, 10, 14, 23};
        System.out.println(binarySearch2(arr, 0, arr.length - 1, 10));
    }

    public static int binarySearch(int[] arr, int left, int right, int val)
    {
        if (left > right)
            return -1;
        int mid = (left + right) / 2;
        if (val > arr[mid])
        {
            return binarySearch(arr, mid + 1, right, val);
        } else if (val < arr[mid])
        {
            return binarySearch(arr, left, mid - 1, val);
        } else
        {
            return mid;
        }
    }

    public static List binarySearch2(int[] arr, int left, int right, int val)
    {
        if (left > right)
            return new ArrayList();
        int mid = (left + right) / 2;
        if (val > arr[mid])
        {
            return binarySearch2(arr, mid + 1, right, val);
        } else if (val < arr[mid])
        {
            return binarySearch2(arr, left, mid - 1, val);
        } else
        {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true)
            {
                if (temp < 0 || arr[temp] != val)
                    break;
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (true)
            {
                if (temp > arr.length - 1 || arr[temp] != val)
                    break;
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
