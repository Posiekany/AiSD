package pl.edu.pw.ee;

import pl.edu.pw.ee.exceptions.NotImplementedException;
import pl.edu.pw.ee.services.HashTable;

public abstract class HashOpenAdressing<T extends Comparable<T>> implements HashTable<T> {

    private class DeletedElement implements Comparable<T> {

        public DeletedElement() {
        }

        @Override
        public int compareTo(T o) {
            return 0;
        }
    }

    private final T nil = null;
    private final T del = (T) new DeletedElement();
    private int size;
    private int nElems = 0;
    T[] hashElems;
    private final double correctLoadFactor;

    HashOpenAdressing() {
        this(2039); // initial size as random prime number
    }

    HashOpenAdressing(int size) {
        validateHashInitSize(size);
        this.size = size;
        this.hashElems = (T[]) new Comparable[this.size];
        this.correctLoadFactor = 0.75;
        this.nElems = 0;
    }

    @Override
    public void put(T newElem) {
        validateInputElem(newElem);
        if (get(newElem) != null) {
            nElems--;
        }
        resizeIfNeeded();
        int key = newElem.hashCode();
        int i = 0;
        int hashCode = hashFunc(key, i);
        while (hashElems[hashCode] != nil && hashElems[hashCode] != del && hashElems[hashCode].compareTo(newElem) != 0) {
            i++;
            hashCode = hashFunc(key, i);
            if (i > size) {
                doubleResize();
            }
        }
        hashElems[hashCode] = newElem;
        nElems++;
    }

    @Override
    public T get(T elem) {
        validateInputElem(elem);
        int key = elem.hashCode();
        int hashID = hashFunc(key, 0);
        T searched = hashElems[hashID];
        int i = 0;
        while (searched != nil && searched.compareTo(elem) != 0) {
            i++;
            hashID = hashFunc(key, i);
            searched = hashElems[hashID];
            if (i > size) {
                return null;
            }
        }
        if (searched != null && searched != del) {
            return searched;
        } else {
            return null;
        }
    }

    @Override
    public void delete(T elem) {
        validateInputElem(elem);
        int key = elem.hashCode();
        int hashCode = hashFunc(key, 0);
        T searched = hashElems[hashCode];
        int i = 1;
        while (searched != nil && searched.compareTo(elem) != 0) {
            hashCode = hashFunc(key, i);
            searched = hashElems[hashCode];
            i++;
            if (i > size) {
                return;
            }
        }
        hashElems[hashCode] = del;
    }

    private void validateHashInitSize(int initialSize) {
        if (initialSize < 1) {
            throw new IllegalArgumentException("Initial size of hash table cannot be lower than 1!");
        }
    }

    private void validateInputElem(T newElem) {
        if (newElem == null) {
            throw new IllegalArgumentException("Input elem cannot be null");
        }
    }

    abstract int hashFunc(int key, int i);

    int getSize() {
        return size;
    }

    private void resizeIfNeeded() {
        double loadFactor = countLoadFactor();

        if (loadFactor >= correctLoadFactor) {
            doubleResize();
        }
    }

    private double countLoadFactor() {
        return ((double) nElems / (double) size);
    }

    private void doubleResize() {
        this.nElems = 0;
        T[] temp = hashElems;
        this.size *= 2;
        hashElems = (T[]) new Comparable[size];
        for (T temp1 : temp) {
            if (temp1 != null) {
                put(temp1);
            }
        }
    }

}
