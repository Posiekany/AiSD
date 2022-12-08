package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Sorting;

public class SelectionSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums cannot be null");
        }
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minID = i;
            for (int j = i; j < n; j++) {
                if (nums[j] < nums[minID]) {
                    minID = j;
                }
            }
            swap(nums, minID, i);
        }
    }

    private void swap(double[] array, int firstIndex, int secoundIndex) {
        double temp = array[firstIndex];
        array[firstIndex] = array[secoundIndex];
        array[secoundIndex] = temp;
    }
}
