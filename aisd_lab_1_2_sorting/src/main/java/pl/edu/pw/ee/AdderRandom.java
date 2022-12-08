package pl.edu.pw.ee;

import java.util.Random;
import pl.edu.pw.ee.services.Adding;

public class AdderRandom implements Adding {

    @Override
    public void add(double[] nums, int number) {
        Random rand = new Random();
        for (int j = 0; j < number; j++) {
            nums[j] = rand.nextDouble();
        }
    }

}
