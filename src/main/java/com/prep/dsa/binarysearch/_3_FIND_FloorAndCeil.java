package com.prep.dsa.binarysearch;

public class _3_FIND_FloorAndCeil {
    /*
    Floor and Ceil in Sorted Array

    floor = lower or equal ( <= )
    ceil = higher or equal ( >= ) means same as lower bound
    Given a sorted array nums and an integer x. Find the floor and ceil of x in nums. The floor of x is the largest element in the array which is smaller than or equal to x. The ceiling of x is the smallest element in the array greater than or equal to x. If no floor or ceil exists, output -1.


        Example 1

        Input : nums =[3, 4, 4, 7, 8, 10], x= 5

        Output: 4 7

        Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

        Example 2

        Input : nums =[3, 4, 4, 7, 8, 10], x= 8

        Output: 8 8

        Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.
            */

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int x = 11;
        int floor = findFloor(arr, x);
        int ceil = findCeil(arr, x);
        System.out.println("for x:"+ x+" floor "+floor+" and ceil "+ ceil);
    }

    private static int findCeil(int[] arr, int x) {
        return _1_FindLowerUpperBound.findLowerBound(arr,x) == arr.length ? -1 :
                                                        arr[_1_FindLowerUpperBound.findLowerBound(arr,x)];
    }

    private static int findFloor(int[] arr, int x) {
        int low = 0 , high = arr.length-1;
        int ans = -1;
        while (low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<=x){
                ans = arr[mid];
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }
        return ans;

    }

}
