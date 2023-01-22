package com.jakubiak.runner;

import com.jakubiak.algorithms.HeapSort;
import com.jakubiak.algorithms.InsertionSort;
import com.jakubiak.algorithms.SortingAlgorithm;
import com.jakubiak.scenerios.Scenario;
import service.ArrayGenerator;

import java.util.Arrays;
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
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, "random"),
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, "first25pctSorted"),
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, "first50pctSorted"),
                    arrayGenerator.generateArray(parameters.size, parameters.min, parameters.max, "first75pctSorted")
            );


            System.out.println("Testing algorithm: " + algorithm.getAlgorithmName());

            testScenarios.forEach(testScenario -> {


                System.out.println("Scenario: " + testScenario.scenario.name());
                long start = System.currentTimeMillis();

                int[] sortedArray = algorithm.sort(testScenario.arr);

                long end = System.currentTimeMillis();

//                System.out.println("Sorted array: " + Arrays.toString(sortedArray));
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

    public record TestScenario(int[] arr, Scenario scenario) {
    }
}
