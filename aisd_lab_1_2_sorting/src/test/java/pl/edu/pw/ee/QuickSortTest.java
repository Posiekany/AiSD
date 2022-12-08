package pl.edu.pw.ee;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.pw.ee.services.Sorting;

public class QuickSortTest {

    final double EPS = 0;
    Sorting sorter = new QuickSort();

    @Test(expected = IllegalArgumentException.class)
    public void checkIfNull() {
        //given
        double[] nums = null;
        //when
        sorter.sort(nums);
        //then
        Assert.assertFalse(true);
    }

    @Test
    public void checkOneElement() {
        //given
        double[] nums = {1};
        double[] expected = {1};
        //when
        sorter.sort(nums);
        //then
        Assert.assertArrayEquals(nums, expected, EPS);

    }

    @Test
    public void checkSortedIntegers() {
        //given
        double[] nums = {1, 2, 3, 4, 5};
        double[] expected = {1, 2, 3, 4, 5};
        //when
        sorter.sort(nums);
        //then
        Assert.assertArrayEquals(nums, expected, EPS);
    }

    @Test
    public void checkUnsortedIntegers() {
        //given
        double[] nums = {5, 4, 3, 2, 1};
        double[] expected = {1, 2, 3, 4, 5};
        //when
        sorter.sort(nums);
        //then
        Assert.assertArrayEquals(nums, expected, EPS);
    }

    @Test
    public void checkUnsortedNegativeIntegers() {
        //given
        double[] nums = {-97, -75, -162, -572};
        double[] expected = {-572, -162, -97, -75};
        //when
        sorter.sort(nums);
        //then
        Assert.assertArrayEquals(nums, expected, EPS);
    }

    @Test
    public void checkMixed() {
        //given
        double[] nums = {176.3, 89.0, 0, -56.36, 0.72, -0.62, 13.5};
        double[] expected = {-56.36, -0.62, 0, 0.72, 13.5, 89.0, 176.3};
        //when
        sorter.sort(nums);
        //then
        Assert.assertArrayEquals(nums, expected, EPS);
    }

    @Test
    public void checkLargeAndSmallNumbers() {
        //given
        double[] nums = {999999999, 999999998, 999999997, 999999996, -999999999, -999999998, -999999997, -999999996};
        double[] expected = {-999999999, -999999998, -999999997, -999999996, 999999996, 999999997, 999999998, 999999999};
        //when
        sorter.sort(nums);
        //then
        Assert.assertArrayEquals(nums, expected, EPS);
    }

    @Test
    public void checkRepetition() {
        //given
        double[] nums = {3, 0, 3, -1, 2, -1, 3, 2, 0};
        double[] expected = {-1, -1, 0, 0, 2, 2, 3, 3, 3};
        //when
        sorter.sort(nums);
        //then
        Assert.assertArrayEquals(nums, expected, EPS);
    }

    @Test
    public void checkEmptyTable() {
        //given
        double[] nums = {};
        double[] expected = {};
        //when
        sorter.sort(nums);
        //then
        Assert.assertArrayEquals(nums, expected, EPS);
    }

}
