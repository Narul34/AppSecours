package com.example.a34011_73_08.appsecours;

/**
 * Created by 34011-73-08 on 24/10/2016.
 */

public class Doctor extends Person {


    //Doctor's national id
    private String adeli;

    public Doctor(String firstName, String lastName, String age, String sexe, String adress, String telephone, String adeli) {
        super(firstName, lastName, age, sexe, adress, telephone);
        this.adeli = adeli;
    }

    public String getAdeli() {
        return adeli;
    }

    public void setAdeli(String adeli) {
        this.adeli = adeli;
    }

    @Override
    public String getAll(){
        String all = super.getAll();
        all += " - " + getAdeli();
        return all;
    }

}
