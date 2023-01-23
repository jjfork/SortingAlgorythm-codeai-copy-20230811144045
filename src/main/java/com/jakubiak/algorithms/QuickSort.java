package com.jakubiak.algorithms;

public class QuickSort implements SortingAlgorithm {
    @Override
    public  int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    return arr;
}

    private  void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(arr, left, right);
        sort(arr, left, pivotIndex - 1);
        sort(arr, pivotIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotValue = arr[right];
        int pivotIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(arr, pivotIndex, right);
        return pivotIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String getAlgorithmName() {
        return QuickSort.class.getName();
    }
}
