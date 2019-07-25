package com.logs;

/**
 * @Auther: 张扬
 * @Date: 2019/6/6 14:29
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {

        int [][] a = new int[][]{
                 {1,2,3},{4,5,6}
         };
        System.out.println(a[findXandY(a)[0]][findXandY(a)[1]]);

    }
    public static int[] findXandY(int a[][]){
        int midX = a[a.length-1].length/2;
        int midY = a.length /2;
        System.out.println( midX +"  " + midY);
        return  new int[]{midX,midY};
    }
}
