package com.example.yeast.easypay.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 27/5/2560.
 */

class TransctionRepo {
    private List<Transaction> transactions;
    private static final TransctionRepo ourInstance = new TransctionRepo();

    static TransctionRepo getInstance() {
        return ourInstance;
    }

    private TransctionRepo() {
        transactions = new ArrayList<>();
    }
    private List<Transaction> getAllTransaction(){
        return transactions;
    }
}
