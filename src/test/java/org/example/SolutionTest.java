package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SolutionTest {

    Solution testSolution = new Solution();
    String testRefer = testSolution.getCharReference("ForTestOnly");

    @Test
    public void TestDecoder() {
        // Test for appropriate return values
        String toDecode = "fc/GGj RJmG.";
        String answer = "HELLO WORLD";

        String result = testSolution.decode(toDecode);

        assertEquals(answer, result, "The decoder does not work");
    }

    @Test
    public void TestEncoder() {
        String toEncode = "Hello world";
        String result = testSolution.encode(toEncode);

        assertNotNull(result, "Returned result is null");
        assertNotEquals(result, toEncode, "Returned result did not get encoded");
        assertNotEquals(result, "", "Results in empty string");

    }

    @Test
    public void TestRandomizerRange() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateRandomNumGen = Solution.class.getDeclaredMethod("randomNumGen");
        privateRandomNumGen.setAccessible(true);

        for (int i = 0; i < 50; i++) {
            int value = (int) privateRandomNumGen.invoke(testSolution);
            assertTrue(value >= 1 && value < 44, "Value is out of range: " + value);
        }
    }

    @Test
    public void TestConvertToNumArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Check if the returns appropriate num array based on chart
        int[] answer = {5, 2, 43, 6, 6, 9, -32, 17, 9, 12, 6, 42};
        char[] toConvert = {'F', 'C', '/', 'G', 'G', 'J', ' ', 'R', 'J', 'M', 'G', '.'};

        Method privateConvertToNumArray = Solution.class.getDeclaredMethod("convertToNumArray", char[].class);
        privateConvertToNumArray.setAccessible(true);
        int[] result = (int[]) privateConvertToNumArray.invoke(testSolution, toConvert);

        assertArrayEquals(answer, result, "The int array does not match");
    }

    @Test
    public void TestConvertNumToCharArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        char[] answer = {'F', 'C', '/', 'G', 'G', 'J', ' ', 'R', 'J', 'M', 'G', '.'};
        int[] toConvert = {5, 2, 43, 6, 6, 9, -32, 17, 9, 12, 6, 42};

        Method privateConvertNumToCharArray = Solution.class.getDeclaredMethod("convertNumToCharArray", int[].class);
        privateConvertNumToCharArray.setAccessible(true);
        char[] result = (char[]) privateConvertNumToCharArray.invoke(testSolution, toConvert);

        assertArrayEquals(answer, result, "The char array does not match");
    }

    @Test
    public void TestEncodeNumArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Check if the sample decode value increases appropriately
        int[] answer = {5, 2, 43, 6, 6, 9, -32, 17, 9, 12, 6, 42};
        int[] toEncode = {7, 4, 11,11,14,-32,22,14,17,11,3};

        Method privateEncodeNumArray = Solution.class.getDeclaredMethod("encodeNumArray", int[].class, int.class);
        privateEncodeNumArray.setAccessible(true);
        int[] result = (int[]) privateEncodeNumArray.invoke(testSolution, toEncode, 5);

        assertArrayEquals(answer, result, "Encoded int array does not match");
    }

    @Test
    public void TestEdgeEncodeNumArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[] answer = {4, 41, 42, 43, 0, 1, 2, 3, 4};
        int[] toEncode = {1, 2, 3, 4, 5, 6, 7, 8};

        Method privateEncodeNumArray = Solution.class.getDeclaredMethod("encodeNumArray", int[].class, int.class);
        privateEncodeNumArray.setAccessible(true);
        int[] result = (int[]) privateEncodeNumArray.invoke(testSolution, toEncode, 4);

        assertArrayEquals(answer, result, "Encoder int fails to appropriately reset");
    }

    @Test
    public void TestDecodeNumArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Check if the sample encode value decreases appropriately
        int[] answer = {7, 4, 11,11,14,-32,22,14,17,11,3};
        int[] toDecode = {5, 2, 43, 6, 6, 9, -32, 17, 9, 12, 6, 42};

        Method privateDecodeNumArray = Solution.class.getDeclaredMethod("decodeNumArray", int[].class);
        privateDecodeNumArray.setAccessible(true);
        int[] result = (int[]) privateDecodeNumArray.invoke(testSolution, toDecode);

        assertArrayEquals(answer, result, "Decoded int array does not match");
    }

    @Test
    public void TestEdgeDecodeNumArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[] answer = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] toDecode = {4, 41, 42, 43, 0, 1, 2, 3, 4};

        Method privateDecodeNumArray = Solution.class.getDeclaredMethod("decodeNumArray", int[].class);
        privateDecodeNumArray.setAccessible(true);
        int[] result = (int[]) privateDecodeNumArray.invoke(testSolution, toDecode);

        assertArrayEquals(answer, result, "Decoder int fails to appropriately reset" );
    }


}
