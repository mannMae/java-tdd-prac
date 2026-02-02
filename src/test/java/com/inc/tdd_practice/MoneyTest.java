package com.inc.tdd_practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

    @Test
    public void testMultiplication() {
        // Given I have 5 USD
        Dollar five = new Dollar(5);

        // When I multiply it by 2
        five.times(2);

        // Then the result should be 10 USD
        assertEquals(10, five.amount);
    }
}