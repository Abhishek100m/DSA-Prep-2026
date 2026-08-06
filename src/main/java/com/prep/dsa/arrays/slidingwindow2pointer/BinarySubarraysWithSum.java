package com.prep.dsa.arrays.slidingwindow2pointer;

import java.util.HashMap;

/*

930. Binary Subarrays With Sum
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
A subarray is a contiguous part of the array.


Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15


Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
* */
public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal =2;
        int ans =  findGoal(nums, goal) - findGoal(nums, goal-1);
        System.out.println("Ans is :"+ans);
        System.out.println(numSubarraysWithSum(nums, goal));
    }
    private static int findGoal(int[] nums,int goal){
        if(goal<0)return 0;
        int sum  = 0, l =0, n = nums.length, count = 0;
        for(int r=0;r<n;r++){
            sum+= nums[r];
            while(sum>goal){
                sum -= nums[l];
                l++;
            }
            count += (r-l+1);
        }
        return count;
    }

    /*
    Key Logic:
Running Sum: We maintain a currentSum as we iterate through the array.
Prefix Frequency: The HashMap stores how many times each prefix sum has occurred.
This effectively tells us how many valid subarrays ending at the current index have a sum equal to the goal.
Mathematical Check: At every step, if currentSum - goal exists in our map,
it means there is a subarray that started at some previous point and ends at the current
index that perfectly sums to the goal.
    * */
    public static int numSubarraysWithSum(int[] nums, int goal) {
// Map to store frequency of prefix sums encountered
        HashMap<Integer,Integer> prefixSumCount = new HashMap<>();

// Base case: a sum of 0 has occurred once (before any elements)
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int totalCount = 0;

        for (int num : nums) {
            currentSum += num;

// Check if (currentSum - goal) exists in the map
            if (prefixSumCount.containsKey(currentSum - goal)) {
                totalCount += prefixSumCount.get(currentSum - goal);
            }

// Update the map with the current sum
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return totalCount;
    }
}
/*
The problem asks to find the number of subarrays with a sum equal to a given `goal`. Since we are working with a **binary array** (only 0s and 1s), we can optimize beyond the standard hashing approach.

### 1. Brute Force Approach
*   **Concept:** Generate every possible subarray of the given array, calculate the sum of each, and check if it equals the `goal` (1:12 - 1:54).
*   **Complexity:** $O(n^2)$ time complexity because of the nested loops used to define the start and end of subarrays.

### 2. Better Approach (Hashing)
*   **Concept:** Use a prefix sum map to keep track of the occurrences of sums encountered so far. This allows you to check for the `goal` in a single pass (2:21 - 2:44).
*   **Complexity:** $O(n)$ time and $O(n)$ space complexity (2:24 - 2:37).

### 3. Optimal Approach (Sliding Window)
*   **Intuition:** Directly finding subarrays equal to the `goal` using two pointers is tricky due to the presence of 0s, which don't change the sum but change the subarray length (8:07 - 8:16).
*   **How to think about it:** Instead of solving for *exactly* `goal`, solve for the number of subarrays with a sum **less than or equal to** `goal`.
    *   If you can count subarrays with `sum <= goal`, you can find the exact count by calculating: `count(goal) - count(goal - 1)` (17:20 - 17:57).
*   **Mechanism:** Use two pointers (`L` and `R`). Expand `R` to add elements; if the sum exceeds the `goal`, shrink the window from the left by moving `L`. At each valid `R`, the number of new subarrays ending at `R` is simply `R - L + 1` (15:53 - 16:17).
*   **Complexity:** $O(2n)$ time (effectively $O(n)$) and $O(1)$ space, as we removed the need for an external hash map (18:30 - 19:27).
*/