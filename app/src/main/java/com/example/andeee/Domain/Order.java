package com.example.andeee.Domain;

import java.util.ArrayList;

public class Order {
    private String userEmail;
    private ArrayList<Foods> items;
    private double totalFee;

    private String paymentMethod;

    private String paymentStatus;

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Order(String userEmail, ArrayList<Foods> items, double totalFee, String paymentMethod, String paymentStatus, String phoneNumber) {
        this.userEmail = userEmail;
        this.items = items;
        this.totalFee = totalFee;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.phoneNumber = phoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public ArrayList<Foods> getItems() {
        return items;
    }

    public void setItems(ArrayList<Foods> items) {
        this.items = items;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Order(String userEmail, ArrayList<Foods> items, double totalFee, String paymentMethod, String paymentStatus) {
        this.userEmail = userEmail;
        this.items = items;
        this.totalFee = totalFee;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }
}