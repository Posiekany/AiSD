package pl.edu.pw.ee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

public class PerformanceTest {

    Performance perf = new Performance();

    @Test
    public void checkPerformance() throws IOException {
        HashOpenAdressing hash;
        long result;
        int[] testedValues = {512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 4093, 8191, 16381, 32771, 65537, 131071, 262147};
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("PerformanceTest.txt"))) {
            writer.write("LP" + "\t" + "Rozmiar hasza" + "\t" + "Średni czas dodawania 100000 elementów" + "\n");
            for (int i = 0; i < testedValues.length; i++) {
                hash = new HashQuadraticProbing(testedValues[i], 0.5, 0.5);
                result = perf.performanceTestPut(hash);
                writer.write(i + 1 + ".\t" + testedValues[i] + "\t\t" + result + "\n");
            }
        }

    }
}
