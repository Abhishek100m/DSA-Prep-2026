package com.prep.dsa.arrays.slidingwindow2pointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
904. Fruit Into Baskets
You are visiting a farm that has a single row of fruit trees arranged from left to right.
 The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on
the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree
(including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.



Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].


Constraints:

1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length
*/
public class FruitsIntoBasket {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2};
        System.out.println("Brute Force App : " + bruteForce(nums));
        System.out.println("optimal approach : " + optimal(nums));
    }
    private static int bruteForce(int[] nums){
        int maxLen = 0;
        for(int i=0;i<nums.length;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<nums.length;j++){
                set.add(nums[j]);
                if(set.size() > 2){
                    break;
                }
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
    private static int optimal(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int l=0, r=0,n = nums.length,cnt = 0, maxLen = 0;
        while(r<n){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            if(map.size() > 2){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }


}
