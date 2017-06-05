package com.example.yeast.easypay.model;

/**
 * Created by Administrator on 27/5/2560.
 */

public interface Payable {
    public void pay(double amount);
    public void add(double amount);
    public double getCurrentMoney();
}
