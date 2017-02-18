package com.asuper.abocha.smedialink;


import android.widget.Button;

public class Element {

    private int number;
    private float green;

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

    public float getGreen() {
        return green;
    }

    public void setGreen(float green) {
        this.green = green;
    }
}
