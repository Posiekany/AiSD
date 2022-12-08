package pl.edu.pw.ee;

import java.util.List;
import pl.edu.pw.ee.services.HeapExtension;
import pl.edu.pw.ee.services.HeapInterface;

public class Heap<T extends Comparable<T>> implements HeapInterface<T>, HeapExtension {

    private List<T> data;

    public Heap(List<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.data = data;
    }

    Heap() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void put(T item) {
        if (item != null) {
            data.add(item);
        } else {
            throw new IllegalArgumentException("Cannot put null!");
        }
    }

    @Override
    public T pop() {
        if (data.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Heap is empty!");
        }
        T temp;
        build();
        temp = data.remove(0);
        return temp;
    }

    public List<T> getData() {
        return data;
    }

    @Override
    public void build() {
        int n = data.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i, n);
        }
    }

    @Override
    public void heapify(int startId, int endId) {
        if (startId >= data.size() || endId > data.size() || startId < 0 || endId < 0) {
            throw new IllegalArgumentException("I refuse to accept that arguments (startId/endId)");
        }
        int n = startId;
        while (n != -1 && n < endId) {
            n = compareChildren(n, endId);
        }

    }

    private void swap(int idOne, int idTwo) {
        T temp = data.get(idOne);
        data.set(idOne, data.get(idTwo));
        data.set(idTwo, temp);
    }

    private int compareChildren(int node, int endId) {
        if (node * 2 + 2 < endId) {
            T childOne = data.get(node * 2 + 1);
            T childTwo = data.get(node * 2 + 2);
            T thisNode = data.get(node);
            if (thisNode.compareTo(childOne) == -1 && childOne.compareTo(childTwo) != -1) {
                swap(node, node * 2 + 1);
                return node * 2 + 1;
            }
            if (thisNode.compareTo(childTwo) == -1) {
                swap(node, node * 2 + 2);
                return node * 2 + 2;
            }
        }
        if (node * 2 + 1 < endId) {
            T child = data.get(node * 2 + 1);
            T thisNode = data.get(node);
            if (thisNode.compareTo(child) == -1) {
                swap(node, node * 2 + 1);
                return node * 2 + 1;
            }
        }
        return -1;
    }

}
