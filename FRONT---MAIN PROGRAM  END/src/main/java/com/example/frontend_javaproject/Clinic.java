package com.example.frontend_javaproject;

import java.util.Date;

/**
 * this class is what define a clinic in the databse
 */
public class Clinic {

    Integer id;
    String name;
    int qtyvacc,qtytaste;
    String hospital;
    Date date;

    public Clinic(int id, String name, int qtyvacc, int qtytaste, String hospital, Date date) {
        this.id = id;
        this.name = name;
        this.qtyvacc = qtyvacc;
        this.qtytaste = qtytaste;
        this.hospital = hospital;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtyvacc() {
        return qtyvacc;
    }

    public void setQtyvacc(int qtyvacc) {
        this.qtyvacc = qtyvacc;
    }

    public int getQtytaste() {
        return qtytaste;
    }

    public void setQtytaste(int qtytaste) {
        this.qtytaste = qtytaste;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
