package pl.edu.pw.ee;

public class HashDoubleHashing<T extends Comparable<T>> extends HashOpenAdressing<T> {

    public HashDoubleHashing() {
        super();
    }

    public HashDoubleHashing(int size) {
        super(size);
    }

    @Override
    int hashFunc(int key, int i) {
        int m = getSize();
        int hash;
        if (m != 3) {
            hash = (key % m + i * (1 + (key % (m - 3)))) % m;
        } else {
            hash = (key % m + i) % m;
        }
        hash = hash < 0 ? -hash : hash;
        return hash;
    }
}
