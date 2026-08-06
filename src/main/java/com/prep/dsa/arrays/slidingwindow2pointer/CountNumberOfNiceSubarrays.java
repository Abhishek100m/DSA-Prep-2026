package com.prep.dsa.arrays.slidingwindow2pointer;

import java.util.HashMap;
import java.util.Map;

/*

1248. Count Number of Nice Subarrays
Given an array of integers nums and an integer k.
A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.



Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16


Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length

*
*
* */
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println("Ans is :"+ numberOfSubarrays(nums, k));
    }
    public static  int numberOfSubarrays(int[] nums, int k) {
        //    return betterAPP(nums, k);
        return optimal(nums, k)-optimal(nums, k-1);
    }
    private static int optimal(int[] nums, int k){
        if(k<0)return 0;
        int l=0, r=0, n = nums.length;
        int cnt = 0,  kOdd = 0;
        while(r<n){
            if(nums[r]%2!=0)kOdd++;
            while(kOdd > k){
                if(nums[l]%2!=0)kOdd--;
                l++;
            }
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
    private static  int betterAPP(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0,  n = nums.length, kOdds = 0;
        map.put(0, 1);
        for(int i=0;i<n;i++){
            if(nums[i]%2!=0){
                kOdds++;
            }
            if(map.containsKey(kOdds-k)){
                cnt += map.get(kOdds-k);
            }
            map.put(kOdds, map.getOrDefault(kOdds, 0)+1);
        }
        return cnt;
    }
}
