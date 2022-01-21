package com.example.frontend_javaproject;

import java.util.Date;

public class Client {

    private int nicCol;
    private String nameCol,nationalityCol;
    private int phoneCol;
    private String proffesionCol;
    private Date dateCol;


    public Client(int nicCol, String nameCol, String nationalityCol, int phoneCol, String proffesionCol, Date dateCol) {
        this.nicCol = nicCol;
        this.nameCol = nameCol;
        this.nationalityCol = nationalityCol;
        this.phoneCol = phoneCol;
        this.proffesionCol = proffesionCol;
        this.dateCol = dateCol;
    }



    public int getNicCol() {
        return nicCol;
    }

    public String getNameCol() {
        return nameCol;
    }

    public String getNationalityCol() {
        return nationalityCol;
    }

    public int getPhoneCol() {
        return phoneCol;
    }

    public String getProffesionCol() {
        return proffesionCol;
    }

    public Date getDateCol() {
        return dateCol;
    }



}
