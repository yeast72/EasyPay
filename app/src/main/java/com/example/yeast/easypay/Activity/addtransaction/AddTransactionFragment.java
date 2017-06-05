package com.example.yeast.easypay.Activity.addtransaction;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.yeast.easypay.R;
import com.example.yeast.easypay.model.Transaction;
import com.example.yeast.easypay.model.User;

import java.util.Date;

/**
 * Created by Administrator on 28/5/2560.
 */

public class AddTransactionFragment extends Fragment{
    private User user;
    private EditText mDateField;
    private EditText mTimeField;
    private EditText mDescField;
    private EditText mPriceField;
    private RadioGroup typeRadioGroup;
    private RadioGroup payableRadioGroup;
    private RadioButton typeRadioButton;
    private RadioButton payableRadioButton;

    private AddTransactionPresenter addTransactionPresenter;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_addtransaction,container,false);
        mDateField = (EditText) rootView.findViewById(R.id.date_field);
        mTimeField = (EditText) rootView.findViewById(R.id.time_field);
        mDescField = (EditText) rootView.findViewById(R.id.description_field);
        mPriceField = (EditText) rootView.findViewById(R.id.price_field);
        user = User.getInstance();

        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
        date.setTimeZone(TimeZone.getDefault());

        mDateField.setText(DateFormat.getDateInstance().format(new Date()));
        mTimeField.setText(date.format(currentLocalTime));

        typeRadioGroup = (RadioGroup) rootView.findViewById(R.id.type_radioGroup);
        typeRadioButton = (RadioButton) rootView.findViewById(R.id.income_radioButton);
        typeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId == R.id.income_radioButton){
                    typeRadioButton = (RadioButton) rootView.findViewById(R.id.income_radioButton);
                    Log.d("STATE",typeRadioButton.getText().toString());
                }else if(checkedId == R.id.outcome_radioButton) {
                    typeRadioButton = (RadioButton) rootView.findViewById(R.id.outcome_radioButton);
                    Log.d("STATE","hello");
                }
            }
        });

        payableRadioGroup = (RadioGroup) rootView.findViewById(R.id.payable_radiogroup);
        payableRadioButton = (RadioButton) rootView.findViewById(R.id.payable_cash_radioButton);
        payableRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId == R.id.payable_cash_radioButton){
                    payableRadioButton = (RadioButton) rootView.findViewById(R.id.payable_cash_radioButton);
                }else if(checkedId == R.id.payable_bank_radioButton) {
                    payableRadioButton = (RadioButton) rootView.findViewById(R.id.payable_bank_radioButton);
                }
            }
        });

        rootView.findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTransaction(v);
            }
        });

        addTransactionPresenter = new AddTransactionPresenter();
        return rootView;
    }

    public void addTransaction(View view) {
        String date = mDateField.getText().toString();
        Log.d("STATE","date " + date);
        String time = mTimeField.getText().toString();
        String type = typeRadioButton.getText().toString();
        String desc = mDescField.getText().toString();
        double price = Double.parseDouble(mPriceField.getText().toString());
        String payable = payableRadioButton.getText().toString();

        Transaction transaction = new Transaction(date,time,type,desc,price,payable);
        addTransactionPresenter.addTransaction(transaction,user);

        Intent intent = new Intent(getActivity(), Main2Activity.class);
        getActivity().startActivity(intent);

    }
}