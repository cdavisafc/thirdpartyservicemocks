package com.corneliadavis.temporal.thirdparties.controller;

public class PaymentProcessingInput {

    private String name;
    private double amount;
    private String currency;
    private String paymentType;
    private String accountNumber;
    private Long orderNumber;

    public PaymentProcessingInput() {}

    public PaymentProcessingInput(String name, double amount, String currency, String paymentType, String accountNumber, Long orderNumber) {
        this.name = name;
        this.amount = amount;
        this.currency = currency;
        this.paymentType = paymentType;
        this.accountNumber = accountNumber;
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
