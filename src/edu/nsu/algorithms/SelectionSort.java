package edu.nsu.algorithms;

import util.Util;

public class SelectionSort implements Sorting {

    public void sortArray(int[] arr, int begin, int end){
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]) minIndex = j;
            }
            Util.swap(arr, i, minIndex);
        }
    }
}
