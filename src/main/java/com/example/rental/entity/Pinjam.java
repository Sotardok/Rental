package com.example.rental.entity;

import javax.persistence.*;

@Entity
@Table(name = "pinjam")
public class Pinjam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "NIK")
    private String NIK;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "email")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pinjam() {
    }

    public Pinjam(long id, String nama, String NIK, String alamat, String noTelp, String email) {
        this.id = id;
        this.nama = nama;
        this.NIK = NIK;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
    }
}
