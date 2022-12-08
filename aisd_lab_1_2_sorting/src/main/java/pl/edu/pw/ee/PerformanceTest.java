package pl.edu.pw.ee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import pl.edu.pw.ee.services.Adding;
import pl.edu.pw.ee.services.Sorting;

public class PerformanceTest {

    public void performanceTest(String fileName, Adding adder) throws IOException {
        Sorting in = new InsertionSort();
        Sorting he = new HeapSort();
        Sorting qu = new QuickSort();
        Sorting re = new RefAlgorithm();
        Sorting se = new SelectionSort();
        String output;
        double[] dane;
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= 250; i++) {
                dane = new double[i * 50];
                adder.add(dane, i * 50);

                output = Integer.toString(i * 50) + ";" + testTime(dane, in) + ";" + testTime(dane, se) + ";" + testTime(dane, he) + ";" + testTime(dane, qu) + ";" + testTime(dane, re) + "\n";
                writer.write(output);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("File problem detected!");
        }
    }

    private String testTime(double[] nums, Sorting sorter) {
        double[] forSorting = nums;
        long start;
        long finish;
        long avg = 0;
        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            sorter.sort(forSorting);
            finish = System.nanoTime();
            avg += finish - start;
            forSorting = nums.clone();
        }
        return Long.toString(avg / 10);
    }
}
