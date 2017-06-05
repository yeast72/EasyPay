package com.example.yeast.easypay.Activity.addtransaction.alltransactions;

import com.example.yeast.easypay.model.Transaction;
import com.example.yeast.easypay.model.TransctionRepo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 5/6/2560.
 */

public class AllTransactionPresenter implements Observer{
    private TransctionRepo transctionRepo;
    private AllTransactionView view;

    ArrayList<Transaction> transactions;
    public AllTransactionPresenter(TransctionRepo transctionRepo,AllTransactionView view) {
        this.transctionRepo = transctionRepo;
        this.view = view;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o == transctionRepo) {
            transactions = new ArrayList<Transaction>(transctionRepo.getAllTransaction());
            view.setTransactionList(transactions);
        }
    }

    public void initialize() {
        transctionRepo.addObserver(this);
        transctionRepo.fetchAllTransaction();
    }
}
