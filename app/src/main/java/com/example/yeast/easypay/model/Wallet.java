package com.example.yeast.easypay.model;

/**
 * Created by Administrator on 27/5/2560.
 */

class Wallet implements Payable{
    private int cash;

    public Wallet(int cash){
        this.cash = cash;
    }
    public Wallet(){
        this.cash = 0;
    }

    @Override
    public int getCurrentMoney(){
        return  this.cash;
    }

    @Override
    public void pay(int cash){
        this.cash -= cash;
    }

    @Override
    public void add(int cash){
        this.cash += cash;
    }
}
