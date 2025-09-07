package com.prep.dsa.arrays.sorting_algos;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2324,565,5,33,3323,56,67877,65,4,333,2,1};
        for(int i:arr) System.out.print(i+ " ");System.out.println();
        mergeSort(arr, 0, arr.length-1);
        for(int i:arr) System.out.print(i+ " ");
    }

    private static void mergeSort(int[] arr, int low, int high) {
        //Base Case
        if(low>=high)return;
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    private static void merge(int[] arr, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left<=mid  && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left++]);
        }
        while(right<=high){
            temp.add(arr[right++]);
        }
        for(int i=low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }
    }
}
