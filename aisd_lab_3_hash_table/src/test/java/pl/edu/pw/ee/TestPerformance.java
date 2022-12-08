package pl.edu.pw.ee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

public class TestPerformance {

    Performance perf = new Performance();

    @Test
    public void checkPerformance() throws IOException {
        HashListChaining hash;
        long result;
        int[] testedValues = {4096, 8192, 16384, 32768, 65536, 131072, 262144, 4093, 8191, 16381, 32771, 65537, 131071, 262147};
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("PerformanceTest.txt"))) {
            writer.write("LP" + "\t" + "Rozmiar hasza" + "\t" + "Średni czas wyszukania 100000 elementów" + "\n");
            for (int i = 0; i < testedValues.length; i++) {
                hash = new HashListChaining(testedValues[i]);
                result = perf.performanceTest(hash);
                writer.write(i + 1 + ".\t" + testedValues[i] + "\t\t" + result + "\n");
            }
        }
    }
}
