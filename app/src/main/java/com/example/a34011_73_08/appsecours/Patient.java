package com.example.a34011_73_08.appsecours;

/**
 * Created by 34011-73-08 on 24/10/2016.
 */

public class Patient extends Person {

    private String bloodType;
    private String infosComp;

    public Patient(String firstName, String lastName, int age, String adress, int telephone, String bloodType, String infosComp) {
        super(firstName, lastName, age, adress, telephone);
        this.bloodType = bloodType;
        this.infosComp = infosComp;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getInfosComp() {
        return infosComp;
    }

    public void setInfosComp(String infosComp) {
        this.infosComp = infosComp;
    }
}
