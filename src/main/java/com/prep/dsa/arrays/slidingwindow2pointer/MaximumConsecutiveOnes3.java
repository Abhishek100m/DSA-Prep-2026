package com.prep.dsa.arrays.slidingwindow2pointer;
/*

1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length

*/
public class MaximumConsecutiveOnes3 {

    public static void main(String[] args) {
        int arr[] = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println("Maximum len is : "+ optimalApproach(arr, k));
    }
    /*
    * Brute force will be iterate over all substring,
    * and check with those ones which have exactly k zeros,
    * and between them find largest one.
    * TC - O(N*N)
    * */
    private static int optimalApproach(int[] nums, int k){
        int l=0, r=0, n=nums.length,maxLen = 0, cnt=0;
        while(r<n){
            if(nums[r] == 0)cnt++;
            if(cnt>k){
                if(nums[l] == 0)cnt--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
    /*

### **Optimal Approach (Sliding Window - Optimized)**

Iska main goal ye hai ki humein bina inner while loop use kiye,
 $O(N)$ time complexity mein answer nikalna hai.

1.  **Intuition:**
    *   Hum ek window maintain karte hain `[left, right]`.
    *   Jab tak hamare window mein zeros ki count $K$ se kam ya equal hai,
        hum window ko expand karte hain (`right` pointer ko move karke) aur `max_length` ko track karte hain.
    *   (why if instead of while)**Smart Trick:**
            Agar zeros ki count $K$ se badh jaati hai,
            toh hum `left` pointer ko move karte hain. Lekin, hume `left` ko
            wahan tak le jaane ki zaroorat nahi hai jahan zero delete ho; hum `left`
            ko sirf **ek step** aage badhate hain. Isse hamari window ka size kabhi bhi
            previous `max_length` se chhota nahi hoga. Hum bas us window size ko maintain rakhte hain.

2.  **Approach:**
    *   Initialize: `left = 0`, `right = 0`, `zeros = 0`, `max_len = 0`.
    *   `right` pointer ko array ke end tak move karo.
    *   Agar `nums[right] == 0` milta hai, toh `zeros` count badhao.
    *   Agar `zeros > K` ho jaye, toh `left` pointer ko ek step aage badhao (`if nums[left] == 0: zeros--`), aur `left++` karo.
    *   Har step par, agar `zeros <= K`, toh `max_len = max(max_len, right - left + 1)` update karo.
    *   Ant mein, `max_len` return karo.

### **Why is this Optimal?**
*   **Time Complexity:** $O(N)$, kyunki hum array ko sirf ek baar traverse kar rahe hain.
*   **Space Complexity:** $O(1)$, kyunki hum sirf few variables use kar rahe hain, koi extra space nahi.
    */

}















