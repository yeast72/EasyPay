package com.example.yeast.easypay.model;

/**
 * Created by Administrator on 27/5/2560.
 */

public class BankAccount implements Payable{
    private double money;

    public BankAccount(double money){
        this.money = money;
    }
    @Override
    public void pay(double amount) {
        this.money -= amount;
    }

    @Override
    public void add(double amount) {
        this.money += amount;
    }

    @Override
    public double getCurrentMoney() {
        return money;
    }
}
