package com.company.sortalgorithm;

public class selectSortDemo
{
    public static void main(String[] args)
    {
        int[] array = new int[]{20, -1, 10, 5, 9};
        System.out.println("选择排序前：");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("选择排序后：");
        selectSort(array);
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 选择排序
     * 升序
     *
     * @param array
     */
    public static void selectSort(int[] array)
    {
        int minIndex;
        for (int i = 0; i < array.length - 1; i++)
        {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[minIndex] < array[j])
                {
                    minIndex = j;
                }

                if (i != minIndex)
                {
                    swap(array, i, minIndex);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
