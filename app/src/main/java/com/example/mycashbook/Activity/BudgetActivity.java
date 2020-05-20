package com.example.mycashbook.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycashbook.Etc.DBHelper;
import com.example.mycashbook.R;

public class BudgetActivity extends AppCompatActivity {

    DBHelper dbHelper;

    private Button setBudgetBtn;
    private EditText etBudget;
    private EditText etStartdate;

    int budget;
    int startdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);


        setBudgetBtn = (Button) findViewById(R.id.setBudgetBtn);
        etBudget = (EditText) findViewById(R.id.etBudget);
        etStartdate = (EditText) findViewById(R.id.etStartdate);

        dbHelper = new DBHelper(getApplicationContext());

        setBudgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    budget = Integer.parseInt(etBudget.getText().toString());
                    startdate = Integer.parseInt(etStartdate.getText().toString());

                }catch (NumberFormatException e){
                    budget = 0;
                    startdate = 1;
                }

                if(String.valueOf(budget).getBytes().length <= 0 || String.valueOf(startdate).getBytes().length <= 0){
                    Toast.makeText(BudgetActivity.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BudgetActivity.this, "예산:"+budget, Toast.LENGTH_SHORT).show();
                    Toast.makeText(BudgetActivity.this, "시작일:"+startdate, Toast.LENGTH_SHORT).show();

                }

                dbHelper.setConfig(budget, startdate);
            }
        });

    }



}
