package top.mysecondgod.java.core.study;

import java.util.Arrays;

/**
 * TODO To describe the functionality of this method
 * 
 * @author zhaijw
 */
public class Order
{
    public static void main(String[] args)
    {
        int[] a = { 1, 3, 9, 10, 12, 31, 76, 21, 54 };

        int temp = a[0];
        for (int i = 0; i < a.length; i++)
        {

            temp = a[i] > temp ? a[i] : temp;

        }
        System.out.println(temp);

        Arrays.sort(a);

        System.out.println(a[a.length - 1]);

    }
}
