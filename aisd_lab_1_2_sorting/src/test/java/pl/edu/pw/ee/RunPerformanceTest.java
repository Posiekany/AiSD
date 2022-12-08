package pl.edu.pw.ee;

import java.io.IOException;
import org.junit.Test;

public class RunPerformanceTest {

    PerformanceTest perf = new PerformanceTest();

    @Test
    public void checkOneElement() throws IOException {
        AdderOptimist op = new AdderOptimist();
        AdderRandom ra = new AdderRandom();
        AdderPessimist pe = new AdderPessimist();
        perf.performanceTest("Optimistic.csv", op);
        perf.performanceTest("Random.csv", ra);
        perf.performanceTest("Passimist.csv", pe);
    }
}
