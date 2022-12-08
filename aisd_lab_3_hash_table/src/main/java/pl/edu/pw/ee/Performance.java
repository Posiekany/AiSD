package pl.edu.pw.ee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Performance {

    public long performanceTest(HashListChaining hash) {
        String[] words = fillHash(hash);
        long time = testTime(hash, words);
        return time;
    }

    private String[] fillHash(HashListChaining hash) {
        String[] words;
        words = new String[100000];
        try ( BufferedReader reader = new BufferedReader(new FileReader("slowa.txt"))) {
            for (int i = 0; i < 100000; i++) {
                String currentLine = reader.readLine();
                words[i] = currentLine;
                hash.add(currentLine);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while reading/opening file!");
        }
        return words;
    }

    private long testTime(HashListChaining hash, String[] words) {
        long start;
        long finish;
        long avg = 0;
        long[] dane = new long[30];
        for (int j = 0; j < 30; j++) {
            start = System.nanoTime();
            for (int i = 0; i < 100000; i++) {
                hash.get(words[i]);
            }
            finish = System.nanoTime();
            dane[j] = finish - start;
        }
        Arrays.sort(dane);
        for (int i = 0; i < 10; i++) {
            avg += dane[10 + i];
        }
        return avg / 10;
    }
}
