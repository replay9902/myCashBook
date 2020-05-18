package com.example.mycashbook;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class ExpenseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
    }
}
