package com.mnov.cubes4java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mnov.cubes4java.ui.main.MainActivity;

public class Register extends AppCompatActivity {

    EditText editTextFirstName, editTextLastName,
            editTextEmail, editTextHomePhone,
            editTextMobilePhone, editTextPassword;

    Button buttonRegister, buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextFirstName = findViewById(R.id.editTextFirstNameRegister);
        editTextLastName = findViewById(R.id.editTextLastNameRegister);
        editTextEmail = findViewById(R.id.editTextEmailAddressRegister);
        editTextHomePhone = findViewById(R.id.editTextHomePhoneRegister);
        editTextMobilePhone = findViewById(R.id.editTextMobilePhoneRegister);
        editTextPassword = findViewById(R.id.editTextPasswordRegister);

        buttonRegister = findViewById(R.id.buttonRegisterRegister);
        buttonLogin = findViewById(R.id.buttonLoginRegister);

        buttonLogin.setOnClickListener(view -> {
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
        });
    }
}