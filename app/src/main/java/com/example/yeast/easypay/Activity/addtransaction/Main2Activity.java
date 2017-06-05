package com.example.yeast.easypay.Activity.addtransaction;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.yeast.easypay.Activity.addtransaction.AddTransactionFragment;
import com.example.yeast.easypay.Activity.addtransaction.AddTransactionPresenter;
import com.example.yeast.easypay.Activity.addtransaction.alltransactions.AllTransactionFragment;
import com.example.yeast.easypay.R;
import com.example.yeast.easypay.model.User;
import com.example.yeast.easypay.Activity.addtransaction.overview.OverviewFragment;

public class Main2Activity extends AppCompatActivity{

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private AddTransactionPresenter addTransactionPresenter;
    private TextView mViewCash;
    private TextView mViewBank;
    private User user;
    private RadioGroup typeRadioGroup;
    private RadioGroup payableRadioGroup;
    private RadioButton typeRadioButton;
    private RadioButton payableRadioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        user = User.getInstance();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        addTransactionPresenter = new AddTransactionPresenter();

        typeRadioGroup = (RadioGroup) findViewById(R.id.type_radioGroup);

        payableRadioGroup = (RadioGroup) findViewById(R.id.payable_radiogroup);


    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           switch (position) {
               case 0:
                   OverviewFragment overviewFragment = new OverviewFragment();
                   return overviewFragment;
               case 1:
                   AddTransactionFragment addTransactionFragment = new AddTransactionFragment();
                   return addTransactionFragment;
               case 2:
                   AllTransactionFragment allTransactionFragment = new AllTransactionFragment();
                   return allTransactionFragment;
               default:
                   return null;
           }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "OVERVIEW";
                case 1:
                    return "ADD TRANSACTION";
                case 2:
                    return "ALL TRANSACTION";
            }
            return null;
        }
    }



}
