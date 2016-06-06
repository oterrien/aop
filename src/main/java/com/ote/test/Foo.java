package com.ote.test;

public class Foo {

    private String bar;

    public String getBar() {
        return bar;
    }

    @Loggable
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