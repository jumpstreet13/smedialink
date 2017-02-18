package com.asuper.abocha.smedialink;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class HomeForElements {

    private static HomeForElements homeForElements;
    private List<Element> elements;

    public static HomeForElements get(Context context) {
        if (homeForElements == null) {
            homeForElements = new HomeForElements(context);
        }
        return homeForElements;
    }

    private HomeForElements(Context context) {
        elements = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Element element = new Element(i, 0);
            elements.add(element);
        }
    }

    public List<Element> getElements() {
        return elements;
    }

    public Element getElement(int number) {
        for (Element element : elements) {
            if (element.getNumber() == number) {
                return element;
            }
        }
        return null;
    }


}
