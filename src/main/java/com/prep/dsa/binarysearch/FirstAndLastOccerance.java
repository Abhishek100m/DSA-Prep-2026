package com.prep.dsa.binarysearch;

public class FirstAndLastOccerance
{
    /*
    First and last occurrence

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. If the target is not found in the array, return [-1, -1].


        Example 1

        Input: nums = [5, 7, 7, 8, 8, 10], target = 8
        Output: [3, 4]
        Explanation:The target is 8, and it appears in the array at indices 3 and 4, so the output is [3,4]

        Example 2
        Input: nums = [5, 7, 7, 8, 8, 10], target = 6
        Output: [-1, -1]
        Expalantion: The target is 6, which is not present in the array. Therefore, the output is [-1, -1].
    */
    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 }; int num = 6;
        int[] ans = findFirstAndLastOccurance(arr,num);
        System.out.println("First and Last Occurance: "+ ans[0]+ " "+  ans[1]);
    }

    private static int[] findFirstAndLastOccurance(int[] arr, int num) {
        int lowerBound = FindLowerUpperBound.findLowerBound(arr, num);
        if(lowerBound == arr.length  || arr[lowerBound]!=num){
            return new int[]{-1,-1};
        }
        return new int[]{lowerBound, FindLowerUpperBound.findUpperBound(arr,num)-1};
    }
}
