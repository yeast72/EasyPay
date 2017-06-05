package com.example.yeast.easypay.Activity.addtransaction.overview;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yeast.easypay.R;

/**
 * Created by Administrator on 28/5/2560.
 */

public class OverviewFragment extends Fragment{
    TextView mCashText;
    TextView mMoneyInBankText;
    Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View rootView = inflater.inflate(R.layout.fragment_overview,container,false);
        mCashText = (TextView) rootView.findViewById(R.id.current_cash);
        mMoneyInBankText = (TextView) rootView.findViewById(R.id.current_bank);
        presenter = new Presenter();
        updateMoneyInAccout();
        return rootView;
    }

    public void updateMoneyInAccout(){
        mCashText.setText(presenter.getCurrentCash());
        mMoneyInBankText.setText(presenter.getCurrentBankMoney());

    }
}
