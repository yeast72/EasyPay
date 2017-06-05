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
        addTransaction(new Transaction("11/01/2540","11.50","income","eiei",100,"bank"));
        addTransaction(new Transaction("11/0/2254","1231","outcome","qwewq",20,"cash"));
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
