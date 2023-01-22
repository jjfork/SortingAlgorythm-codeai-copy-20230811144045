package com.jakubiak.runner;

import com.jakubiak.algorithms.HeapSort;
import com.jakubiak.algorithms.InsertionSort;
import com.jakubiak.algorithms.SortingAlgorithm;
import com.jakubiak.scenerios.Scenario;
import com.jakubiak.scenerios.TestScenario;
import dataGeneration.ArrayGenerator;

import java.util.List;

public class SortingDemo {

    public static void main(String[] args) {

        var parameters = new Parameters(10000, 1, 10000);
        var arrayGenerator = new ArrayGenerator();
        List<SortingAlgorithm> algorithms = List.of(
                new HeapSort(),
                new InsertionSort()
        );

        algorithms.forEach(algorithm -> {


            List<TestScenario> testScenarios = List.of(
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.RANDOM),
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.ASCENDING),
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.DESCENDING),
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.SORTED25),
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.SORTED50),
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, Scenario.SORTED75)
            );


            System.out.println("Testing algorithm: " + algorithm.getAlgorithmName());

            testScenarios.forEach(testScenario -> {


                System.out.println("Scenario: " + testScenario.scenario().name());
                long start = System.currentTimeMillis();

                int[] sortedArray = algorithm.sort(testScenario.arr());

                long end = System.currentTimeMillis();

//                System.out.println("Sorted array: " + Arrays.toString(sortedArray));
                // tutaj se zrob tak zeby sie nazwa arraya wyswietlała
                long elapsedTime = end - start;
                System.out.println("Time elapsed (Millis): " + elapsedTime);
                System.out.println();

            });

            System.out.println();
            System.out.println();
        });


    }

    record Parameters(int size, int min, int max) {
    }


}
