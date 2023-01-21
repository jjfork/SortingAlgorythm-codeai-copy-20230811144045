package com.jakubiak.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import service.ArrayGenerator;
import service.SortingService;

import java.util.Arrays;

@Component
public class Main implements CommandLineRunner {

    @Autowired
    private SortingService sortingService;

    @Autowired
    private ArrayGenerator arrayGenerator;

    @Override
    public void run(String... args) throws Exception {
        int[] randomArray = arrayGenerator.generateArray(10, 1, 100, "random");
        int[] first25pctSortedArray = arrayGenerator.generateArray(10, 1, 100, "first25pctSorted");
        int[] first50pctSortedArray = arrayGenerator.generateArray(10, 1, 100, "first50pctSorted");
        int[] first75pctSortedArray = arrayGenerator.generateArray(10, 1 , 100, first75pctSortedArray);

        System.out.println("Original Random Array: " + Arrays.toString(randomArray));
        sortingService.bubbleSort(randomArray);
        System.out.println("Sorted Random Array: " + Arrays.toString(randomArray));

        System.out.println("Original First 25% Sorted Array: " + Arrays.toString(first25pctSortedArray));
        sortingService.insertionSort(first25pctSortedArray);
        System.out.println("Sorted First 25% Sorted Array: " + Arrays.toString(first25pctSortedArray));

        System.out.println("Original First 50% Sorted Array: " + Arrays.toString(first50pctSortedArray));
        sortingService.heapSort(first50pctSortedArray);
        System.out.println("Sorted First 50% Sorted Array: " + Arrays.toString(first50pctSortedArray));
    }
}
