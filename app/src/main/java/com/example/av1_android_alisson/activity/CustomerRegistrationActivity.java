package com.example.av1_android_alisson.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.av1_android_alisson.R;
import com.example.av1_android_alisson.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRegistrationActivity extends AppCompatActivity {
    private List<Customer> customerList = new ArrayList<>();
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);
        Intent intent = getIntent();
        customerList = (List<Customer>) intent.getSerializableExtra("customerList");
        if (customerList == null) {
            customerList = new ArrayList<>();
        }
        position = getIntent().getIntExtra("selectedPosition", -1);
        Button buttonExclude = findViewById(R.id.btnExclude);
        if(position != -1){
            completedForm();
            buttonExclude.setVisibility(View.VISIBLE);
        } else {
            buttonExclude.setVisibility(View.GONE);
        }
    }

    private void completedForm() {
        Customer customer = customerList.get(position);
        String name = customer.getName();
        String telephone = customer.getTelephone();
        String email = customer.getEmail();

        EditText textName = findViewById(R.id.editName);
        EditText textTelephone = findViewById(R.id.editTelephone);
        EditText textEmail = findViewById(R.id.editEmail);

        textName.setText(name);
        textTelephone.setText(telephone);
        textEmail.setText(email);
    }

    public void btnSaveOnClick(View view){
        boolean errors = false;
        EditText textName = findViewById(R.id.editName);
        String name = textName.getText().toString();
        if(name.length() < 1){
            errors = true;
            textName.setError("Este campo é obrigatório");
        }

        EditText textTelephone = findViewById(R.id.editTelephone);
        String telephone = textTelephone.getText().toString();
        if(telephone.length() < 1){
            errors = true;
            textTelephone.setError("Este campo é obrigatório");
        }

        EditText textEmail = findViewById(R.id.editEmail);
        String email = textEmail.getText().toString();
        if(email.length() < 1){
            errors = true;
            textEmail.setError("Este campo é obrigatório");
        }

        if(errors) return;

        Customer customer = new Customer(name, telephone, email);
        if(position == -1){
            salvaCustomer(customer);
        } else {
            updateCustomer(customer, position);
        }

        Intent intent = new Intent(this, ListCustomersActivity.class);
        intent.putExtra("customerList", new ArrayList<>(customerList));
        startActivity(intent);
    }

    private void salvaCustomer(Customer customer) {
        customerList.add(customer);
    }

    private void updateCustomer(Customer customer, int position) {
        customerList.remove(position);
        customerList.add(position, customer);
    }

    public void btnCancelOnClick(View view){
        Intent intent = new Intent(this, ListCustomersActivity.class);
        intent.putExtra("customerList", new ArrayList<>(customerList));
        startActivity(intent);
    }

    public void btnExcludeOnClick(View view){
        if(position != -1){
            customerList.remove(position);
        }

        Intent intent = new Intent(this, ListCustomersActivity.class);
        intent.putExtra("customerList", new ArrayList<>(customerList));
        startActivity(intent);
    }
}