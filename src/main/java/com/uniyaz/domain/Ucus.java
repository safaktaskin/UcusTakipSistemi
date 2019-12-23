package com.uniyaz.domain;

import com.uniyaz.common.BaseDomain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "UCUS")
public class Ucus extends BaseDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    @Size(max = 100)
    private String kalkisYeri;

    @Column(length = 100)
    @Size(max = 100)
    private String varisYeri;

    @Temporal(TemporalType.TIMESTAMP)
    private Date kalkisTarihi;

    @Temporal(TemporalType.TIMESTAMP)
    private Date donusTarihi;

    @Column(length = 10)
    @Size(max = 10)
    private int yolcuSayisi;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 15)
    private EnumGidisTuru enumGidisTuru;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKalkisYeri() {
        return kalkisYeri;
    }

    public void setKalkisYeri(String kalkisYeri) {
        this.kalkisYeri = kalkisYeri;
    }

    public String getVarisYeri() {
        return varisYeri;
    }

    public void setVarisYeri(String varisYeri) {
        this.varisYeri = varisYeri;
    }

    public Date getKalkisTarihi() {
        return kalkisTarihi;
    }

    public void setKalkisTarihi(Date kalkisTarihi) {
        this.kalkisTarihi = kalkisTarihi;
    }

    public Date getDonusTarihi() {
        return donusTarihi;
    }

    public void setDonusTarihi(Date varisTarihi) {
        this.donusTarihi = varisTarihi;
    }

    public int getYolcuSayisi() {
        return yolcuSayisi;
    }

    public void setYolcuSayisi(int yolcuSayisi) {
        this.yolcuSayisi = yolcuSayisi;
    }

    public EnumGidisTuru getEnumGidisTuru() {
        return enumGidisTuru;
    }

    public void setEnumGidisTuru(EnumGidisTuru enumGidisTuru) {
        this.enumGidisTuru = enumGidisTuru;
    }



    @Override
    public String toString() {
        return id + kalkisYeri + varisYeri + kalkisTarihi + donusTarihi + yolcuSayisi + enumGidisTuru;
    }
}
