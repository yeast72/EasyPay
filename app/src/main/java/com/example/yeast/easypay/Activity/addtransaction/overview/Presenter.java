package com.example.yeast.easypay.Activity.addtransaction.overview;

import android.util.Log;

import com.example.yeast.easypay.model.BankAccount;
import com.example.yeast.easypay.model.User;
import com.example.yeast.easypay.model.Wallet;

/**
 * Created by Administrator on 4/6/2560.
 */

public class Presenter {
    User user;


    public Presenter(){
        user = User.getInstance();
    }

    public String getCurrentCash(){
        Wallet wallet = user.getWallet();
        Log.d("STATE",user.getWallet().getCurrentMoney() + "cash");
        return wallet.getCurrentMoney()+" Baht";
    }


    public String getCurrentBankMoney() {
        BankAccount bankAccount = user.getBankAccount();
        Log.d("STATE",user.getBankAccount().getCurrentMoney() + "bank");
        return bankAccount.getCurrentMoney() + " Baht";
    }
}
