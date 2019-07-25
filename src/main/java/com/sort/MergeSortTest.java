package com.sort;

import java.util.Arrays;

/**
 * @Auther: 张扬
 * @Date: 2019/1/17 15:48
 * @Description:
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int []nums = {9,8,4,5,7,1,3,6,2};
        initSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void initSort(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length-1, temp);
    }

    private static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {

        int leftIndex = left;
        int rightIndex = mid + 1;
        int tempIndex = 0;
        //左右比较 直到一个数组到达末尾
        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[leftIndex] < nums[rightIndex]) {
                temp[tempIndex++] = nums[leftIndex++];
            } else {
                temp[tempIndex++] = nums[rightIndex++];
            }
        }
        //将左末尾的剩下的数字合并到临时数组中
        while (leftIndex <= mid) {
            temp[tempIndex++] = nums[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[tempIndex++] = nums[rightIndex++];
        }
        System.out.println(Arrays.toString(temp));
        tempIndex = 0;
        while (left <= right) {
            nums[left++] = temp[tempIndex++];
        }
    }


}
