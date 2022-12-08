package pl.edu.pw.ee;

import java.lang.reflect.Field;
import org.junit.Test;
import pl.edu.pw.ee.services.HashTable;
import static org.junit.Assert.*;

public class HashDoubleHashingTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenInitialSizeIsLowerThanOne() {
        // given
        int initialSize = 0;
        // when
        HashTable<Double> unusedHash = new HashDoubleHashing<>(initialSize);
        // then
        assert false;
    }

    @Test
    public void should_CorrectlyAddNewElems_WhenNotExistInHashTable() {
        // given
        HashTable<String> emptyHash = new HashDoubleHashing<>();
        String newEleme = "nothing special";
        // when
        int nOfElemsBeforePut = getNumOfElems(emptyHash);
        emptyHash.put(newEleme);
        int nOfElemsAfterPut = getNumOfElems(emptyHash);
        // then
        assertEquals(0, nOfElemsBeforePut);
        assertEquals(1, nOfElemsAfterPut);
    }

    @Test
    public void getTest() {
        // given
        HashTable<String> emptyHash = new HashDoubleHashing<>();
        String newEleme = "nothing special";
        // when
        emptyHash.put(newEleme);
        // then
        assertEquals(newEleme, emptyHash.get(newEleme));
    }

    @Test
    public void getNilTest() {
        // given
        HashTable<String> emptyHash = new HashDoubleHashing<>();
        String newEleme = "nothing special";
        // when
        emptyHash.put(newEleme);
        // then
        assertNull(emptyHash.get("Null String"));
    }

    @Test
    public void resizeTest() {
        // given
        HashTable<Integer> emptyHash = new HashDoubleHashing<>(1);
        // when
        for (int i = 0; i < 33; i++) {
            emptyHash.put(i);
        }
        // then
        assertTrue(true);
    }

    @Test
    public void size3Test() {
        // given
        HashTable<Integer> emptyHash = new HashDoubleHashing<>(3);
        // when
        for (int i = 0; i < 33; i++) {
            emptyHash.put(i);
        }
        for (int i = 0; i < 33; i++) {
            emptyHash.delete(i);
        }
        // then
        assertNull(emptyHash.get(7));
    }

    @Test
    public void addManyValuesTest() {
        // given
        HashTable<Integer> emptyHash = new HashDoubleHashing<>(3);
        // when
        for (int i = 0; i < 33; i++) {
            emptyHash.put(i);
        }
        for (int i = 0; i < 33; i++) {
            emptyHash.put(i);
        }
        // then
        assertEquals((Integer) 32, emptyHash.get(32));
    }

    @Test
    public void addManyValuesThenDeleteTest() {
        // given
        HashTable<Integer> emptyHash = new HashDoubleHashing<>(3);
        // when
        for (int i = 0; i < 33; i++) {
            emptyHash.put(i);
        }
        for (int i = 0; i < 33; i++) {
            emptyHash.delete(i);
        }
        // then
        assertNull(emptyHash.get(32));
    }

    @Test
    public void addEvenMoreValuesTest() {
        // given
        HashTable<Integer> emptyHash = new HashDoubleHashing<>(3);
        // when
        for (int i = 0; i < 2138; i++) {
            emptyHash.put(i);
        }
        // then
        assertEquals((Integer) 2137, emptyHash.get(2137));
    }

    @Test
    public void addEvenMoreValuesThenDeleteTest() {
        // given
        HashTable<Integer> emptyHash = new HashDoubleHashing<>(3);
        // when
        for (Integer i = 0; i < 2138; i++) {
            emptyHash.put(i);
            emptyHash.delete(i);
        }
        // then
        assertNull(emptyHash.get(2137));
    }

    @Test
    public void delTest() {
        // given
        HashTable<String> emptyHash = new HashDoubleHashing<>();
        String newEleme = "nothing special";
        // when
        emptyHash.put(newEleme);
        emptyHash.delete(newEleme);
        // then
        assertNull(emptyHash.get(newEleme));
    }

    @Test
    public void delIntTest() {
        // given
        HashTable<Integer> emptyHash = new HashDoubleHashing<>();
        // when
        emptyHash.put(1);
        emptyHash.put(1);
        emptyHash.put(1);
        emptyHash.put(1);
        emptyHash.delete(1);
        // then
        assertNull(emptyHash.get(1));
    }

    private int getNumOfElems(HashTable<?> hash) {
        String fieldNumOfElems = "nElems";
        try {
            System.out.println(hash.getClass().getSuperclass().getName());
            Field field = hash.getClass().getSuperclass().getDeclaredField(fieldNumOfElems);
            field.setAccessible(true);
            return field.getInt(hash);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
