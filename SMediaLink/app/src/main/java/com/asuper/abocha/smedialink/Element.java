package com.asuper.abocha.smedialink;


import android.widget.Button;

public class Element {

    private int number;
    private float green;
    private boolean ischanged;

    Element(int number, int green) {
        this.green = green;
        this.number = number;
        ischanged = false;
    }

    public void setIschanged(boolean ischanged){
        this.ischanged = ischanged;
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
