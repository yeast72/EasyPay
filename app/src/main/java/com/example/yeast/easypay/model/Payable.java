package com.example.yeast.easypay.model;

/**
 * Created by Administrator on 27/5/2560.
 */

public interface Payable {
    public void pay(int amount);
    public void add(int amount);
    public int getCurrentMoney();
}
