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

    @Test
    void testEquality() {
        // [SPEC-MONEY-002]
        // Scenario: Compare same currency and amount
        // Given I have a "Dollar" amount of 5
        // And I have another "Dollar" amount of 5
        // Then they should be equal
        assertThat(new Dollar(5)).isEqualTo(new Dollar(5));

        // Scenario: Compare different amounts
        // Given I have a "Dollar" amount of 5
        // And I have another "Dollar" amount of 6
        // Then they should not be equal
        assertThat(new Dollar(5)).isNotEqualTo(new Dollar(6));
    }

    @Test
    void testFrancMultiplication() {
        // [SPEC-MONEY-003]
        // Scenario: Multiply franc amounts
        // Given I have a "Franc" amount of 5
        Franc five = new Franc(5);

        // When I multiply it by 2
        five.times(2);

        // Then the result should be 10 Francs
        assertThat(five.amount).isEqualTo(10);
    }
}
