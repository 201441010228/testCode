package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 张扬
 * @Date: 2019/6/19 11:23
 * @Description:
 */
public class Algorithm {
    private static final Map<String, Integer> map = new HashMap<String,Integer>();


    public static void main(String[] args) {
        String[] strs = new String[]{};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        int totalIndex = 0;
        while(flag){
            char c = '-';
            for (int index = 0, len = strs.length; index < len; index++) {
                if (totalIndex == strs[index].length()) {
                    flag = false;
                    break;
                }
                if (index == 0) {
                     c = strs[index].charAt(totalIndex);
                }else {
                    if (c != strs[index].charAt(totalIndex)){
                        flag = false;
                        break;
                    };
                }
                if (index == strs.length - 1) {
                    stringBuilder.append(c);
                    totalIndex++;
                }
            }
        }
       return stringBuilder.toString();
    }



    public static int romanToInt(String s) {
         int ans = 0;
         for (int index = 0, len = s.length(); index < len; ) {
             boolean flag = true;
             if (index + 2 <= len) {
                 String key = s.substring(index,index+2);
                 if (map.containsKey(key)) {
                     ans += map.get(key);
                     index += 2;
                     flag = false;
                 }
             }
             if (flag){
                String key = s.substring(index, index + 1);
                 ans += map.get(key);
                 index += 1;
             }
         }
         return ans;
    }


    public static int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        int tmpArea = 0;
        int high = 0;
        while (start != end) {
            high = height[start] > height[end] ? height[end] : height[start];
            tmpArea = (end - start) * high;
            if (high == height[start]) {
                start++;
            }else{
                end--;
            }
            maxArea = tmpArea > maxArea ? tmpArea : maxArea;
        }
        return maxArea;
    }

    public static int  isMatch(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        if (x == 0 || y == 0) {
            return 1;
        }
        int r = isMatch(x-1,y)+isMatch(x,y-1);
        return r;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        String str1 = String.valueOf(x);
        StringBuilder str = new StringBuilder(str1);
        return str1.equals(str.reverse().toString());
    }
    public static boolean isPalindrome1(int x){
        if (x < 0) {
            return false;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        while (x != 0) {
            integers.add(x % 10);
            x /= 10;
        }
        Integer[] tmp =  integers.toArray(new Integer[0]);
        for (int i = 0; i < tmp.length / 2; i++) {
            if (!tmp[i].equals(tmp[tmp.length - i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        char[] tmpArr = new char[chars.length * 2 + 1];
        tmpArr[0] = '#';
        for (int index = 1; index < tmpArr.length; ) {
            if ((1 & index) == 1) {
                tmpArr[index++] = chars[(index - 1) / 2];
            } else {
                tmpArr[index++] = '#';
            }
        }
        int[] tmpIntegeArr = new int[tmpArr.length];
        int maxRight = 0;
        int position = 0;
        for (int index = 0; index < tmpIntegeArr.length; index++) {
            tmpIntegeArr[index] = index < maxRight ? Math.min(2 * position - index, maxRight - index) : 1;
            while (index - tmpIntegeArr[index] >= 0 && index + tmpIntegeArr[index] < tmpArr.length &&
                    tmpArr[index - tmpIntegeArr[index]] == tmpArr[index + tmpIntegeArr[index]] ) {
                tmpIntegeArr[index]++;
            }
            if (maxRight < tmpIntegeArr[index] + position - 1) {
                position = index;
                maxRight = tmpIntegeArr[index] + position - 1;
            }
        }
        for (int i = 0; i < tmpIntegeArr.length; i++) {
            if (tmpIntegeArr[i] > 1) {
                return true;
            }
        }
        return false;
    }



    public static int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int res = 0;
        char[] chars = str.toCharArray();
        boolean signFlag = true;
        boolean bigFlag = true;
        StringBuilder stringBuilder = new StringBuilder();
        if ('-' == chars[0]) {
            signFlag = false;
        }
        if ('+' == chars[0]) {
            bigFlag = false;
        }
        for (int index = signFlag && bigFlag ? 0 : 1; index < chars.length; index++) {
            char c = chars[index];
            if (c < '0' || c > '9') {
                if (stringBuilder.toString().length() > 0) {
                    break;
                }
                return 0;
            }else{
                stringBuilder.append(c);
            }
        }
        try {
            if (stringBuilder.toString().length() == 0) {
                    return 0;
            }
            res = Integer.valueOf(stringBuilder.toString());
        }catch (Exception e){
            if (!signFlag){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }
        if (!signFlag){
            res = -1 * res;
        }
        return res;
    }

    public static int reverse(int x) {
        String res = "";
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        String str = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        if (flag){
           res = "-"+stringBuilder.toString();
        }else{
            res = stringBuilder.toString();
        }
        int tmp= 0 ;
        try {
            tmp = Integer.valueOf(res);
        }catch (Exception e){
            tmp = 0;
        }
        return tmp;
    }

    /**
     * Z形状
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        char[][] chars = convertArr2Arrs(s.toCharArray(), numRows);
        StringBuffer stringBuffer = new StringBuffer();
        for (char[] c:chars) {
            for (char c1:c){
                if (c1 == '\u0000'){
                    continue;
                }
                stringBuffer.append(c1);
            }
        }
        System.out.println(stringBuffer.toString().length());
        return stringBuffer.toString();
    }

    public static char[][] convertArr2Arrs(char[] param,int numRows){
        char[][] tmpArr = new char[numRows][param.length];
        if (numRows == 1) {
            tmpArr[0] = param;
            return tmpArr;
        }
        int rowIndex = 0;
        int columnIndex = 0;
        int positon = 0;
        int num = 1;
        int cycle = 0;
        while (cycle != param.length){
            for (;positon < cycle + numRows * 2 - 2 && positon < param.length ;positon++){
                if (positon <= (numRows - 1) * num) {
                    tmpArr[rowIndex++][columnIndex] = param[positon];
                }else{
                    if (positon - 1 == (numRows - 1) * num) {
                        rowIndex--;
                    }
                    tmpArr[--rowIndex][++columnIndex] = param[positon];
                }
            }
             num+=2;
             cycle = positon ;
             rowIndex = 0;
             columnIndex++;
        }
        return tmpArr;
    }

    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        char[] arr = getTmpArr(s);
        int[] tmpArr = new int[arr.length];
        int positon = 0;
        int maxRight = 0;
        int maxLength = 0;
        int start = 0;
        StringBuffer res = new StringBuffer();
        for (int index = 0; index < tmpArr.length; index++) {
            tmpArr[index] = maxRight > index ? Math.min(tmpArr[2 * positon - index], maxRight - index) : 1;
            while (index - tmpArr[index] >= 0 && index + tmpArr[index] < arr.length
                    && arr[index + tmpArr[index]] == arr[index - tmpArr[index]]) {
                tmpArr[index]++;
            }
            if (maxRight < index + tmpArr[index] - 1) {
                maxRight = index + tmpArr[index] - 1;
                positon = index;
            }
            if (tmpArr[index] > maxLength) {
                start = index;
                maxLength = tmpArr[index];
            }
        }
        for (int i = start - (maxLength - 1); i < start + (maxLength - 1); i++) {
            if (arr[i] == '#') {
                continue;
            }
            res.append(arr[i]);
        }
        return res.toString();
    }


    public static char[] getTmpArr(String s) {
        char[] str = s.toCharArray();
        char[] tmpArr = new char[str.length * 2 + 1];
        tmpArr[0] = '#';
        for (int index = 1; index < tmpArr.length; ) {
            if ((1 & index) == 1) {
                tmpArr[index++] = str[(index - 1) / 2];
            } else {
                tmpArr[index++] = '#';
            }
        }
        return tmpArr;
    }

}
