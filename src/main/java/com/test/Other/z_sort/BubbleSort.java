package com.test.Other.z_sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *      依次比较相邻的两个数，将小数放在前面，大数放在后面。
 *  即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。
 *  然后比较第2个数和第3个数，将小数放前，大数放后，如此继续
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = new int[]{3,2,7,1,9,4,6,8};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {            //外层循环控制排序趟数
            for (int j = 0; j < arr.length-i-1; j++) {      //内层循环控制每一趟排序多少次
                if (arr[j] > arr[j+1]) {                //正序，如果倒序显示用"<"
                    changePosition(arr,j,j+1);
                }
            }
        }
    }

    public static void changePosition(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
