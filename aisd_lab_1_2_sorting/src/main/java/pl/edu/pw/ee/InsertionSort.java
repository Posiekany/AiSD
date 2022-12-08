package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Sorting;

public class InsertionSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums cannot be null");
        }
        int n = nums.length;
        int j;
        double saved;
        for (int i = 1; i < n; i++) {
            saved = nums[i];
            j = i;

            while (j > 0 && nums[j - 1] > saved) {
                nums[j] = nums[j - 1];
                j--;

            }
            nums[j] = saved;
        }

    }

}
