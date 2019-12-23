/*
 * Copyright 2019 Universal Bilgi Teknolojileri.
 *
 * UKL 1.1 lisansı ile lisanslanmıştır. Bu dosyanın l,isans koşullarına uygun
 * olmayan şekilde kullanımı yasaklanmıştır. Lisansın bir kopyasını aşağıdaki
 * linkten edinebilirsiniz.
 *
 * http://www.uni-yaz.com/lisans/ukl_1_1.pdf
 *
 * Yasalar aksini söylemediği veya yazılı bir sözleşme ile aksi belirtilmediği sürece,
 * bu yazılım mevcut hali ile hiç bir garanti vermeden veya herhangi bir şart ileri
 * sürmeden dağıtılır. Bu yazılımın edinim izinleri ve limitler konusunda lisans
 * sözleşmesine bakınız.
 *
 */
package com.uniyaz.domain;

import com.uniyaz.common.BaseDomain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * YolcuBilgileri
 *
 * @author Şafak Taşkın
 * @since 5.187
 */

@Entity
@Table(name = "YOLCU")
public class Yolcu extends BaseDomain {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String ad;

    @Column(length = 30)
    @Size(max = 30)
    private String soyad;

    @Column(length = 50)
    @Size(max = 50)
    private String email;

    @Column(length = 10)
    @Size(max = 10)
    private String telefon;

    @Column(length = 11)
    @Size(max = 11)
    private String tcKimlikNo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dogumTarihi;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 5)
    private EnumCinsiyet enumCinsiyet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORY", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "UCUS_YOLCU_ID"))
    private Ucus ucus;

    public Ucus getUcus() {
        return ucus;
    }

    public void setUcus(Ucus ucus) {
        this.ucus = ucus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public EnumCinsiyet getEnumCinsiyet() {
        return enumCinsiyet;
    }

    public void setEnumCinsiyet(EnumCinsiyet enumCinsiyet) {
        this.enumCinsiyet = enumCinsiyet;
    }
}
