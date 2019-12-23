package com.uniyaz.ui.views;


import com.vaadin.ui.TextField;

public class StTextField extends TextField {

    public StTextField() {
        addStyleName("st-text-field");
        setNullRepresentation("");
        setWidth(70, Unit.PERCENTAGE);
    }

    public StTextField(String caption) {
        this();
        setCaption(caption);
    }
}
