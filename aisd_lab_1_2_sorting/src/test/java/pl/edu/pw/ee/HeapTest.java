package pl.edu.pw.ee;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class HeapTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkIfNull() {
        //given
        List<Double> data = new ArrayList<>();
        Heap heap = new Heap(data);
        //when
        heap.pop();
        //then
        Assert.assertFalse(true);
    }

    @Test
    public void checkPut() {
        //given
        List<Double> data = new ArrayList<>();
        List<Double> expected = new ArrayList<>();
        expected.add(5.3);
        Heap heap = new Heap(data);
        Heap exp = new Heap(expected);
        //when
        heap.put(5.3);
        //then
        Assert.assertEquals(heap.getData(), exp.getData());

    }

    @Test
    public void checkPop() {
        //given
        List<Double> data = new ArrayList<>();
        List<Double> expected = new ArrayList<>();
        Heap heap = new Heap(data);
        Heap exp = new Heap(expected);
        //when
        heap.put(5.3);
        heap.pop();
        //then
        Assert.assertEquals(heap.getData(), exp.getData());
    }

    @Test
    public void checkHeapify() {
        //given
        List<Double> data = new ArrayList<>();
        List<Double> expected = new ArrayList<>();
        expected.add(35.7);
        expected.add(13.1);
        expected.add(12.6);
        expected.add(3.2);
        expected.add(5.3);
        expected.add(9.1);
        Heap heap = new Heap(data);
        Heap exp = new Heap(expected);
        //when
        heap.put(5.3);
        heap.put(35.7);
        heap.put(12.6);
        heap.put(3.2);
        heap.put(13.1);
        heap.put(9.1);
        heap.build();
        //then
        Assert.assertEquals(heap.getData(), exp.getData());
    }

    @Test
    public void checkBuild() {
        //given
        List<Double> data = new ArrayList<>();
        List<Double> expected = new ArrayList<>();
        expected.add(5.3);
        expected.add(3.4);
        expected.add(1.98);
        expected.add(2.73);
        Heap heap = new Heap(data);
        Heap exp = new Heap(expected);
        //when
        heap.put(3.4);
        heap.put(2.73);
        heap.put(1.98);
        heap.put(5.3);
        heap.build();
        //then
        Assert.assertEquals(heap.getData(), exp.getData());
    }

    @Test
    public void checkHeapify3() {
        //given
        List<Double> data = new ArrayList<>();
        List<Double> expected = new ArrayList<>();
        expected.add(33.7);
        expected.add(7.3);
        expected.add(7.3);
        Heap heap = new Heap(data);
        Heap exp = new Heap(expected);
        //when
        heap.put(7.3);
        heap.put(7.3);
        heap.put(33.7);
        heap.heapify(0, 3);
        //then
        Assert.assertEquals(heap.getData(), exp.getData());
    }

    @Test
    public void checkHeapify4() {
        //given
        List<Double> data = new ArrayList<>();
        List<Double> expected = new ArrayList<>();
        expected.add(33.7);
        expected.add(7.3);
        expected.add(5.6);
        expected.add(2.7);
        expected.add(1.3);
        expected.add(0.9);
        Heap heap = new Heap(data);
        Heap exp = new Heap(expected);
        //when
        heap.put(7.3);
        heap.put(33.7);
        heap.put(5.6);
        heap.put(2.7);
        heap.put(1.3);
        heap.put(0.9);
        heap.heapify(0, 6);
        //then
        Assert.assertEquals(heap.getData(), exp.getData());
    }

    @Test
    public void checkBuild2() {
        //given
        List<Double> data = new ArrayList<>();
        List<Double> expected = new ArrayList<>();
        expected.add(33.7);
        expected.add(7.3);
        expected.add(2.7);
        expected.add(0.9);
        expected.add(5.6);
        expected.add(1.3);
        Heap heap = new Heap(data);
        Heap exp = new Heap(expected);
        //when
        heap.put(1.3);
        heap.put(5.6);
        heap.put(2.7);
        heap.put(0.9);
        heap.put(7.3);
        heap.put(33.7);
        heap.build();
        //then
        Assert.assertEquals(heap.getData(), exp.getData());
    }

    @Test
    public void checkBuild3() {
        //given
        List<Double> data = new ArrayList<>();
        List<Double> expected = new ArrayList<>();
        expected.add(124.1);
        expected.add(8.7);
        expected.add(33.7);
        expected.add(5.6);
        expected.add(7.3);
        expected.add(2.7);
        expected.add(4.5);
        expected.add(2.7);
        expected.add(0.9);
        expected.add(2.9);
        expected.add(0.0);
        expected.add(1.3);
        Heap heap = new Heap(data);
        Heap exp = new Heap(expected);
        //when
        heap.put(1.3);
        heap.put(5.6);
        heap.put(2.7);
        heap.put(0.9);
        heap.put(7.3);
        heap.put(33.7);
        heap.put(4.5);
        heap.put(2.7);
        heap.put(8.7);
        heap.put(2.9);
        heap.put(0.0);
        heap.put(124.1);
        heap.build();
        //then
        Assert.assertEquals(heap.getData(), exp.getData());
    }

}
