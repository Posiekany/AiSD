package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Adding;

public class AdderPessimist implements Adding {

    @Override
    public void add(double[] nums, int number) {
        for (int j = 0; j < number; j++) {
            nums[j] = number - j;
        }
    }

}
