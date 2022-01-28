package com.example.frontend_javaproject;

import java.util.Date;

public class Client {

    private Integer nicCol;
    private String nameCol,nationalityCol;
    private Integer phoneCol,ageCol;
    private String proffesionCol;
    private Date dateCol;


    public Client(Integer nicCol, String nameCol, String nationalityCol, int phoneCol, int ageCol, String proffesionCol, Date dateCol) {
        this.nicCol = nicCol;
        this.nameCol = nameCol;
        this.nationalityCol = nationalityCol;
        this.phoneCol = phoneCol;
        this.ageCol = ageCol;
        this.proffesionCol = proffesionCol;
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

    public Integer getAgeCol() {
        return ageCol;
    }

    public String getProffesionCol() {
        return proffesionCol;
    }

    public Date getDateCol() {
        return dateCol;
    }

    public void setNicCol(int nicCol) {
        this.nicCol = nicCol;
    }

    public void setNameCol(String nameCol) {
        this.nameCol = nameCol;
    }

    public void setNationalityCol(String nationalityCol) {
        this.nationalityCol = nationalityCol;
    }

    public void setPhoneCol(int phoneCol) {
        this.phoneCol = phoneCol;
    }

    public void setAgeCol(int ageCol) {
        this.ageCol = ageCol;
    }

    public void setProffesionCol(String proffesionCol) {
        this.proffesionCol = proffesionCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }
}
