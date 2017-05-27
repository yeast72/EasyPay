package com.example.yeast.easypay.model;

/**
 * Created by Administrator on 27/5/2560.
 */

class BankAccount implements Payable{
    private String idAccount;
    private int money;

    public BankAccount(String idAccount){
        this.idAccount = idAccount;
        this.money = 0;
    }
    @Override
    public void pay(int amount) {
        this.money -= money;
    }

    @Override
    public void add(int amount) {
        this.money += money;
    }

    @Override
    public int getCurrentMoney() {
        return money;
    }
}
