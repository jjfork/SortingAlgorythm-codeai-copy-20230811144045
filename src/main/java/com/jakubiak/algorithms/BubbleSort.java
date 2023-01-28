package com.jakubiak.algorithms;

public class BubbleSort implements SortingAlgorithm {


    @Override
    public int[] sort(int[] arr) {
        int length = arr.length;                       // Declare and initialize a variable "length" with the length of the input array "arr"
        for (int i = 0; i < length - 1; i++)          // Iterate over the array "arr" from index 0 to the end of array
            for (int j = 0; j < length - i - 1; j++) // nested loop, iterate over the array "arr" from index 0 to the end of array
                if (arr[j] > arr[j + 1]) {          // if the current element is greater than the next element
                    int temp = arr[j];             // store the current element in a temporary variable "temp"
                    arr[j] = arr[j + 1];          // replace the current element with the next element
                    arr[j + 1] = temp;           // replace the next element with the temporary variable
                }
        return arr;
    }

    @Override                                // Indicates that this method overrides a method from a superclass
    public String getAlgorithmName() {      // Declare a public method called "getAlgorithmName" that returns a String
        return BubbleSort.class.getName(); // Return the fully qualified name of the class of which this object is an instance
    }                                     //This method is used to return the name of the algorithm used in this class.
                                         // It uses the class keyword to get the class object and then
                                        // calls the getName() method on it which returns the fully qualified name of the class.
}

