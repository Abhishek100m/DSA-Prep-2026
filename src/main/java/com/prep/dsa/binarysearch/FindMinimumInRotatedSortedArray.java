package com.prep.dsa.binarysearch;

public class FindMinimumInRotatedSortedArray {
    /*
    Find minimum in Rotated Sorted Array

        Given an integer array nums of size N, sorted in ascending order with distinct values, and then rotated an unknown number of times (between 1 and N), find the minimum element in the array.


            Example 1
            Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
            Output: 0
            Explanation: Here, the element 0 is the minimum element in the array.

            Example 2
            Input : nums = [3, 4, 5, 1, 2]
            Output: 1
            Explanation:Here, the element 1 is the minimum element in the array.
    */
    public static void main(String[] args) {
        int[] arr = {3, 4, 5,6,7,8, 1, 2};
        int ans = findMinimumInRotatedArray(arr);
        System.out.println("Minimum: "+ans);
    }

    private static int findMinimumInRotatedArray(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;

            //condition for duplicates
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low = low+1;
                high = high-1;
                continue;
            }

            //optional optimization
            // if search space is already sorted, then always arr[low] is smaller element in that search space,
            if(arr[low]<= arr[high]){
                ans = Math.min(ans, arr[low]);
                break;
            }

            if(arr[low]<= arr[mid]){
                ans = Math.min(arr[low], ans);
                low = mid+1;
            }else{
                ans = Math.min(arr[mid], ans);
                high = mid-1;
            }
        }
        return ans;
    }

    /*
    * Approach -->
    *
    * As we know our sorted array rotated, if we left half is sorted it means
    * if we use sorted property so left half i.e(low -> mid) arr[low] is smaller.
    * and we can take arr[low] is a possible answer, and we can eliminate left half because
    * we already choose element from there, and change low as low = mid+1
    *
    * if right half is sorted i.e(mid -> high) then means arr[mid] will be smaller and possible answer
    * so we can choose and eliminate right half and change high as high = mid -1
    *
    * and keep running this process, till high not crosses low
    *
    *  */
}
