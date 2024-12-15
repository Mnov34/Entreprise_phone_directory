package com.mnov.cubes4java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editEmailAddressLogin, editPasswordLogin;
    Button buttonLoginLog, buttonRegisterLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmailAddressLogin = findViewById(R.id.editEmailAddressLogin);
        editPasswordLogin = findViewById(R.id.editPasswordLogin);

        buttonLoginLog = findViewById(R.id.buttonLoginLogin);
        buttonRegisterLog = findViewById(R.id.buttonRegisterLogin);

        buttonRegisterLog.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        });

    }

}