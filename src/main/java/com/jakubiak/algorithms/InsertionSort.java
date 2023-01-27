package com.jakubiak.algorithms;

public class InsertionSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    @Override
    public String getAlgorithmName() {
        return InsertionSort.class.getName();
    }
}
