package com.test.Other.z_search;

/**
 * 二分查找
 *      需要查找的数组有序
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{4,8,9,12,15,23,64,90,91};
        System.out.println(binarySearch(arr,91));
    }

    public static int binarySearch(int[] arr,int key) {
        int min,max,mid;
        min = 0;
        max = arr.length-1;

        //当min还小于max时，就继续查找
        while (min <= max){
            mid = (min + max)/2;
            if (arr[mid] < key) {
                min = mid + 1;
                continue;
            } else if (arr[mid] > key) {
                max = mid - 1;
                continue;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
