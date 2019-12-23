package com.uniyaz.ui.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Header extends VerticalLayout {

    private Label h1;

    public Header() {
        setWidth(100, Unit.PERCENTAGE);
        setHeight(100, Unit.PIXELS);

        h1 = new Label();
        h1.setValue("HOŞ GELDİNİZ");
        h1.addStyleName(ValoTheme.LABEL_H1);
        h1.addStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        addComponent(h1);
    }

    public void setHeaderTitle(String title) {
        h1.setValue(title);
    }
}
