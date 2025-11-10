package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testAddNormal() {
        Main main = new Main();
        assertEquals(2, main.add(1, 1), "1 + 1 should equal 2");
    }

    @Test
    void testAddZero() {
        Main main = new Main();
        assertEquals(Integer.MAX_VALUE, main.add(Integer.MAX_VALUE, 0), "MAX + 0 should be MAX");
    }

    @Test
    void testNegativeAThrows() {
        Main main = new Main();
        assertThrows(IllegalArgumentException.class, () -> main.add(-1, 5), "Negative a should throw IllegalArgumentException");
    }

    @Test
    void testNegativeBThrows() {
        Main main = new Main();
        assertThrows(IllegalArgumentException.class, () -> main.add(5, -1), "Negative b should throw IllegalArgumentException");
    }

    @Test
    void testOverflowThrows() {
        Main main = new Main();
        assertThrows(ArithmeticException.class, () -> main.add(Integer.MAX_VALUE, 1), "Adding 1 to MAX_VALUE should throw ArithmeticException due to overflow");
    }

}
