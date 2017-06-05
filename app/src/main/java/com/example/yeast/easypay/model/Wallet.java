package com.example.yeast.easypay.model;

/**
 * Created by Administrator on 27/5/2560.
 */

public class Wallet implements Payable{
    private double cash;

    public Wallet(double cash){
        this.cash = cash;
    }
    public Wallet(){
        this.cash = 0;
    }

    @Override
    public double getCurrentMoney(){
        return  this.cash;
    }

    @Override
    public void pay(double cash){
        this.cash -= cash;
    }

    @Override
    public void add(double cash){
        this.cash += cash;
    }
}
