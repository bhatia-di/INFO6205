package edu.neu.coe.info6205.benchmark;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class InsertionSortBenchmark {

    public void testInsertionSortForRandomArray(int numberOfintergers) throws Exception {
        int nRuns = 10;
        Random random = new Random();
        Integer[] listInt;
        Benchmark<Integer[]> benchmark = new Benchmark_Timer<Integer[]>("SystemSort", null, InsertionSort::sort, null);
        final double time = benchmark.runFromSupplier(() -> Utilities.fillRandomArray(Integer.class, random, numberOfintergers, r -> r.nextInt()), nRuns);
        System.out.println(numberOfintergers + "     " + time);

    }
    public void testInsertionSortForReversedArray(int numberOfintergers) throws Exception {
        int nRuns = 10;
        Random random = new Random();
        Integer[] listInt;
        Benchmark<Integer[]> benchmark = new Benchmark_Timer<Integer[]>("SystemSort", null, InsertionSort::sort, null);
        final double time = benchmark.runFromSupplier(() -> createReversedArray(numberOfintergers), nRuns);
        System.out.println(numberOfintergers + "     " + time);

    }
    public void testInsertionSortForSortedArray(int numberOfintergers) throws Exception {
        int nRuns = 10;
        Random random = new Random();
        Integer[] listInt;
        Benchmark<Integer[]> benchmark = new Benchmark_Timer<Integer[]>("SystemSort", null, InsertionSort::sort, null);
        final double time = benchmark.runFromSupplier(() -> createSortedArray(numberOfintergers), nRuns);
        System.out.println(numberOfintergers + "     " + time);

    }
    public Integer[] createSortedArray(int noOfIntegers) {
        Integer[] result = new Integer[noOfIntegers];
        for (int index = 0; index< noOfIntegers; index++) {
            result [index] = index;
        }
        return result;
    }
    public Integer[] createReversedArray(int noOfIntegers) {
        Integer[] result = new Integer[noOfIntegers];
        for (int index = 0,value=noOfIntegers; index< noOfIntegers; index++,value--) {
            result [index] = value;
        }
        return result;
    }

   public static void main(String[] args) throws Exception {
       InsertionSortBenchmark insertionSortBenchmark = new InsertionSortBenchmark();
       int numberOfTrials = 12;
       int startNumberOfIntegers = 4;
       System.out.println("RANDOM ARRAY");
       System.out.println("Number Of Integer     " + "Mean Time");
       for (int index = 0; index < numberOfTrials; index++) {
           insertionSortBenchmark.testInsertionSortForRandomArray(startNumberOfIntegers);
           startNumberOfIntegers = startNumberOfIntegers * 2;

       }

       System.out.println("REVERSED ARRAY");
       System.out.println("Number Of Integer     |" + "Mean Time");
       for (int index = 0; index < numberOfTrials; index++) {
           insertionSortBenchmark.testInsertionSortForReversedArray(startNumberOfIntegers);
           startNumberOfIntegers = startNumberOfIntegers * 2;

       }

       System.out.println("SORTED ARRAY");
       System.out.println("Number Of Integer     |" + "Mean Time");
       for (int index = 0; index < numberOfTrials; index++) {
           insertionSortBenchmark.testInsertionSortForSortedArray(startNumberOfIntegers);
           startNumberOfIntegers = startNumberOfIntegers * 2;

       }
   }



}
