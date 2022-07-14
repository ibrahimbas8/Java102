package com.company;
import java.util.Date;

public class TravelInsurance extends Insurance {
    public TravelInsurance() {
        super();
    }

    @Override
    public void calculate(Accoount accoount) {
        if(accoount.getAccountType() == AccountType.INDIVIDUAL.getAccountType()) {
            this.setPrice(500);
            this.setStartingDate(new Date());
            this.setExpirationDate(new Date());
        } else if (accoount.getAccountType() == AccountType.ENTERPRISE.getAccountType()) {
            this.setPrice(3000);
            this.setStartingDate(new Date());
            this.setExpirationDate(new Date());
        }
    }
}