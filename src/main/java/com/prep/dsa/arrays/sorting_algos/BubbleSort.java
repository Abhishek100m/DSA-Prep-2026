package com.prep.dsa.arrays.sorting_algos;
/*
Approach:

The algorithm steps are as follows:

First, we will select the range of the unsorted array. For that, we will run a loop(say i) that will signify the last index of the selected range. The loop will run backward from index n-1 to 0(where n = size of the array). The value i = n-1 means the range is from 0 to n-1, and similarly, i = n-2 means the range is from 0 to n-2, and so on.
Within the loop, we will run another loop(say j, runs from 0 to i-1 though the range is from 0 to i) to push the maximum element to the last index of the selected range, by repeatedly swapping adjacent elements.
Basically, we will swap adjacent elements(if arr[j] > arr[j+1]) until the maximum element of the range reaches the end.
Thus, after each iteration, the last part of the array will become sorted. Like: after the first iteration, the array up to the last index will be sorted, and after the second iteration, the array up to the second last index will be sorted, and so on.
After (n-1) iteration, the whole array will be sorted.
Note: Here, after each iteration, the array becomes sorted up to the last index of the range. That is why the last index of the range decreases by 1 after each iteration. This decrement is achieved by the outer loop and the last index is represented by variable i in the following code. And the inner loop(i.e. j) helps to push the maximum element of range [0….i] to the last index(i.e. index i).
* */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2324,565,5,33,3323,56,67877,65,4,333,2,1};
        for(int i:arr) System.out.print(i+ " ");System.out.println();
        bubbleSort(arr);
        for(int i:arr) System.out.print(i+ " ");
    }

    private static void bubbleSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            boolean didSwap = false;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    swap(arr,i,j);
                    didSwap=true;
                }
            }
            if (!didSwap) {
                break;
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
