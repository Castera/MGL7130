package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddMember extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        TextView resultField = (TextView) findViewById(R.id.resultField);
        resultField.setVisibility(View.INVISIBLE);
    }

    public void submit(View view) {
        EditText nameField = (EditText) findViewById(R.id.nameField);
        String name = nameField.getText().toString();

        EditText firstnameField = (EditText) findViewById(R.id.firstnameField);
        String firstname = firstnameField.getText().toString();

        EditText postalcodeField = (EditText) findViewById(R.id.postalCodeField);
        String postalcode = postalcodeField.getText().toString();

        boolean isValid = true;

        // Validate name
        Pattern namePattern = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE);
        Matcher nameMatcher = namePattern.matcher(name);
        // Only alphabetical caracters, min length of 1 and max length of 40 caracters
        isValid = nameMatcher.find() && name.length() <= 40;
        nameField.setTextColor(isValid ? Color.BLACK : Color.RED);
        nameField.setHintTextColor(isValid ? Color.GRAY : Color.RED);

        // Validate first name
        Matcher firstnameMatcher = namePattern.matcher(firstname);
        // Only alphabetical caracters, min length of 1 and max length of 40 caracters
        isValid = firstnameMatcher.find() && firstname.length() <= 40;
        firstnameField.setTextColor(isValid ? Color.BLACK : Color.RED);
        firstnameField.setHintTextColor(isValid ? Color.GRAY : Color.RED);

        // Validate postal code
        Pattern pcPattern = Pattern.compile("[A-Z]{1}[0-9]{1}[A-Z]{1}-[0-9]{1}[A-Z]{1}[0-9]{1}");
        Matcher pcMatcher = pcPattern.matcher(postalcode);
        isValid = pcMatcher.find();
        postalcodeField.setTextColor(isValid ? Color.BLACK : Color.RED); // Format LNL-NLN
        postalcodeField.setHintTextColor(isValid ? Color.GRAY : Color.RED);

        // Submission confirmation
        TextView resultField = (TextView) findViewById(R.id.resultField);
        resultField.setText(isValid ? "REGISTERED" : "INVALID FORMAT");
        resultField.setTextColor(isValid ? Color.GREEN : Color.RED);
        resultField.setVisibility(View.VISIBLE);
    }

    public void goToMainMenu(View view) {
        Intent goToMainMenuIntent = new Intent(this, MainActivity.class);
        goToMainMenuIntent.putExtra("theUser", "user" /*TODO*/);
        startActivity(goToMainMenuIntent);
    }
}