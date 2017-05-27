package com.example.yeast.easypay.model;

/**
 * Created by Administrator on 27/5/2560.
 */

public class Transaction {
    private String date;
    private String time;
    private String type;
    private String descripton;
    private double price;
    private String payable;

    public Transaction(String date,String time,String type,String descripton,double price,String payable){
        this.date = date;
        this.time = time;
        this.type = type;
        this.descripton = descripton;
        this.price = price;
        this.payable = payable;
    }
    public String getDate(){
        return this.date;
    }
    public String getTime(){
        return  this.time;
    }
    public String getType(){
        return this.type;
    }
    public String getDescripton(){
        return this.descripton;
    }
    public double getPrice(){
        return this.price;
    }
    public String getPayable(){
        return this.payable;
    }
}
