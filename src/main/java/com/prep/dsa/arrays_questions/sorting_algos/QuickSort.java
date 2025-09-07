package com.prep.dsa.arrays_questions.sorting_algos;



public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2324,565,5,33,3323,56,67877,65,4,333,2,1};
        for(int i:arr) System.out.print(i+ " ");System.out.println();
        quickSortAlgo(arr);
        for(int i:arr) System.out.print(i+ " ");
    }
    private static void quickSortAlgo(int[] arr){
//        STEP1: select 1st, last, median or random element for Pivot.
//        STEP2: pick up a any pivot, and place it in its correct place into the sorted array.
//        STEP3: smaller on the left and larger on the right
//        STEP4: after doing this we'll do same for
//                  left most to pivot's previous index-1 and
//                  pivot's next index+1 to right most element
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pivotIndex = partioning(arr,low,high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }

    private static int partioning(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i<j){
            while (arr[i]<=pivot && i<high){
                i++;
            }
            while (arr[j]>pivot && j>low){
                j--;
            }
            if(i<j)swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
