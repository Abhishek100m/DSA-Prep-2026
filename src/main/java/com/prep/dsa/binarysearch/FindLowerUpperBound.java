package com.prep.dsa.binarysearch;

public class FindLowerUpperBound {
    /* if array = 1,2,3,3,5,8,8,10,10,12
        indices   0,1,2,3,4,5,6, 7, 8, 9, 10 .....
        Lower bound -> the smallest index which is greater or equal to target -> that is arr[index] >= target
        examples -> [x=8, ans= 5], [x=9, ans= 7], [x=11, ans= 9], [x=20, ans= 10], [x=0, ans=0]


        Upper bound means smallest index which is greater to target -> that is arr[index] > target
        examples -> [x=8, ans= 7], [x=9, ans= 7], [x=11, ans= 9], [x=20, ans= 10], [x=0, ans=0]
    */
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,5,8,8,10,10,12};
        int[] targetTestCases = {8,9,11,20,0};
        for(int target: targetTestCases){
            int lowerBound = findLowerBound(arr, target);
            int upperBound = findUpperBound(arr, target);
            System.out.println("For target "+ target + " LowerBound and UpperBound is: "+ lowerBound + " " + upperBound);
        }

    }

    public static int findUpperBound(int[] arr, int target) {
        int ans = arr.length;
        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] > target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static int findLowerBound(int[] arr, int target) {
        int ans = arr.length;
        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] >= target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
