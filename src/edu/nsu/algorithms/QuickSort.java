package edu.nsu.algorithms;

import util.Util;

public class QuickSort implements Sorting {
    public void sortArray(int[] arr, int begin, int end){
        if(begin >= end) return;
        int p = partition(arr, begin, end);
        sortArray(arr, begin, p-1);
        sortArray(arr, p+1, end);
    }

    public int partition(int[] arr, int begin, int end){
        int i = begin -1;
        int pivot = arr[end];
        for(int j = begin; j < end ; j++){
            if(arr[j] < pivot){
                ++i;
                Util.swap(arr, i, j);
            }
        }
        Util.swap(arr, i+1, end);
        return i+1;
    }


}
