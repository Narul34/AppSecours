package com.example.a34011_73_08.appsecours;

/**
 * Created by 34011-73-08 on 24/10/2016.
 */

public class Patient extends Person {

    private String bloodType;
    private String infosComp;
    private Doctor doctor;

    public Patient(String firstName, String lastName, String age, String sexe, String adress, String telephone, String bloodType, String infosComp, Doctor doctor) {
        super(firstName, lastName, age, sexe, adress, telephone);
        this.bloodType = bloodType;
        this.infosComp = infosComp;
        this.doctor = doctor;
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

    public String getDoctor() {
        String ficheDoc = doctor.getAll();
        return ficheDoc;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String getAll(){
        String all = super.getAll();
        all  += "\n" + getBloodType() + "\n" + getInfosComp();

        if(doctor != null){
            all += "\n" + getDoctor();
        }
        return all;

    }
}
