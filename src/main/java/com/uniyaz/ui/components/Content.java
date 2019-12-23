package com.uniyaz.ui.components;

import com.uniyaz.ui.views.OdemeBilgisiAddView;
import com.uniyaz.ui.views.UcusEkleView;
import com.uniyaz.ui.views.YolcuBilgisiAddView;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class Content extends VerticalLayout {

    public Content() {
        UcusEkleView ucusBilgileri = new UcusEkleView();
       addComponent(ucusBilgileri);
//
//        YolcuBilgisiAddView yolcuBilgisiAddView = new YolcuBilgisiAddView();
//        addComponent(yolcuBilgisiAddView);
//
//        OdemeBilgisiAddView odemeBilgisiAddView = new OdemeBilgisiAddView();
//        addComponent(odemeBilgisiAddView);
    }

    public void setContent(Component component) {
        this.removeAllComponents();
        addComponent(component);
    }
}
