package com.company;
import java.util.Date;

public class ResidenceInsurance extends Insurance {
    public ResidenceInsurance() {
        super();
    }

    @Override
    public void calculate(Accoount accoount) {
        if(accoount.getAccountType() == AccountType.INDIVIDUAL.getAccountType()) {
            this.setPrice(1500);
            this.setStartingDate(new Date());
            this.setExpirationDate(new Date());
        } else if (accoount.getAccountType() == AccountType.ENTERPRISE.getAccountType()) {
            this.setPrice(10000);
            this.setStartingDate(new Date());
            this.setExpirationDate(new Date());
        }
    }
}
