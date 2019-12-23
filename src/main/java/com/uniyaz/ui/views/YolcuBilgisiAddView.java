package com.uniyaz.ui.views;

import com.uniyaz.MyUI;
import com.uniyaz.dao.UcusDao;
import com.uniyaz.dao.YolcuDao;
import com.uniyaz.domain.EnumCinsiyet;
import com.uniyaz.domain.EnumGidisTuru;
import com.uniyaz.domain.Ucus;
import com.uniyaz.domain.Yolcu;
import com.uniyaz.ui.components.SaveButton;
import com.vaadin.ui.*;

import java.util.*;

public class YolcuBilgisiAddView extends BaseAddView {

    private Panel panel;
    private StTextField idField;
    private StTextField adField;
    private StTextField soyadField;
    private StTextField emailField;
    private StTextField telefonField;
    private StTextField tcKimlikNoField;
    private DateField dogumTarihiField;
    private SaveButton kaydetButton;
    private ComboBox cinsiyetSec;
    private Label label;

    public YolcuBilgisiAddView() {
    }

    @Override
    public void buildMainLayout() {
        panel = new Panel();
        panel.setSizeFull();
        addComponent(panel);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.setMargin(true);


        ucusKaydiniGetir(verticalLayout);

        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        horizontalLayout1.setSizeFull();
        horizontalLayout1.setMargin(true);

        
        List<EnumCinsiyet> enumCinsiyetList = new ArrayList();
        enumCinsiyetList.addAll(Arrays.asList(EnumCinsiyet.values()));


        cinsiyetSec = new ComboBox("Cinsiyet Seç", enumCinsiyetList);
        cinsiyetSec.setInputPrompt(" ");
        horizontalLayout1.addComponent(cinsiyetSec);


        idField = new StTextField("Kişi No");
        idField.setEnabled(false);
        horizontalLayout1.addComponent(idField);

        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        horizontalLayout2.setSizeFull();
        horizontalLayout2.setMargin(true);
        
        adField = new StTextField("Adınız");
        horizontalLayout2.addComponent(adField);
        
        soyadField = new StTextField("Soyadınız");
        horizontalLayout2.addComponent(soyadField);

        HorizontalLayout horizontalLayout3 = new HorizontalLayout();
        horizontalLayout3.setSizeFull();
        horizontalLayout3.setMargin(true);
        
        tcKimlikNoField = new StTextField("TC Kimlik Numaranız");
        horizontalLayout3.addComponent(tcKimlikNoField);
        
        dogumTarihiField = new DateField("Doğum Tarihiniz");
        horizontalLayout3.addComponent(dogumTarihiField);

        HorizontalLayout horizontalLayout4 = new HorizontalLayout();
        horizontalLayout4.setSizeFull();
        horizontalLayout4.setMargin(true);

        emailField = new StTextField("E-mail");
        horizontalLayout4.addComponent(emailField);

        telefonField = new StTextField("Telefon");
        horizontalLayout4.addComponent(telefonField);

        kaydetButton = new SaveButton();
        kaydetButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                saveView();
                ucusKaydiniGetir(verticalLayout);
                OdemeBilgisiAddView odemeBilgisiAddView = new OdemeBilgisiAddView();
                verticalLayout.addComponent(odemeBilgisiAddView);

            }
        });
        horizontalLayout4.addComponent(kaydetButton);
        
        verticalLayout.addComponents(horizontalLayout1, horizontalLayout2, horizontalLayout3,horizontalLayout4);
        panel.setContent(verticalLayout);
        
    }

    private void ucusKaydiniGetir(VerticalLayout verticalLayout) {

        label = new Label("Uçuş Bilgileriniz");
        UcusDao ucusDao = new UcusDao();
        ucusDao.getUcusBilgileri();
//        Label text = new Label( ucus.getId() + " " + ucus.getKalkisYeri() + " " + ucus.getVarisYeri() + " "
//                + ucus.getKalkisYeri() + " " + ucus.getVarisYeri() + " " + ucus.getYolcuSayisi());
//        verticalLayout.addComponent(text);
    }

    public void fillViewByUcus(Yolcu yolcu) {
        idField.setValue(yolcu.getId().toString());
        adField.setValue(yolcu.getAd());
        soyadField.setValue(yolcu.getSoyad());
        emailField.setValue(yolcu.getEmail());
        telefonField.setValue(yolcu.getTelefon());
        tcKimlikNoField.setValue(yolcu.getTcKimlikNo());
        dogumTarihiField.setDateFormat(String.valueOf(yolcu.getDogumTarihi()));
        cinsiyetSec.setValue(yolcu.getEnumCinsiyet());
    }

    @Override
    public void saveView() {

        Long idFieldValue = null;
        if (idField.getValue() != "") {
            idFieldValue = Long.parseLong(idField.getValue());
        }
        String adFieldValue = adField.getValue();
        String soyadFieldValue = soyadField.getValue();
        String emailFieldValue = emailField.getValue();
        String telefonFieldValue = telefonField.getValue();
        String tcKimlikNoFieldValue = tcKimlikNoField.getValue();
        Date dogumTarihiFieldValue = dogumTarihiField.getValue();
        EnumCinsiyet enumCinsiyet = (EnumCinsiyet) cinsiyetSec.getValue();

        Yolcu yolcu = new Yolcu();
        
        yolcu.setId(idFieldValue);
        yolcu.setAd(adFieldValue);
        yolcu.setSoyad(soyadFieldValue);
        yolcu.setEmail(emailFieldValue);
        yolcu.setTelefon(telefonFieldValue);
        yolcu.setTcKimlikNo(tcKimlikNoFieldValue);
        yolcu.setDogumTarihi(dogumTarihiFieldValue);
        yolcu.setEnumCinsiyet(enumCinsiyet);

        YolcuDao yolcuDao = new YolcuDao();
        yolcu = yolcuDao.saveYolcu(yolcu);
        idField.setValue(yolcu.getId().toString());

        Notification.show("İşlem Başarılı");

    }
}
