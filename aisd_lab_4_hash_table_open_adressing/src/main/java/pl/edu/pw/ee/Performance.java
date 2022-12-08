package pl.edu.pw.ee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Performance {

    public long performanceTestPut(HashOpenAdressing hash) {
        String[] words = fillWords();
        return testTime(hash, words, hash.getSize());
    }

    private String[] fillWords() {
        String[] words;
        words = new String[100000];
        try ( BufferedReader reader = new BufferedReader(new FileReader("slowa.txt"))) {
            for (int i = 0; i < 100000; i++) {
                String currentLine = reader.readLine();
                words[i] = currentLine;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while reading/opening file!");
        }
        return words;
    }

    private long testTime(HashOpenAdressing hash, String[] words, int size) {
        long start;
        long finish;
        long avg = 0;
        long[] dane = new long[30];
        for (int j = 0; j < 30; j++) {
            start = System.nanoTime();
            for (int i = 0; i < 100000; i++) {
                hash.put(words[i]);
            }
            finish = System.nanoTime();
            hash = new HashLinearProbing(size);
            dane[j] = finish - start;
        }
        Arrays.sort(dane);
        for (int i = 0; i < 10; i++) {
            avg += dane[10 + i];
        }
        return avg / 10;
    }

}
