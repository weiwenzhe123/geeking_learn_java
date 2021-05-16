package com.supermarket;/*
    @auth wwz 
    @create 
*/

public class Customer {
    private String name ;
    private double money;
    private boolean IsDriveCar;

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDriveCar() {
        return IsDriveCar;
    }

    public void setDriveCar(boolean driveCar) {
        IsDriveCar = driveCar;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

}
