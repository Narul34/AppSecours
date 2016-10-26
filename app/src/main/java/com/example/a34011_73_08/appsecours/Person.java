package com.example.a34011_73_08.appsecours;

/**
 * Created by 34011-73-08 on 24/10/2016.
 */

public abstract class Person {

    private String firstName;
    private String lastName;
    private String age;
    private String sexe;
    private String adress;
    private String telephone;


    public Person(String firstName, String lastName, String age, String sexe, String adress, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sexe = sexe;
        this.adress = adress;
        this.telephone = telephone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAll() {
        String all = getFirstName() + "\n" + getLastName() + "\n" +
                getAge() + "\n" + getSexe()+"\n" + getAdress() + "\n" + getTelephone() ;
        return all;
    }


}
