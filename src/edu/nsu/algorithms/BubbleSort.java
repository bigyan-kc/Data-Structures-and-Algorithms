package edu.nsu.algorithms;

import util.Util;

public class BubbleSort implements Sorting {
    public void sortArray(int[] arr, int begin, int end){
        boolean isSwapped;
        for(int i = 0; i < arr.length; i++){
            isSwapped = false;
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    Util.swap(arr, j, j+1);
                    isSwapped = true;
                }}
                if(!isSwapped) break;
        }
    }

}
