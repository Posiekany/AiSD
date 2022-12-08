package pl.edu.pw.ee;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RedBlackTreeTest {

    @Test
    public void putTest() {
        RedBlackTree<Integer, String> tree = new RedBlackTree();
        tree.put(5, "1");
    }

    @Test
    public void getTest() {
        RedBlackTree<Integer, String> tree = new RedBlackTree();
        tree.put(5, "1");
        assertEquals("1", tree.get(5));
    }

    @Test
    public void deleteTest() {
        RedBlackTree<Integer, String> tree = new RedBlackTree();
        tree.put(5, "1");
        tree.deleteMax();
        assertEquals(null, tree.get(5));
    }

    @Test
    public void getOrderTest() {
        RedBlackTree<Integer, String> tree = new RedBlackTree();
        tree.put(5, "1");
        tree.put(7, "2");
        tree.put(11, "3");
        tree.put(3, "4");
        tree.put(7, "5");
        tree.put(1, "6");
        tree.getPreOrder();
        tree.getInOrder();
        tree.getPostOrder();
    }

}
