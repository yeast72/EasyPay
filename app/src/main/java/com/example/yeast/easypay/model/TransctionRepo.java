package com.example.yeast.easypay.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Administrator on 27/5/2560.
 */

public class TransctionRepo extends Observable{
    private List<Transaction> transactions;
    private static final TransctionRepo ourInstance = new TransctionRepo();

    public static TransctionRepo getInstance() {
        return ourInstance;
    }

    private TransctionRepo() {
        transactions = new ArrayList<>();

    }
    public List<Transaction> getAllTransaction(){
        return transactions;
    }
    public void fetchAllTransaction() {
        setChanged();
        notifyObservers();
    }
    public void addTransaction(Transaction transaction,User user){
        transactions.add(transaction);
        if(transaction.getPayable().equalsIgnoreCase("bank")){
            if (transaction.getType().equalsIgnoreCase("outcome")) {
                user.getBankAccount().pay(transaction.getPrice());
            }else if(transaction.getType().equalsIgnoreCase("income")){
                user.getBankAccount().add(transaction.getPrice());
            }
        }else if(transaction.getPayable().equalsIgnoreCase("cash")){
            if (transaction.getType().equalsIgnoreCase("outcome")) {
                user.getWallet().pay(transaction.getPrice());
            }else if(transaction.getType().equalsIgnoreCase("income")){
                user.getWallet().add(transaction.getPrice());
            }
        }
    }
}
