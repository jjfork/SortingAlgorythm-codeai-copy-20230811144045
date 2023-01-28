package com.jakubiak.algorithms;

import java.util.Stack;

public class QuickSort implements SortingAlgorithm {

    private static int partition(int[] input, int position, int start, int end) {
        int low = start;
        int high = end - 2;
        int piv = input[position];
        swap(input, position, end - 1);
        while (low < high) {
            if (input[low] < piv) {
                low++;
            } else if (input[high] >= piv) {
                high--;
            } else {
                swap(input, low, high);
            }
        }
        int idx = high;
        if (input[high] < piv) {
            idx++;
        }
        swap(input, end - 1, idx);
        return idx;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    @Override
    public int[] sort(int[] arr) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        stack.push(arr.length);
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) {
                continue;
            }
            int p = start + ((end - start) / 2);
            p = partition(arr, p, start, end);
            stack.push(p + 1);
            stack.push(end);
            stack.push(start);
            stack.push(p);
        }
        return arr;
    }

    @Override
    public String getAlgorithmName() {
        return QuickSort.class.getName();
    }


}
