package com.company;

import java.util.ArrayList;
import java.util.TreeSet;
public class AccountManager {
    private TreeSet<Accoount> accounts;

    private void prepareAccounts() {
        HomeAddress homeAddress1 = new HomeAddress("Türkiye", "Ankara", "Keçiören");
        BusinessAddress businessAddress1 = new BusinessAddress("Türkiye", "Ankara", "Keçiören");
        User user1 = new User("İbrahim", "Baş", "ibrahimbas@gmail.com", "123", "developer", 24, homeAddress1, businessAddress1);
        ArrayList<Insurance> insurances = new ArrayList<>();
        insurances.add(new HealthInsurance());
        insurances.add(new ResidenceInsurance());

        accounts = new TreeSet<>();
        accounts.add(new Enterprise(user1, insurances));
    }

    public Accoount login(String email, String password) throws InvalidAuthenticationException {
        prepareAccounts();
        for (Accoount accoount : accounts) {
            if (accoount.getUser().getEmail().equals(email) && accoount.getUser().getPassword().equals(password)) {
                accoount.setAuthenticationStatus(1);
                return accoount;
            }
        }
        throw new InvalidAuthenticationException("Invalid Authentication Exception!");
    }
}
