package com.inc.tdd_practice;

public class Dollar {

    int amount; // Visibility: default (package-private) for testing

    public Dollar(int amount) {
        this.amount = amount;
    }

    public void times(int multiplier) {
        amount *= multiplier;
    }
}