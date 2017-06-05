package com.example.yeast.easypay.model;

import android.util.Log;

/**
 * Created by Administrator on 27/5/2560.
 */

public class User {
    private Wallet wallet;
    private BankAccount bankAccount;
    private static User instance = null;
    private TransctionRepo transactionRepo;

    private User(){
        wallet = new Wallet(0);
        bankAccount = new BankAccount(0);
        transactionRepo = TransctionRepo.getInstance();
        addTransaction(new Transaction("Jun 5,2017","21.50","income","mom give",100,"bank"));
        addTransaction(new Transaction("Jun 5 2017","22.00","income","dad give money",500,"cash"));
        addTransaction(new Transaction("Jun 6 2018","12.31","outcome","shabu",300,"cash"));
    }
    public Wallet getWallet(){
        return wallet;
    }
    public BankAccount getBankAccount(){
        return bankAccount;
    }

    public static User getInstance(){
        if(instance == null){
            return instance = new User();
        }
        return instance;
    }
    public void addTransaction(Transaction transaction){
        Log.d("STATE","user class " + transaction);
        transactionRepo.addTransaction(transaction,this);
    }
}
