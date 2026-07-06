package com.prep.dsa.recursion;

import java.util.*;


public class Find_Kth_PermutationSequence {

    void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    // Function to generate all possible permutations of a string
    private void permutationHelper(StringBuilder s, int index, List<String> res) {
        if (index == s.length()) {
            res.add(s.toString());
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // Swap and recurse
            swap(s, i, index);
            permutationHelper(s, index + 1, res);
            swap(s, i, index);  // backtrack
        }
    }

    public String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();
        List<String> res = new ArrayList<>();

        // Create string with characters '1' to 'n'
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }

        permutationHelper(s, 0, res);  // Generate all permutations
        Collections.sort(res);  // Sort the generated permutations
        res.stream().forEach(System.out::println);
        // Make k 0-based indexed to point to kth sequence
        return res.get(k - 1);
    }
}

class Main {
    public static void main(String[] args) {
        int n = 3, k = 3;
        Find_Kth_PermutationSequence obj = new Find_Kth_PermutationSequence();
        String ans = obj.getPermutation(n, k);
        System.out.println("The Kth permutation sequence is " + ans);
    }
}
