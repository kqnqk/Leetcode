import static org.junit.Assert.*;
import org.junit.Test;

public class TestContinousSubarrays {
    
    @Test
    public void testNormalCase() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        int[] expected = {6, 15, 24};
        int[] actual = Test.continousSubarays(input, k);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testEmptyArray() {
        int[] input = {};
        int k = 3;
        int[] expected = {};
        int[] actual = Test.continousSubarays(input, k);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testKGreaterThanLength() {
        int[] input = {1, 2, 3};
        int k = 5;
        int[] expected = {};
        int[] actual = Test.continousSubarays(input, k);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testKEqualToLength() {
        int[] input = {1, 2, 3};
        int k = 3;
        int[] expected = {6};
        int[] actual = Test.continousSubarays(input, k);
        assertArrayEquals(expected, actual); 
    }
}
