package com.prep.dsa.arrays;

import java.sql.SQLOutput;

/*
* Given an array of integers nums, return the value of the largest element in the array


Examples:
Input: nums = [3, 3, 6, 1]

Output: 6

Explanation: The largest element in array is 6

Input: nums = [3, 3, 0, 99, -40]

Output: 99

Explanation: The largest element in array is 99

****** Constraints:
1 <= nums.length <= 105
-10^4 <= nums[i] <= 10^4
nums may contain duplicate elements.
* */
public class Ques1 {
    /*
        Brute:-     Sort an array acending manner, and take last one.
        Better:-    take a MIN_Value, and iterate a loop and find max.
    */
    public static void main(String[] args) {
        int[] arr = {3, 3, 0, 99, -40};
        int result = Integer.MIN_VALUE;
        for(int i:arr){
            result = Math.max(result, i);
        }
        System.out.println("Max Value is : "+ result);
    }
}
