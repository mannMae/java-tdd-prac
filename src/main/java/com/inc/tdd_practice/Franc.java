package com.inc.tdd_practice;

public class Franc {
    public int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    public void times(int multiplier) {
        amount *= multiplier;
    }
}
