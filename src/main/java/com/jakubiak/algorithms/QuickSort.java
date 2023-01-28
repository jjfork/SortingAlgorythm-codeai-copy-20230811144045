package com.jakubiak.algorithms;

import java.util.Stack;

public class QuickSort implements SortingAlgorithm {                                 //defining the class and its implementation of the SortingAlgorithm interface

    private static int partition(int[] input, int position, int start, int end) { // partition method starts here with input array and pivot position, start and end indices as parameters
        int low = start;                                                         // initialize low pointer to the start index
        int high = end - 2;                                                     // initialize high pointer to the second last index
        int piv = input[position];                                             // pivot element is set to the element at the pivot position
        swap(input, position, end - 1);                                    // swap pivot element with the last element
        while (low < high) {                                                 // while low pointer is less than high pointer
            if (input[low] < piv) {                                         // if element at low pointer is less than pivot
                low++;                                                     // increment low pointer
            } else if (input[high] >= piv) {                              // if element at high pointer is greater than or equal to pivot
                high--;                                                  // decrement high pointer
            } else {
                swap(input, low, high);                                // if both conditions are false, swap the element at low pointer with the element at high pointer
            }
        }
        int idx = high;                                             // initialize idx to high pointer
        if (input[high] < piv) {                                   // if element at high pointer is less than pivot
            idx++;                                                // increment idx
        }
        swap(input, end - 1, idx);                            // swap the last element with the element at idx
        return idx;                                             // return idx
    }

    private static void swap(int[] arr, int i, int j) { //defining a private static method named "swap" that takes in an int array "arr", an int "i", and an int "j" as arguments
        int temp = arr[i];                             //initializing a variable "temp" equal to the element at index "i" of the array "arr"
        arr[i] = arr[j];                              //reassigning the value at index "i" of the array "arr" to be the value at index "j" of the array "arr"
        arr[j] = temp;                               //reassigning the value at index "j" of the array "arr" to be the value stored in the "temp" variable
    }



    public int[] sort(int[] arr) {                        //overrides the sort method from the SortingAlgorithm interface
        Stack<Integer> stack = new Stack();              //creating a new stack
        stack.push(0);                            //pushing the start index of array
        stack.push(arr.length);                        //pushing the end index of array
        while (!stack.isEmpty()) {                    //while stack is not empty
            int end = stack.pop();                   //pop the end index from stack
            int start = stack.pop();                //pop the start index from stack
            if (end - start < 2) {                 //if the range of array is less than 2
                continue;                         //continue with next iteration
            }
            int p = start + ((end - start) / 2);//calculating pivot index
            p = partition(arr, p, start, end); //partition the array using pivot
            stack.push(p + 1);          //push the end of right partition
            stack.push(end);                 //push the end of array
            stack.push(start);              //push the start of left partition
            stack.push(p);                 //push the start of right partition
        }
        return arr;                      //returning the sorted array
    }

    @Override                                  //overriding the getAlgorithmName method from the SortingAlgorithm interface
    public String getAlgorithmName() {        //
        return InsertionSort.class.getName();//returns the name of the class as a string
    }
}
