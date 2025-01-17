package com.astra.polytechnic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.astra.polytechnic.model.*;
public class BookingDetail {

    @SerializedName("id_transactiondetail")
    @Expose
    private String idTransactionDetail;

    @SerializedName("id_transaction")
    @Expose
    private String idTransaction;

    @SerializedName("id_koleksi")
    @Expose
    private Koleksi idKoleksi;

    @SerializedName("tanggalpinjam")
    @Expose
    private String tanggalPinjam;

    @SerializedName("tanggalkembali")
    @Expose
    private String tanggalKembali;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("creaby")
    @Expose
    private String creaby;

    @SerializedName("creadate")
    @Expose
    private String creadate;

    @SerializedName("modiby")
    @Expose
    private String modiby;

    @SerializedName("modidate")
    @Expose
    private String modidate;

    public BookingDetail(String idTransactionDetail, String idTransaction, Koleksi idKoleksi, String tanggalPinjam, String tanggalKembali, String status, String creaby, String creadate, String modiby, String modidate) {
        this.idTransactionDetail = idTransactionDetail;
        this.idTransaction = idTransaction;
        this.idKoleksi = idKoleksi;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.status = status;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
    }

    public String getIdTransactionDetail() {
        return idTransactionDetail;
    }

    public void setIdTransactionDetail(String idTransactionDetail) {
        this.idTransactionDetail = idTransactionDetail;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Koleksi getIdKoleksi() {
        return idKoleksi;
    }

    public void setIdKoleksi(Koleksi idKoleksi) {
        this.idKoleksi = idKoleksi;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreaby() {
        return creaby;
    }

    public void setCreaby(String creaby) {
        this.creaby = creaby;
    }

    public String getCreadate() {
        return creadate;
    }

    public void setCreadate(String creadate) {
        this.creadate = creadate;
    }

    public String getModiby() {
        return modiby;
    }

    public void setModiby(String modiby) {
        this.modiby = modiby;
    }

    public String getModidate() {
        return modidate;
    }

    public void setModidate(String modidate) {
        this.modidate = modidate;
    }
}
