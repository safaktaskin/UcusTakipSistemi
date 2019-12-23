package com.uniyaz.ui.views;

import com.uniyaz.dao.OdemeDao;
import com.uniyaz.domain.EnumOdemeTuru;
import com.uniyaz.domain.Odeme;
import com.uniyaz.ui.components.SaveButton;
import com.vaadin.ui.*;

import java.util.*;

public class OdemeBilgisiAddView extends BaseAddView {

    private Panel panel;
    private TextField idField;
    private StTextField kartNoField;
    private DateField sonKullanmaTarihiField;
    private StTextField cvvField;
    private Label toplamTutarLabel;
    private ComboBox odemeTuruCombo;
    private SaveButton satinAlButton;

    public OdemeBilgisiAddView() {
    }

    @Override
    public void buildMainLayout() {
        panel = new Panel();
        panel.setSizeFull();
        addComponent(panel);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.setMargin(true);

        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        horizontalLayout1.setSizeFull();
        horizontalLayout1.setMargin(true);

        idField = new TextField("Referans No");
        idField.setEnabled(false);
        horizontalLayout1.addComponent(idField);

        List<EnumOdemeTuru> enumOdemeTuruList = new ArrayList();
        enumOdemeTuruList.addAll(Arrays.asList(EnumOdemeTuru.values()));

        odemeTuruCombo = new ComboBox("Ödeme Türü", enumOdemeTuruList);
        odemeTuruCombo.setInputPrompt(" ");
        horizontalLayout1.addComponent(odemeTuruCombo);

        kartNoField = new StTextField("Kart No");
        horizontalLayout1.addComponent(kartNoField);

        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        horizontalLayout2.setSizeFull();
        horizontalLayout2.setMargin(true);

        sonKullanmaTarihiField = new DateField("Son Kullanma Tarihi");
        horizontalLayout2.addComponent(sonKullanmaTarihiField);

        cvvField = new StTextField("CVV");
        horizontalLayout2.addComponent(cvvField);

        HorizontalLayout horizontalLayout3 = new HorizontalLayout();
        horizontalLayout3.setSizeFull();
        horizontalLayout3.setMargin(true);

        Random r = new Random();
        int Low = 100;
        int High = 10000;
        int Result = r.nextInt(High - Low) + Low;
        toplamTutarLabel = new Label("Toplam Tutar: " + Result + " TL");
        horizontalLayout3.addComponent(toplamTutarLabel);
        
        satinAlButton = new SaveButton();
        satinAlButton.setCaption("Satın Al");
        satinAlButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                saveView();
            }
        });
        horizontalLayout3.addComponent(satinAlButton);
        verticalLayout.addComponents(horizontalLayout1,horizontalLayout2,horizontalLayout3);
        
        panel.setContent(verticalLayout);
    }

    public void fillViewByodeme(Odeme odeme) {
        idField.setValue(odeme.getId().toString());
        odemeTuruCombo.setValue(odeme.getEnumOdemeTuru());
        kartNoField.setValue(odeme.getKartNo());
        sonKullanmaTarihiField.setDateFormat(String.valueOf(odeme.getSonKullanmaTarihi()));
        cvvField.setValue(odeme.getCvv());
        toplamTutarLabel.setValue(String.valueOf(odeme.getToplamTutar()));
    }

    @Override
    public void saveView() {

        Long idFieldValue = null;
        if (idField.getValue() != "") {
            idFieldValue = Long.parseLong(idField.getValue());
        }
        EnumOdemeTuru enumOdemeTuru = (EnumOdemeTuru) odemeTuruCombo.getValue();
        String kartNoFieldValue = kartNoField.getValue();
        String cvvFieldValue = cvvField.getValue();
        Date sonKullanmaTarihiFieldValue = sonKullanmaTarihiField.getValue();
        String toplamTutarLabelValue = toplamTutarLabel.getValue();

        Odeme odeme = new Odeme();

        odeme.setId(idFieldValue);
        odeme.setEnumOdemeTuru(enumOdemeTuru);
        odeme.setKartNo(kartNoFieldValue);
        odeme.setCvv(cvvFieldValue);
        odeme.setSonKullanmaTarihi(sonKullanmaTarihiFieldValue);
        odeme.setToplamTutar(String.valueOf(toplamTutarLabelValue));


        OdemeDao odemeDao = new OdemeDao();
        odeme = odemeDao.saveOdeme(odeme);
        idField.setValue(odeme.getId().toString());

        Notification.show("Satın alım gerçekleşti!");

    }
}
