package com.company;
import java.util.Date;

public class CarInsurance extends Insurance {

    public CarInsurance() {
        super();
    }

    @Override
    public void calculate(Accoount accoount) {
        if(accoount.getAccountType() == AccountType.INDIVIDUAL.getAccountType()) {
            this.setPrice(2000);
            this.setStartingDate(new Date());
            this.setExpirationDate(new Date());
        } else if (accoount.getAccountType() == AccountType.ENTERPRISE.getAccountType()) {
            this.setPrice(9000);
            this.setStartingDate(new Date());
            this.setExpirationDate(new Date());
        }
    }
}
