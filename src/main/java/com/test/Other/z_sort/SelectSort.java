package com.test.Other.z_sort;

import java.util.Arrays;

/**
 * 选择排序
 *      拿第i个元素与后面每一个进行比较，就可以选出最大（最小）值，放在第i位，
 *  每一趟在n-i+1（i=1，2，…n-1）个记录中选取关键字最小的记录作为有序序列中第i个记录
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,7,1,9,4,7,8};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {                  //正序， 如果倒序显示用"<"
                    changePosition(arr,i,j);
                }
            }
        }
    }

    public static void changePosition(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
