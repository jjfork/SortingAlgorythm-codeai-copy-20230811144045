package com.jakubiak.runner;

import com.jakubiak.algorithms.*;
import com.jakubiak.scenerios.Scenario;
import com.jakubiak.scenerios.TestScenario;
import dataGeneration.ArrayGenerator;

import java.util.List;

public class SortingDemo {

    public static void main(String[] args) {

        var parameters = new Parameters(10000, 1, 10000); // creates new instance of Parameters class with size=10000, min=1, max=10000
        var arrayGenerator = new ArrayGenerator();                       // creates new instance of ArrayGenerator class
        System.out.println("Size of the arrays: " + parameters.size);    //print out the size of the arrays using parameters object
        List<SortingAlgorithm> algorithms = List.of(                   // creates a list of sorting algorithm objects
                new HeapSort(),                                       // creates new instance of HeapSort class
                new InsertionSort(),                                 // creates new instance of InsertionSort class
                new BubbleSort(),                                   // creates new instance of BubbleSort class
                new QuickSort()                                    // creates new instance of QuickSort class
        );

        algorithms.forEach(algorithm -> {
            //iterates through each sorting algorithm in the algorithms list
            List<TestScenario> testScenarios = List.of(
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.RANDOM),
                    //generates an array of random integers with size, min and max specified in the parameters object
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.ASCENDING),
                    //generates an array of integers in ascending order with size, min and max specified in the parameters object
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.DESCENDING),
                    //generates an array of integers in descending order with size, min and max specified in the parameters object
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.SORTED25),
                    //generates an array of integers with 25% of the elements sorted, with size, min and max specified in the parameters object
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.SORTED50),
                    //generates an array of integers with 50% of the elements sorted, with size, min and max specified in the parameters object
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.SORTED75)
                    //generates an array of integers with 75% of the elements sorted, with size, min and max specified in the parameters object
            );


            System.out.println("Testing algorithm: " + algorithm.getAlgorithmName());//print the name of the sorting algorithm that is currently being tested
            testScenarios.forEach(testScenario -> {                                 //loop through each test scenario
                System.out.println("Scenario: " + testScenario.scenario().name()); //print the name of the current test scenario
                long start = System.currentTimeMillis();                          //store the current time in milliseconds
                int[] sortedArray = algorithm.sort(testScenario.arr());          //sort the array using the current sorting algorithm
                long end = System.currentTimeMillis();                          //store the current time in milliseconds
                long elapsedTime = end - start;                                //calculate the elapsed time in milliseconds
                System.out.println("Time elapsed (Millis): " + elapsedTime);  //print the elapsed time
                System.out.println();
            });
            System.out.println();
            System.out.println();
        });


    }

    public record Parameters(int size, int min, int max) { // Declares a new record class called "Parameters" with 3 int fields "size", "min" and "max"
    }                                                     // end of class definition.

}
