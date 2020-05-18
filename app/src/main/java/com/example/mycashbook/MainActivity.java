package com.example.mycashbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button budgetBtn;
    private Button expenseBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        budgetBtn = (Button) findViewById(R.id.budgetBtn);
        expenseBtn = (Button) findViewById(R.id.expenseBtn);

        budgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "budget btn clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, BudgetActivity.class);
                startActivity(intent);
            }
        });

        expenseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "expense btn clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ExpenseActivity.class);
                startActivity(intent);

            }
        });
    }


}
