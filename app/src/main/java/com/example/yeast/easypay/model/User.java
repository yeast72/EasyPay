package com.example.yeast.easypay.model;

/**
 * Created by Administrator on 27/5/2560.
 */

public class User {
    private String username;
    private Wallet wallet;
    private BankAccount bankAccount;

    public User(String username){
        this.username = username;
        wallet = new Wallet();
    }
    public Wallet getWallet(){
        return wallet;
    }
}
