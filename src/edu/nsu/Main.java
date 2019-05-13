package edu.nsu;

import edu.nsu.Algorithms.MergeSort;
import edu.nsu.Algorithms.Sorting;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myNumbers = {10,-17, -19, -20, -30, 0, 5};
        Sorting sorting = new MergeSort();
        sorting.sortArray(myNumbers, 0, myNumbers.length-1);
        for(int num: myNumbers)
            System.out.println(num);
    }
}
