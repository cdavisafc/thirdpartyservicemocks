package com.corneliadavis.temporal.thirdparties.controller;

public class PaymentProcessingResult implements java.io.Serializable {

    String confirmationNumber;
    Long ordernumber;

    public PaymentProcessingResult(String confirmationNumber, Long ordernumber) {
        this.confirmationNumber = confirmationNumber;
        this.ordernumber = ordernumber;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Long getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Long ordernumber) {
        this.ordernumber = ordernumber;
    }
}
