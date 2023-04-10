package com.example.av1_android_alisson.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.av1_android_alisson.R;
import com.example.av1_android_alisson.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class ListCustomersActivity extends AppCompatActivity {
    private List<Customer> customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_customers);
        Intent intent = getIntent();
        customerList = (List<Customer>) intent.getSerializableExtra("customerList");
        if (customerList == null) {
            customerList = new ArrayList<>();
        }
        ListView listCustomers = findViewById(R.id.listCustomers);
        listCustomers.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, customerList));
    }

    public void btnBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("customerList", new ArrayList<>(customerList));
        startActivity(intent);
    }

    public void btnAddCustomersOnClick(View view) {
        Intent intent = new Intent(this, CustomerRegistrationActivity.class);
        intent.putExtra("customerList", new ArrayList<>(customerList));
        startActivity(intent);
    }
}