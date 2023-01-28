package com.jakubiak.algorithms;

public class HeapSort implements SortingAlgorithm {
    @Override                                        // Indicates that this method overrides a method from a superclass
    public int[] sort(int[] arr) {                  // Declare a public method called "sort" that takes an array of integers and returns an array of integers
        int length = arr.length;                   // Declare a variable "length" and set it to the length of the input array
        for (int i = length / 2 - 1; i >= 0; i--) // Start a for loop starting at the middle element of the array and going to the first element
            heapify(arr, length, i);             // Call the "heapify" method on the input array, passing in the length and the current index of the for loop
        for (int i = length - 1; i >= 0; i--) { // Start another for loop starting at the last element of the array and going to the first element
            int temp = arr[0];                 // Declare a variable "temp" and set it to the first element of the array
            arr[0] = arr[i];                  // Set the first element of the array to the current element of the for loop
            arr[i] = temp;                   // Set the current element of the for loop to the value of "temp"
            heapify(arr, i, 0);          // Call the "heapify" method on the input array, passing in the current index of the for loop and 0
        }                                  //
        return arr;                       // Return the sorted array
    }

    private void heapify(int[] arr, int length, int i) {       // Declare a private method called "heapify" that takes an array of integers, an integer length, and an integer index
        int largest = i;                                      // Declare a variable "largest" and set it to the value of "i"
        int left = 2 * i + 1;                                // Declare a variable "left" and set it to 2 times "i" plus 1
        int right = 2 * i + 2;                              // Declare a variable "right" and set it to 2 times "i" plus 2
        if (left < length && arr[left] > arr[largest])     // If the "left" variable is less than the "length" variable and the element at the "left" index is greater than the element at the "largest" index
            largest = left;                               // Set the "largest" variable to the value of "left"
        if (right < length && arr[right] > arr[largest]) // If the "right" variable is less than the "length" variable and the element at the "right" index is greater than the element at the "largest" index
            largest = right;                            // Set the "largest" variable to the value of "right"
        if (largest != i) {                            // If the "largest" variable is not equal to "i"
            int swap = arr[i];                        // Declare a variable "swap" and set it to the element at the "i" index
            arr[i] = arr[largest];                   // Set the element at the "i" index to the element at the "largest" index
            arr[largest] = swap;                    // Set the element at the "largest" index to the value of "swap"
            heapify(arr, length, largest);         // Call the "heapify" method recursively, passing in the input array, the "length" variable, and the "largest" variable
        }
    }
    @Override                              // Indicates that this method overrides a method from a superclass
    public String getAlgorithmName() {    // Declare a public method called "getAlgorithmName" that returns a string
        return HeapSort.class.getName(); // Return the name of the class as a string
    }
}
