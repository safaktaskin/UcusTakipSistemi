package com.uniyaz.ui.views;

import com.uniyaz.dao.UcusDao;
import com.uniyaz.domain.EnumGidisTuru;
import com.uniyaz.domain.Ucus;
import com.uniyaz.domain.Yolcu;
import com.uniyaz.ui.components.Content;
import com.uniyaz.ui.components.SaveButton;
import com.vaadin.ui.*;

import java.util.*;


public class UcusEkleView extends BaseAddView {

    private Panel panel;
    private TextField idField;
    private StTextField kalkisYeriField;
    private StTextField varisYeriField;
    private TextField yolcuSayisiField;
    private DateField kalkisTarihiField;
    private DateField donusTarihiField;
    private SaveButton kaydetButton;
    private ComboBox secGidisDonusCombo;
    private Content content;
    public UcusEkleView() {
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


        List<EnumGidisTuru> enumGidisTuruList = new ArrayList();
        enumGidisTuruList.addAll(Arrays.asList(EnumGidisTuru.values()));


        secGidisDonusCombo = new ComboBox("Gidiş Türü", enumGidisTuruList);
        secGidisDonusCombo.setInputPrompt(" ");
        horizontalLayout1.addComponent(secGidisDonusCombo);


        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        horizontalLayout2.setSizeFull();
        horizontalLayout2.setMargin(true);

        idField = new TextField("Referans No");
        idField.setEnabled(false);
        horizontalLayout2.addComponent(idField);

        kalkisYeriField = new StTextField("Kalkış Yeri");
        horizontalLayout2.addComponent(kalkisYeriField);

        varisYeriField = new StTextField("Varış Yeri");
        horizontalLayout2.addComponent(varisYeriField);

        HorizontalLayout horizontalLayout3 = new HorizontalLayout();
        horizontalLayout3.setSizeFull();
        horizontalLayout3.setMargin(true);

        yolcuSayisiField = new TextField("Yolcu Sayısı");
        horizontalLayout3.addComponent(yolcuSayisiField);

        kalkisTarihiField = new DateField("Kalkış Tarihi");
        horizontalLayout3.addComponent(kalkisTarihiField);

        donusTarihiField = new DateField("Dönüş Tarihi");

        horizontalLayout3.addComponent(donusTarihiField);

        HorizontalLayout horizontalLayout4 = new HorizontalLayout();
        horizontalLayout4.setSizeFull();
        horizontalLayout4.setMargin(true);

        kaydetButton = new SaveButton();
        kaydetButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                saveView();
                YolcuBilgisiAddView yolcuBilgisiAddView = new YolcuBilgisiAddView();
                addComponent(yolcuBilgisiAddView);

            }
        });
        horizontalLayout4.addComponent(kaydetButton);

        verticalLayout.addComponents(horizontalLayout1, horizontalLayout2, horizontalLayout3, horizontalLayout4);
        panel.setContent(verticalLayout);
    }

    private void ucusKaydiniGetir(VerticalLayout verticalLayout) {
        UcusDao ucusDao = new UcusDao();


        Ucus ucus = new Ucus();
        Label label = new Label("Uçuş Bilgileriniz");
        Label text = new Label( ucus.getId() + " " + ucus.getKalkisYeri() + " " + ucus.getVarisYeri() + " "
                + ucus.getKalkisYeri() + " " + ucus.getVarisYeri() + " " + ucus.getYolcuSayisi());
        verticalLayout.addComponent(text);
    }


    private void addComponent(Yolcu yolcu) {
    }

    public void fillViewByUcus(Ucus ucus) {
        idField.setValue(ucus.getId().toString());
        kalkisYeriField.setValue(ucus.getKalkisYeri());
        varisYeriField.setValue(ucus.getVarisYeri());
        yolcuSayisiField.setValue(String.valueOf(ucus.getYolcuSayisi()));
        kalkisTarihiField.setDateFormat(String.valueOf(ucus.getKalkisTarihi()));
        donusTarihiField.setDateFormat(String.valueOf(ucus.getDonusTarihi()));
        secGidisDonusCombo.setValue(String.valueOf(ucus.getEnumGidisTuru()));
    }

    @Override
    public void saveView() {
        Long idFieldValue = null;
        if (idField.getValue() != "") {
            idFieldValue = Long.parseLong(idField.getValue());
        }
        String kalkisYeriFieldValue = kalkisYeriField.getValue();
        String varisYeriFieldValue = varisYeriField.getValue();
        int yolcuSayisiFieldValue = Integer.parseInt(yolcuSayisiField.getValue());
        Date kalkisTarihiFieldValue = kalkisTarihiField.getValue();
        Date varisTarihiFieldValue = donusTarihiField.getValue();
        EnumGidisTuru enumGidisTuru = (EnumGidisTuru) secGidisDonusCombo.getValue();

        Ucus ucus = new Ucus();

        ucus.setId(idFieldValue);
        ucus.setKalkisYeri(kalkisYeriFieldValue);
        ucus.setVarisYeri(varisYeriFieldValue);
        ucus.setYolcuSayisi(yolcuSayisiFieldValue);
        ucus.setKalkisTarihi(kalkisTarihiFieldValue);
        ucus.setDonusTarihi(varisTarihiFieldValue);
        ucus.setEnumGidisTuru(enumGidisTuru);

        UcusDao ucusDao = new UcusDao();
        ucus = ucusDao.saveUcus(ucus);
        idField.setValue(ucus.getId().toString());

        Notification.show("İşlem Başarılı");

    }
}
