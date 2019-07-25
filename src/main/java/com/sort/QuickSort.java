package com.sort;

import com.mulread.User;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张扬
 * @Date: 2019/1/18 15:08
 * @Description:
 */
public class QuickSort {

    public  static List<User> users = new ArrayList<>(3);

    public static void main(String[] args){
        int[]  a = new int[]{1,2,3};
        System.out.println(findMedianSortedArrays(a,a));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return nums2.length % 2 == 0?((double)nums2[nums2.length/2]+nums2[(nums2.length-1)/2])
                    /2:nums2[nums2.length/2];
        }
        if (nums2 == null){
            return nums1.length % 2 == 0?((double)nums1[nums1.length/2]+nums1[(nums1.length-1)/2])/2:nums1[nums1.length/2];
        }
        int[] tmpArr = new int[nums1.length+nums2.length];
        int s1 = 0;
        int s2 = 0;
        int index = 0;
        boolean flag = true;
        while(s1 < nums1.length || s2 < nums2.length) {
            if (s1 == nums1.length && s2 < nums2.length) {
                while (s2 < nums2.length) {
                    tmpArr[index++] = nums2[s2++];
                }
                flag = false;
            }
            if (s2 == nums2.length && s1 < nums1.length) {
                while (s1 < nums1.length) {
                    tmpArr[index++] = nums1[s1++];
                }
                flag = false;
            }
            if (flag) {
                if (nums1[s1] <= nums2[s2]) {
                    tmpArr[index++] = nums1[s1++];
                } else {
                    tmpArr[index++] = nums2[s2++];
                }
            }
        }
        return tmpArr.length % 2 == 0?((double)tmpArr[tmpArr.length/2]+tmpArr[(tmpArr.length-1)/2])/2:tmpArr[tmpArr
                .length/2];
    }




}
