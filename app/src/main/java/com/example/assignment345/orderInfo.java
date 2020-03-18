package com.example.assignment345;

public class orderInfo {

    private long orderId;
    private String mealName;
    private int price;
    private int quantity;
    private double tip;
    private double tax;
    private double cost;

    public orderInfo(long orderId, String mealName, int price,int quantity,
                     double tip,double cost, double tax){
        this.orderId = orderId;
        this.mealName = mealName;
        this.price = price;
        this.quantity = quantity;
        this.tip = tip;
        this.tax = tax;
        this.cost = cost;

    }

    public orderInfo(){

    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


}
