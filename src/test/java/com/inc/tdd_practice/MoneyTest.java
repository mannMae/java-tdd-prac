package com.inc.tdd_practice;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    void testMultiplication() {
        // [SPEC-MONEY-001]
        // Given I have a "Dollar" amount of 5
        Dollar five = new Dollar(5);

        // When I multiply it by 2
        five.times(2);

        // Then the result should be 10 Dollars
        assertThat(five.amount).isEqualTo(10);
    }
}
