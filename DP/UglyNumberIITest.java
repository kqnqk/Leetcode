import org.junit.Test;

import static org.junit.Assert.*;

public class UglyNumberIITest {

  @Test
  public void testNthUglyNumber() {
    UglyNumberII uglyNumberII = new UglyNumberII();
    
    int actual = uglyNumberII.nthUglyNumber(1);
    int expected = 1;
    assertEquals(expected, actual);
    
    actual = uglyNumberII.nthUglyNumber(10);
    expected = 12;
    assertEquals(expected, actual);
    
    actual = uglyNumberII.nthUglyNumber(15);
    expected = 24;
    assertEquals(expected, actual);
  }

  @Test 
  public void testNthUglyNumberEdgeCases() {
    UglyNumberII uglyNumberII = new UglyNumberII();
    
    int actual = uglyNumberII.nthUglyNumber(0);
    int expected = 0;
    assertEquals(expected, actual);
    
    actual = uglyNumberII.nthUglyNumber(-1);
    expected = 0;
    assertEquals(expected, actual);
  }

}
