package pl.edu.pw.ee;

import java.lang.reflect.Field;
import org.junit.Test;
import static org.junit.Assert.*;
public class SurpriseTest {

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest1() {
        // given
        int K=-1;
        String input="MKMKMKMMKMK";
        Surprise sur=new Surprise();
        // when
        sur.countChanges(input, K);
        // then
        assert false;
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest2() {
        // given
        int K=2;
        String input=null;
        Surprise sur=new Surprise();
        // when
        sur.countChanges(input, K);
        // then
        assert false;
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest3() {
        // given
        int K=1000000;
        String input="KMKMKMKMKMKKKKKMMMKMKM";
        Surprise sur=new Surprise();
        // when
        sur.countChanges(input, K);
        // then
        assert false;
    }
    
    @Test
    public void tooLargeKTest() {
        // given
        int K=32;
        String input="KMKMKMKKMKM";
        Surprise sur=new Surprise();
        // when
        int result=sur.countChanges(input, K);
        // then
        assertEquals(-1,result);
    }
    
    @Test
    public void kZeroTest() {
        // given
        int K=0;
        String input="MMM";
        Surprise sur=new Surprise();
        // when
        int result=sur.countChanges(input, K);
        // then
        assertEquals(3,result);
    }
    
    @Test
    public void largerSimpleTest() {
        // given
        int K=3;
        String input="MMM";
        Surprise sur=new Surprise();
        // when
        int result=sur.countChanges(input, K);
        // then
        assertEquals(0,result);
    }
    
    @Test
    public void fromTheWhiteboardTest() {
        // given
        int K=3;
        String input="KMMKKKKM";
        Surprise sur=new Surprise();
        // when
        int result=sur.countChanges(input, K);
        // then
        assertEquals(1,result);
    }
    
    @Test
    public void tooManyTest() {
        // given
        int K=3;
        String input="MMMMMMMMMMMMMMMMMMM";
        Surprise sur=new Surprise();
        // when
        int result=sur.countChanges(input, K);
        // then
        assertEquals(4,result);
    }

}
