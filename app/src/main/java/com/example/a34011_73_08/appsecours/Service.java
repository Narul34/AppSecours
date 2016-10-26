package com.example.a34011_73_08.appsecours;

/**
 * Created by 34011-73-05 on 24/10/2016.
 */

public class Service {
    int imageID;
    String nom;
    String num;

    public Service(int imageID, String nom, String num){
        this.imageID = imageID;
        this.nom = nom;
        this.num = num;

    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }


}
