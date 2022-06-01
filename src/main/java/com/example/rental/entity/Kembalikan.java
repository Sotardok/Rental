package com.example.rental.entity;

import javax.persistence.*;

@Entity
@Table(name = "kembalikan")
public class Kembalikan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "pinjamId")
    private int pinjamId;

    @Column(name = "harga")
    private int harga;

    @Column(name = "peminjam")
    private String peminjam;

    @Column(name = "NIK")
    private String NIK;

    @Column(name = "date")
    private String date;

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public Kembalikan() {
    }

    public Kembalikan(long id, int pinjamId, int harga, String peminjam, String date, String NIK) {
        this.id = id;
        this.pinjamId = pinjamId;
        this.harga = harga;
        this.peminjam = peminjam;
        this.NIK = NIK;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPinjamId() {
        return pinjamId;
    }

    public void setPinjamId(int pinjamId) {
        this.pinjamId = pinjamId;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(String peminjam) {
        this.peminjam = peminjam;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
