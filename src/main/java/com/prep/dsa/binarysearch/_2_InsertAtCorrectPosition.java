package com.prep.dsa.binarysearch;

public class _2_InsertAtCorrectPosition {
    /*
       Problem Statement

        You are given a sorted array 'arr' of distinct values and a target value 'm'. You need to search for the
        index of the target value in the array.

        If the value is present in the array, then return its index.

        If the value is not present, determine the index where it would be inserted in the array while maintaining the sorted order.

        Example:
        Input: arr= [1, 2, 4, 7], m = 6
        Output: 3

        Explanation: If the given array 'arr' is: [1, 2, 4, 7] and m = 6. We insert m= 6 in the array and get 'arr' as: [1, 2, 4, 6, 7]. The position of 6 is 3 (according to 0-based indexing)
    * */
    public static void main(String[] args) {
        int[] arr = {1,2,4,7}; int m1 = 6, m2 = 2;
        int correctPosition = _1_FindLowerUpperBound.findLowerBound(arr,m1);
        System.out.println("if value is: "+ m1 +" Correct Position: "+ correctPosition);
        correctPosition = _1_FindLowerUpperBound.findLowerBound(arr,m2);
        System.out.println("if value is: "+ m2 +" Correct Position: "+ correctPosition);
    }
}
