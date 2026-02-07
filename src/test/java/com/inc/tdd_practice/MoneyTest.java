package com.inc.tdd_practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Trace SPEC-FLOW-001
 */
public class MoneyTest {
    @Test
    public void testMultiplication() {
        Money five = new Dollar(5);
        Money product = five.times(2);
        assertEquals(new Dollar(10), product);
    }
}
