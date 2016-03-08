package com.example.waseefakhtar.shiftcypher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView encryptMessageLabel, displayMessage;
    EditText messageField;
    NumberPicker numberPicker;
    Button encryptButton, decryptButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        encryptMessageLabel = (TextView) findViewById(R.id.encryptMessageLabel);
        displayMessage = (TextView) findViewById(R.id.displayMessage);
        messageField = (EditText) findViewById(R.id.messageField);
        encryptButton = (Button) findViewById(R.id.encryptButton);
        decryptButton = (Button) findViewById(R.id.decryptButton);
        numberPicker = (NumberPicker) findViewById(R.id.numberPicker);

        encryptMessageLabel.setOnClickListener(this);
        displayMessage.setOnClickListener(this);
        messageField.setOnClickListener(this);
        encryptButton.setOnClickListener(this);
        decryptButton.setOnClickListener(this);
        numberPicker.setOnClickListener(this);

        Intent intent = getIntent();
        intent.getAction();

        numberPicker.setMaxValue(26);
        numberPicker.setMinValue(0);
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setOnValueChangedListener(new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                int numberPicked = numberPicker.getValue();
            }
        });
    }


    @Override
    public void onClick(View v) {
        String messageString = messageField.getText().toString();

        if (v.equals(encryptButton)) {
            switch (messageString) {
                case "":
                    Toast.makeText(SecondActivity.this, "Please write a message.", Toast.LENGTH_LONG).show();
                    break;
                default:
                    encryptMessage();
                    break;
            }
        }
        if (v.equals(decryptButton)) {
            switch (messageString) {
                case "":
                    Toast.makeText(SecondActivity.this, "Please write a message.", Toast.LENGTH_LONG).show();
                    break;
                default:
                    decryptMessage();
                    break;
            }
        }
    }

    private void encryptMessage() {
        String messageString = messageField.getText().toString();
        String s = "";
        int len = messageString.length();
        int pickedValue = numberPicker.getValue();

        for (int x = 0; x < len; x++) {
            char c = (char) (messageString.charAt(x) + pickedValue);
            if (Character.isWhitespace(messageString.charAt(x))) {
                s += " ";
                continue;
            }
            if (c > 'z')
                s += (char) (messageString.charAt(x) - (26 - pickedValue));
            else
                s += (char) (messageString.charAt(x) + pickedValue);

            displayMessage.setText(s);
        }
    }

    private void decryptMessage() {
        String messageString = messageField.getText().toString();
        String s = "";
        int len = messageString.length();
        int pickedValue = numberPicker.getValue();

        for (int x = 0; x < len; x++) {
            char c = (char) (messageString.charAt(x) - pickedValue);
            if (Character.isWhitespace(messageString.charAt(x))) {
                s += " ";
                continue;
            }
            if (c < 'A' || (c < 'a' && c > 'W'))
                c += 26;
            s += c;

            displayMessage.setText(s);
        }
    }
}
