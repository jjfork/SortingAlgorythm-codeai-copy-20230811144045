package com.jakubiak.algorithms;

public class InsertionSort implements SortingAlgorithm {
    @Override                                            //overriding the sort method from the SortingAlgorithm interface
    public int[] sort(int[] arr) {                      //takes an array of integers as a parameter
        int n = arr.length;                            //initialize the variable n as the length of the input array
        for (int i = 1; i < n; ++i) {                 //start a for loop that runs from 1 to n
            int sorting = arr[i];                    //initialize the variable sorting as the element at index i of the input array
            int j = i - 1;                          //initialize the variable j as i-1
            while (j >= 0 && arr[j] > sorting) {   /*start a while loop that continues while j is greater than or equal to 0
                                                  //and the element at index j of the input array is greater than the sorting variable */
                arr[j + 1] = arr[j];             //the element at index j+1 is assigned the value of the element at index j
                j = j - 1;                      //j decremented by 1
            }                                  //
            arr[j + 1] = sorting;             //the element at index j+1 is assigned the value of the sorting variable
        }                                    //
        return arr;                         //return the sorted array
    }

    @Override                                  //overriding the getAlgorithmName method from the SortingAlgorithm interface
    public String getAlgorithmName() {        //
        return InsertionSort.class.getName();//returns the name of the class as a string
    }
}

