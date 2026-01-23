package ru.otus.java.basic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HomeWorkPanichenkoTest {

    @Test
    void getElementsAfterLastOneTest_NormalCase() {
        int[] input = {1, 2, 1, 2, 2};
        int[] expected = {2, 2};
        int[] actual = HomeWorkPanichenko.getElementsAfterLastOne(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsAfterLastOneTest_Negative_NoOnes() {
        int[] input = {2, 2, 2, 2};
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> HomeWorkPanichenko.getElementsAfterLastOne(input)
        );
        assertEquals("Массив не содержит единиц", exception.getMessage());
    }

    @Test
    void getElementsAfterLastOneTest_OneIsLast() {
        int[] input = {2, 2, 1};
        int[] expected = {};
        int[] actual = HomeWorkPanichenko.getElementsAfterLastOne(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsAfterLastOneTest_SingleOne() {
        int[] input = {1};
        int[] expected = {};
        int[] actual = HomeWorkPanichenko.getElementsAfterLastOne(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsAfterLastOneTest_OneIsFirst() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {2, 3, 4, 5};
        int[] actual = HomeWorkPanichenko.getElementsAfterLastOne(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsAfterLastOneTest_Negative_EmptyArray() {
        int[] input = {};
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> HomeWorkPanichenko.getElementsAfterLastOne(input)
        );
        assertEquals("Массив пустой или null", exception.getMessage());
    }

    @Test
    void getElementsAfterLastOneTest_NullInsteadOfArray() {
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> HomeWorkPanichenko.getElementsAfterLastOne(null)
        );
        assertEquals("Массив пустой или null", exception.getMessage());
    }

    @Test
    void containsOnlyOneAndTwoTest_ValidCase1() {
        int[] input = {1, 2};
        assertTrue(HomeWorkPanichenko.containsOnlyOneAndTwo(input));
    }

    @Test
    void containsOnlyOneAndTwoTest_ValidCase2() {
        int[] input = {1, 2, 2, 1};
        assertTrue(HomeWorkPanichenko.containsOnlyOneAndTwo(input));
    }

    @Test
    void containsOnlyOneAndTwoTest_OnlyOnes() {
        int[] input = {1, 1, 1, 1};
        assertFalse(HomeWorkPanichenko.containsOnlyOneAndTwo(input));
    }

    @Test
    void containsOnlyOneAndTwoTest_OnlyTwos() {
        int[] input = {2, 2, 2, 2};
        assertFalse(HomeWorkPanichenko.containsOnlyOneAndTwo(input));
    }

    @Test
    void containsOnlyOneAndTwoTest_ContainsOtherNumber() {
        int[] input = {1, 3};
        assertFalse(HomeWorkPanichenko.containsOnlyOneAndTwo(input));
    }

    @Test
    void containsOnlyOneAndTwoTest_ContainsMultipleOtherNumbers() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        assertFalse(HomeWorkPanichenko.containsOnlyOneAndTwo(input));
    }

    @Test
    void containsOnlyOneAndTwoTest_SingleElement() {
        int[] input = {1};
        assertFalse(HomeWorkPanichenko.containsOnlyOneAndTwo(input));
    }

    @Test
    void containsOnlyOneAndTwoTest_EmptyArray() {
        int[] input = {};
        assertFalse(HomeWorkPanichenko.containsOnlyOneAndTwo(input));
    }

    @Test
    void containsOnlyOneAndTwoTest_NullArray() {
        assertFalse(HomeWorkPanichenko.containsOnlyOneAndTwo(null));
    }

    @Test
    void containsOnlyOneAndTwoTest_ValidLongArray() {
        int[] input = {1, 2, 1, 2, 1, 2, 2, 1};
        assertTrue(HomeWorkPanichenko.containsOnlyOneAndTwo(input));
    }


    @Test
    void containsOnlyOneAndTwoTest_ValidWithManyMixedTwoAndOnes() {
        int[] input = {2, 2, 1, 1, 2, 1, 2, 1};
        assertTrue(HomeWorkPanichenko.containsOnlyOneAndTwo(input));
    }
}