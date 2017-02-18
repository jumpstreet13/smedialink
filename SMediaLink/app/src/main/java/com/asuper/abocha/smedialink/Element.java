package com.asuper.abocha.smedialink;


import android.widget.Button;

public class Element {

    private int number;
    private int green;

    Element(int number, int green) {
        this.green = green;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }
}
