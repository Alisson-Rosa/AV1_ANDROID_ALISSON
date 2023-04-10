package com.example.av1_android_alisson.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.av1_android_alisson.R;
import com.example.av1_android_alisson.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Customer> customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        customerList = (List<Customer>) intent.getSerializableExtra("customerList");
        if (customerList == null) {
            customerList = new ArrayList<>();
        }
    }

    public void btnViewCustomersOnClick(View view) {
        Intent intent = new Intent(this, ListCustomersActivity.class);
        intent.putExtra("customerList", new ArrayList<>(customerList));
        startActivity(intent);
    }

    public void btnAddCustomersOnClick(View view) {
        Intent intent = new Intent(this, CustomerRegistrationActivity.class);
        intent.putExtra("customerList", new ArrayList<>(customerList));
        startActivity(intent);
    }
}