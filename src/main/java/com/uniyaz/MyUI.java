package com.uniyaz;

import javax.servlet.annotation.WebServlet;

import com.uniyaz.ui.components.General;
import com.uniyaz.ui.components.Header;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 *
 */
@Theme("mytheme")
@Widgetset("com.uniyaz.MyAppWidgetset")
public class MyUI extends UI {

    private Header header;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        General general = new General();
        setContent(general);
//            YolcuDao yolcuDao = new YolcuDao();
//            Yolcu yolcu = new Yolcu();
//            yolcu.setAd("Şafak");
//            yolcuDao.saveYolcu(yolcu);
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
