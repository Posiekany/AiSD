package pl.edu.pw.ee;

import pl.edu.pw.ee.services.HashTable;

public class HashListChaining implements HashTable {

    private final Elem nil = null;
    private Elem[] hashElems;
    private int nElem;

    public int getSize() {
        return hashElems.length;
    }

    private class Elem {

        private Object value;
        private Elem next;

        Elem(Object value, Elem nextElem) {
            this.value = value;
            this.next = nextElem;
        }
    }

    public HashListChaining(int size) {
        if (size >= 1) {
            hashElems = new Elem[size];
            initializeHash();
        } else {
            throw new IllegalArgumentException("Size cant be 0 or lower!");
        }
    }

    @Override
    public void add(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null!");
        }
        int hashCode = value.hashCode();
        int hashId = countHashId(hashCode);
        Elem oldElem = hashElems[hashId];
        while (oldElem != nil && !oldElem.equals(value)) {
            oldElem = oldElem.next;
        }
        if (oldElem != nil) {
            oldElem.value = value;
        } else {
            hashElems[hashId] = new Elem(value, hashElems[hashId]);
            nElem++;
        }
    }

    @Override
    public Object get(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null!");
        }
        int hashCode = value.hashCode();
        int hashId = countHashId(hashCode);

        Elem elem = hashElems[hashId];

        while (elem != nil && !elem.value.equals(value)) {
            elem = elem.next;
        }

        return elem != nil ? elem.value : nil;
    }

    public Object delete(Object value) {        //Na potrzeby testów metoda delete jest Object'em
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null!");
        }
        int hashCode = value.hashCode();
        int hashId = countHashId(hashCode);
        Elem elem = hashElems[hashId];
        if (elem.value.equals(value)) {
            System.out.print("2137");
            Object temp = elem.value;
            if (elem.next == nil) {
                hashElems[hashId] = nil;
            } else {
                hashElems[hashId] = elem.next;
            }
            return temp;
        }
        while (elem.next != nil && !elem.next.value.equals(value)) {
            elem = elem.next;
        }
        Object temp;
        if (elem.next != nil) {
            temp = elem.next.value;
            elem.next = elem.next.next;
        } else {
            temp = nil;
        }
        return temp;
    }

    public double countLoadFactor() {
        double size = hashElems.length;
        return nElem / size;
    }

    private void initializeHash() {
        int n = hashElems.length;

        for (int i = 0; i < n; i++) {
            hashElems[i] = nil;
        }
    }

    private int countHashId(int hashCode) {
        int n = hashElems.length;

        return Math.abs(hashCode) % n;
    }

}
