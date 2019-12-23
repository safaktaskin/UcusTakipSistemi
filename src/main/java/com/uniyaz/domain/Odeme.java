package com.uniyaz.domain;

import com.uniyaz.common.BaseDomain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "ODEME")
public class Odeme extends BaseDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 15)
    private EnumOdemeTuru enumOdemeTuru;

    @Column(length = 16)
    @Size(max = 16)
    private String kartNo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sonKullanmaTarihi;

    @Column(length = 3)
    @Size(max = 3)
    private String cvv;

    @Column(length = 10)
    @Size(max = 10)
    private String toplamTutar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumOdemeTuru getEnumOdemeTuru() {
        return enumOdemeTuru;
    }

    public void setEnumOdemeTuru(EnumOdemeTuru enumOdemeTuru) {
        this.enumOdemeTuru = enumOdemeTuru;
    }

    public String getKartNo() {
        return kartNo;
    }

    public void setKartNo(String kartNo) {
        this.kartNo = kartNo;
    }

    public Date getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(Date sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(String toplamTutar) {
        this.toplamTutar = toplamTutar;
    }
}
