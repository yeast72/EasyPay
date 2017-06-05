package com.example.yeast.easypay.Activity.addtransaction;

import android.util.Log;

import com.example.yeast.easypay.model.Transaction;
import com.example.yeast.easypay.model.User;

/**
 * Created by Administrator on 5/6/2560.
 */

public class AddTransactionPresenter {

    public void addTransaction(Transaction trasaction,User user) {
        Log.d("STATE",trasaction.toString());
        user.addTransaction(trasaction);
        user = User.getInstance();
        Log.d("STATE","user current bank "+user.getBankAccount().getCurrentMoney());
        Log.d("STATE","user current cash "+user.getWallet().getCurrentMoney());
    }
}
