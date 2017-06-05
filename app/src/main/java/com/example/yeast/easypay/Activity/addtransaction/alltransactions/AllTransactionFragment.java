package com.example.yeast.easypay.Activity.addtransaction.alltransactions;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.yeast.easypay.R;
import com.example.yeast.easypay.model.Transaction;
import com.example.yeast.easypay.model.TransctionRepo;

import java.util.ArrayList;

/**
 * Created by Administrator on 28/5/2560.
 */

public class AllTransactionFragment extends Fragment implements AllTransactionView{
    ArrayAdapter<Transaction> transactionArrayAdapter;
    private ListView transactionListView;
    private AllTransactionPresenter alltransactionPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_alltransaction,container,false);
        TransctionRepo transctionRepo = TransctionRepo.getInstance();
        Log.d("STATE",transctionRepo.toString());

        transactionListView = (ListView) rootView.findViewById(R.id.listview_transactions);
        transactionArrayAdapter = createAdapter(new ArrayList<Transaction>());
        transactionListView.setAdapter(transactionArrayAdapter);

        alltransactionPresenter = new AllTransactionPresenter(transctionRepo,this);
        alltransactionPresenter.initialize();

        return rootView;
    }

    private ArrayAdapter<Transaction> createAdapter(ArrayList<Transaction> transactions) {
        return new ArrayAdapter<Transaction>(this.getActivity(),android.R.layout.simple_list_item_1,transactions);
    }

    @Override
    public void setTransactionList(ArrayList<Transaction> transactions) {
        transactionArrayAdapter = createAdapter(transactions);
        transactionListView.setAdapter(transactionArrayAdapter);
    }
}