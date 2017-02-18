package com.asuper.abocha.smedialink;


import android.widget.Button;

public class Element {

    private int number;
    private Button button;

    Element(int number, Button button){
        this.button = button;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
