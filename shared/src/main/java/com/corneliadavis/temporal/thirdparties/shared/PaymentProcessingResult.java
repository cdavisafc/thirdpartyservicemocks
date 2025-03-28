package com.corneliadavis.temporal.thirdparties.shared;

public class PaymentProcessingResult implements java.io.Serializable {

    String confirmationNumber;

    public PaymentProcessingResult() {
        // Default constructor
    }

    public PaymentProcessingResult(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

}
