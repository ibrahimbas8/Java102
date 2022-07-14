package com.company;

public enum AccountType{
    INDIVIDUAL(0),
    ENTERPRISE(1);

    private int accountType;
    AccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public static String getAccountTypeName(int accountType) {
        String accountTypeName;
        switch (accountType) {
            case 0:
                accountTypeName = INDIVIDUAL.name();
                break;
            case 1:
                accountTypeName = ENTERPRISE.name();
                break;
            default:
                accountTypeName = "ERROR!";
        }

        return accountTypeName;
    }
}