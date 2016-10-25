package com.example.a34011_73_08.appsecours;

/**
 * Created by 34011-73-08 on 24/10/2016.
 */

public abstract class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String adress;
    private int telephone;


    public Person(String firstName, String lastName, int age, String adress, int telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }


}
