package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SolutionTest {
    @Mock
    Random mockRandom;

    Solution testSolution = new Solution();
    char[] testRefer = testSolution.getCharReference("ForTestOnly");

    @Test
    public void TestEncoder() {
        // Test for appropriate method invokes
    }

    @Test
    public void TestDecoder() {
        // Test for appropriate method invokes
    }

    @Test
    public void TestRandomizer() throws NoSuchMethodException {
        // Use the mock object
        when(mockRandom.nextInt()).thenReturn(0); // Optional: Define behavior for nextInt()

        // Call the private methpd
        Method privateRandomNumGen = Solution.class.getDeclaredMethod("randomNumGen", void.class);
        privateRandomNumGen.setAccessible(true);

        // Verify that nextInt was called once
        verify(mockRandom, times(1)).nextInt();
    }

    @Test
    public void TestRandomizerRange() {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            int value = random.nextInt(43) + 1;
            assertTrue(value >= 1 && value < 44, "Value is out of range: " + value);
        }
    }

    @Test
    public void TestConvertToNumArray() {
        // Check if the returns appropriate num array based on chart
    }

    @Test
    public void TestEncodeNumArray() {
        // Check if the sample decode value increases appropriately
    }

    @Test
    public void TestEdgeEncodeNumArray() {
        // Ensure it is a ring and does not exceed length of ref
    }

    @Test
    public void TestDecodeNumArray() {
        // Check if the sample encode value decreases appropriately
    }

    @Test
    public void TestEdgeDecodeNumArray() {
        // Ensure it is a ring and does not exceed length of ref
    }


}
