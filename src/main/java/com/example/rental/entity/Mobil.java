package com.example.rental.entity;

import javax.persistence.*;

@Entity
@Table(name = "mobil")
public class Mobil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "merk")
    private String merk;

    @Column(name = "type")
    private String type;

    @Column(name = "tahun_produksi")
    private String tahunProduksi;

    @Column(name = "no_polisi")
    private String noPolisi;

    @Column(name = "harga")
    private int harga;

    @Column(name = "status")
    private String status;

    public Mobil() {
    }

    public Mobil(long id, String merk, String type, String tahunProduksi, String noPolisi, int harga, String status) {
        this.id = id;
        this.merk = merk;
        this.type = type;
        this.tahunProduksi = tahunProduksi;
        this.noPolisi = noPolisi;
        this.harga = harga;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTahunProduksi() {
        return tahunProduksi;
    }

    public void setTahunProduksi(String tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public String getNoPolisi() {
        return noPolisi;
    }

    public void setNoPolisi(String noPolisi) {
        this.noPolisi = noPolisi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
