package edu.nsu.Algorithms;

public class MergeSort implements Sorting {
    public void sortArray(int[] arr, int begin, int end){
        if(begin >= end) return;
        int mid = (begin + end)/2;
        sortArray(arr, begin, mid);
        sortArray(arr, mid+1, end);
        merge(arr, mid, begin, end);
    }

    public void merge(int[] arr, int mid, int begin, int end){
        int n1 = mid-begin+1;
        int n2 = end - mid;

        int[] lower = new int[n1];
        int[] upper = new int[n2];

        for(int i = 0; i < n1; i++)
            lower[i] = arr[begin+i];
        for(int j = 0; j < n2; j++)
            upper[j] = arr[mid+j+1];

        int i = 0, j = 0, k = begin;
        while(i < n1 && j < n2){
            if(lower[i] <= upper[j]){
                arr[k] = lower[i];
                ++i;
                ++k;
            }
            else{
                arr[k] = upper[j];
                ++j;
                ++k;
            }
            while(i < n1){
                arr[k] = lower[i];
                ++i;
                ++k;
            }

            while(j < n2){
                arr[k] = upper[j];
                ++j;
                ++k;
            }
        }
    }
}
