package com.example.frontend_javaproject;

import java.util.Date;

public class TClient {

    private Integer nicCol;
    private String nameCol,nationalityCol;
    private Integer phoneCol,gadgetCol;
    private String statusCol;
    private Date dateCol;

    public TClient(int nicCol, String nameCol, String nationalityCol, int phoneCol, int gadgetCol, String statusCol, Date dateCol) {
        this.nicCol = nicCol;
        this.nameCol = nameCol;
        this.nationalityCol = nationalityCol;
        this.phoneCol = phoneCol;
        this.gadgetCol = gadgetCol;
        this.statusCol = statusCol;
        this.dateCol = dateCol;
    }

    public Integer getNicCol() {
        return nicCol;
    }

    public String getNameCol() {
        return nameCol;
    }

    public String getNationalityCol() {
        return nationalityCol;
    }

    public Integer getPhoneCol() {
        return phoneCol;
    }

    public Integer getGadgetCol() {
        return gadgetCol;
    }

    public String getStatusCol() {
        return statusCol;
    }

    public Date getDateCol() {
        return dateCol;
    }
}
