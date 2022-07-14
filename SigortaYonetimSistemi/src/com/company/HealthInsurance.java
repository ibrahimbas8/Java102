package com.company;
import java.util.Date;

public class HealthInsurance extends Insurance {
    public HealthInsurance() {
        super();
    }

    @Override
    public void calculate(Accoount accoount) {
        if(accoount.getAccountType() == AccountType.INDIVIDUAL.getAccountType()) {
            this.setPrice(1000);
            this.setStartingDate(new Date());
            this.setExpirationDate(new Date());
        } else if (accoount.getAccountType() == AccountType.ENTERPRISE.getAccountType()) {
            this.setPrice(4000);
            this.setStartingDate(new Date());
            this.setExpirationDate(new Date());
        }
    }
}
