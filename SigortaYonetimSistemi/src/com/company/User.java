package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String occupation;
    private int age;
    private ArrayList<Address> addressList;
    private String lastLoginDate;

    public User(String firstName, String lastName, String email, String password, String occupation, int age, HomeAddress homeAddress, BusinessAddress businessAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.occupation = occupation;
        this.age = age;
        this.addressList = new ArrayList<>();
        this.addressList.add(homeAddress);
        this.addressList.add(businessAddress);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        this.lastLoginDate = formatter.format(date);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<Address> addressList) {
        this.addressList = addressList;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void addBusinessAddress(String country, String city, String district) {
        getAddressList().add(new BusinessAddress(country,city,district));
    }
    public void addHomeAddress(String country, String city, String district) {
        getAddressList().add(new HomeAddress(country, city, district));
    }
    public void removeAddress(int index) {
        try {
            getAddressList().remove(index);
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }
    }
}
