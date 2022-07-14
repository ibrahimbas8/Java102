package com.company;
import java.util.ArrayList;

public abstract class Accoount implements Comparable<Accoount> {
    private User user;
    private ArrayList<Insurance> insurances;
    private int authenticationStatus;
    private int accountType;

    public Accoount(User user, ArrayList<Insurance> insurances, int authenticationStatus, int accountType) {
        this.user = user;
        this.insurances = insurances;
        this.authenticationStatus = authenticationStatus;
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public int getAuthenticationStatus() {
        return authenticationStatus;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAuthenticationStatus(int authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void showUserInfo() {
        System.out.println(" * USER INFO");
        System.out.println("First name: " + "\t" + getUser().getFirstName() + "\n" +
                "Last name: " + "\t\t" + getUser().getLastName() + "\n" +
                "Email: " + "\t\t\t" + getUser().getEmail() + "\n" +
                "Occupation: " + "\t" + getUser().getOccupation() + "\n" +
                "Age: " + "\t\t\t" + getUser().getAge());
        System.out.println("Addresses: ");
        for (Address address : getUser().getAddressList()) {
            System.out.println(" \t\t*" + address.getClass().getName() + ": " + address.getAddress());
        }
        System.out.println("Insurances: ");
        for (Insurance insurance : getInsurances()) {
            insurance.calculate(this);
            System.out.println(" \t\t*" + insurance.getName());
            System.out.println("\t\t\t\t*"+insurance.getPrice()+" TL \n\t\t\t\t"+insurance.getStartingDate()+"\n\t\t\t\t"+insurance.getExpirationDate());
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
