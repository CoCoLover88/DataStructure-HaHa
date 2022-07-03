package com.company.searchalgorithm;

public class SeqSearchDemo
{
    public static void main(String[] args)
    {
        int[] array=new int[]{1,4,7,5,2,3};
        System.out.println(seqSearch(array, 7));
    }

    public static int seqSearch(int[] array, int val)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == val)
            {
                return i;
            }
        }
        return -1;
    }
}
