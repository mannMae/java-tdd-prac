package com.inc.tdd_practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Trace SPEC-FLOW-001
 */
public class MoneyTest {
    @Test
    public void testMultiplication() {
        // Gherkin: Given 현재 지갑에 "5" "USD"가 들어있다
        Money five = new Dollar(5);

        // Gherkin: When 금액을 "2"배로 불린다
        Money product = five.times(2);

        // Gherkin: Then 결과는 "10" "USD"가 되어야 한다
        assertEquals(new Dollar(10), product);
    }

    @Test
    /**
     * @Trace REQ-MONEY-002
     */
    public void testEquality() {
        // Gherkin: Given 현재 지갑에 "5" "USD"가 들어있다
        Money five = new Dollar(5);

        // Gherkin: When "5" "USD"와 비교하면
        // Gherkin: Then 결과는 "True"여야 한다
        assertTrue(five.equals(new Dollar(5)));

        // Gherkin: When "6" "USD"와 비교하면
        // Gherkin: Then 결과는 "False"여야 한다
        assertFalse(five.equals(new Dollar(6)));
    }
}
