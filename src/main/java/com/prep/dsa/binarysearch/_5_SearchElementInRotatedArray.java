package com.prep.dsa.binarysearch;

public class _5_SearchElementInRotatedArray {
    /*
    Search in rotated sorted array-I

Given an integer array nums, sorted in ascending order (with distinct values) and a target value k. The array is rotated at some pivot point that is unknown. Find the index at which k is present and if k is not present return -1.

        Example 1
        Input : nums = [4, 5, 6, 7, 0, 1, 2], k = 0
        Output: 4

        Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

        Example 2
        Input: nums = [4, 5, 6, 7, 0, 1, 2], k = 3
        Output: -1

        Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.

    */
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2}; int num = 4;
        int ans = searchElement(arr,num);
        System.out.println("Position: "+ans);

        //Duplicate values case
        int[] arrWithDuplicate = {3,3,3,4,3,3,1,2,3,3,3,3}; num = 4;
        ans = searchElement_Duplicate_Allowed(arrWithDuplicate,num);
        System.out.println("Duplicate case --> Position: "+ans);

    }

    private static int searchElement(int[] arr, int num) {
        int low = 0, high = arr.length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==num)return mid;
            if(arr[low] <= arr[mid]){
                if(num >= arr[low] && num <= arr[mid]){
                    high = mid-1;
                }else
                    low = mid+1;
            }else{
                if(num >= arr[mid] && num <= arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    /* Approach -->
    * Because array is rotated, when we calculate the mid, if mid is not our target then either left half
    * is sorted or right half will be sorted.
    *
    * how we'll get to know because of the sorted property if arr[low] is smaller or equals to arr[mid]
    * means left half is sorted
    *
    * if arr[mid] is small or equals to arr[high] then right half is sorted.
    *
    * after identification, we need to eliminate left or right half, we can do that
    * if left half is sorted, then we'll check target is lying between low and mid, if yes then we'll eliminate right half
    * if not then eliminate, left half
    *
    * if right is sorted, then we'll check our target is lying in right half or not
    * if yes then we'll change the low = mid+1 and eliminate left half
    * if no means high = mid-1 and eliminate right half.
    *
    * */

    private static int searchElement_Duplicate_Allowed(int[] arr, int num) {
        int low = 0, high = arr.length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==num)return mid;
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++; high--;
                continue;
            }
            if(arr[low] <= arr[mid]){
                if(num >= arr[low] && num <= arr[mid]){
                    high = mid-1;
                }else
                    low = mid+1;
            }else{
                if(num >= arr[mid] && num <= arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
