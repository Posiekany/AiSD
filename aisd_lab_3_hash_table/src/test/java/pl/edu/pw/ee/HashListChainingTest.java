package pl.edu.pw.ee;

import org.junit.Assert;
import org.junit.Test;

public class HashListChainingTest {

    HashListChaining hashlist;

    @Test
    public void checkGetNonexisting() {
        hashlist = new HashListChaining(5);
        Object expected = null;
        hashlist.add(18);
        hashlist.add(17);
        hashlist.add(25);
        Assert.assertEquals(expected, hashlist.get(20));
    }

    @Test
    public void checkGet25Alone() {
        hashlist = new HashListChaining(5);
        Object expected = 25;
        hashlist.add(25);
        Assert.assertEquals(expected, hashlist.get(25));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void checkDeleteNull() {
        hashlist = new HashListChaining(5);
        hashlist.add(25);
        hashlist.delete(null);
        Assert.assertFalse(true);
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void checkGetNull() {
        hashlist = new HashListChaining(5);
        hashlist.add(25);
        hashlist.get(null);
        Assert.assertFalse(true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkConstructor() {
        hashlist = new HashListChaining(-3);
        Assert.assertFalse(true);
    }

    @Test
    public void checkGet25WithOthers() {
        hashlist = new HashListChaining(5);
        Object expected = 25;
        hashlist.add(18);
        hashlist.add(17);
        hashlist.add(25);
        Assert.assertEquals(expected, hashlist.get(25));
    }

    @Test
    public void checkDelete25Alone() {
        hashlist = new HashListChaining(2);
        Object expected = null;
        hashlist.add(25);
        hashlist.delete(25);
        Assert.assertEquals(expected, hashlist.get(25));
    }

    @Test
    public void checkGetNonexistingAlone() {
        hashlist = new HashListChaining(1);
        Object expected = null;
        Assert.assertEquals(expected, hashlist.get(25));
    }

    @Test
    public void checkDelete25WithOthers() {
        hashlist = new HashListChaining(5);
        Object expected = null;
        hashlist.add(18);
        hashlist.add(17);
        hashlist.add(9);
        hashlist.add(3);
        hashlist.add(25);
        hashlist.delete(25);
        Assert.assertEquals(expected, hashlist.get(25));
    }

    @Test
    public void checkDeleteOneCell() {
        hashlist = new HashListChaining(1);
        Object expected = 25;
        hashlist.add(18);
        hashlist.add(17);
        hashlist.add(9);
        hashlist.add(3);
        hashlist.add(25);
        hashlist.delete(17);
        Assert.assertEquals(expected, hashlist.get(25));
    }

    @Test
    public void checkDeleteReturn() {
        hashlist = new HashListChaining(5);
        Object expected = 25;
        hashlist.add(18);
        hashlist.add(17);
        hashlist.add(25);
        Assert.assertEquals(expected, hashlist.delete(25));
    }

    @Test
    public void checkDeleteNil() {
        hashlist = new HashListChaining(5);
        Object expected = null;
        hashlist.add(18);
        hashlist.add(17);
        hashlist.add(25);
        Assert.assertEquals(expected, hashlist.delete(77));
    }
}
