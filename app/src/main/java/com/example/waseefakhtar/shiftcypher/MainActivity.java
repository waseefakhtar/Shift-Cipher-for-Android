package com.example.waseefakhtar.shiftcypher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView usernameLabel, passwordLabel;
    EditText usernameField, passwordField;
    Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameLabel = (TextView) findViewById(R.id.usernameLabel);
        passwordLabel = (TextView) findViewById(R.id.passwordLabel);
        usernameField = (EditText) findViewById(R.id.usernameField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        logInButton = (Button) findViewById(R.id.logInButton);


        usernameLabel.setOnClickListener(this);
        passwordLabel.setOnClickListener(this);
        usernameField.setOnClickListener(this);
        passwordField.setOnClickListener(this);
        logInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String usernameString = usernameField.getText().toString();
        String passwordString = passwordField.getText().toString();

        if(v.equals(logInButton)) {
            switch (usernameString) {
                case "waseefakhtar":
                    switch (passwordString) {
                        case "123456":
                            Toast.makeText(getApplicationContext(), "Username or Password correct.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(this, SecondActivity.class);
                            startActivity(intent);
                            break;
                        default:
                            Toast.makeText(getApplicationContext(), "Username or Password incorrect.", Toast.LENGTH_LONG).show();
                    }
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Username or Password incorrect.", Toast.LENGTH_LONG).show();
                    break;
            }
        }


    }
}
