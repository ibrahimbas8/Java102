package com.company;

public enum AuthenticationStatus {
    FAIL(0),
    SUCCESS(1);

    int status;

    AuthenticationStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    private void setStatus(int status) {
        this.status = status;
    }

}