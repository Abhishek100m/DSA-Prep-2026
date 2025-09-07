package com.prep.dsa.arrays.sorting_algos;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2324,565,5,33,3323,56,67877,65,4,333,2,1};
        for(int i:arr) System.out.print(i+ " ");System.out.println();
        insertionSort(arr);
        for(int i:arr) System.out.print(i+ " ");
    }

    private static void insertionSort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int j = i;
            while(j>0 && arr[j]<arr[j-1]){
                swap(arr,j,j-1);
                j--;
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
