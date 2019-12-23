package com.uniyaz.ui.components;

import com.uniyaz.MyUI;
import com.vaadin.ui.VerticalLayout;

public class General extends VerticalLayout {

    public General() {
        Header header = new Header();
        addComponent(header);
        MyUI myUI = (MyUI) getUI().getCurrent();
        myUI.setHeader(header);

        Content content = new Content();
        addComponent(content);
    }

}
