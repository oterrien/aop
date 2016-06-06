package com.ote.test;

import lombok.Getter;

public class Foo {

    private String bar;

    public String getBar() {
        return bar;
    }

    @Trigger(method = "triggered")
    public void setBar(String bar) {
        this.bar = bar;
    }

    @Loggable
    public double power(int x, int p) {
        return Math.pow(x, p);
    }

    private void triggered() {
        System.out.println("TRIGGERED");
    }

}