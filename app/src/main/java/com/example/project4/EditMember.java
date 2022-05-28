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

public class EditMember extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO: Check if user is logged in
        boolean isLoggedIn = true;
        if (!isLoggedIn) {
            this.goToLogin();
            return;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_member);

        TextView editMemberTitle = (TextView) findViewById(R.id.editMemberTitle);
        editMemberTitle.setText("Edit \"user\" profile"/*TODO*/);

        EditText nameField = (EditText) findViewById(R.id.nameField2);
        nameField.setText("Name"/*TODO*/);

        EditText firstnameField = (EditText) findViewById(R.id.firstnameField2);
        firstnameField.setText("First name"/*TODO*/);

        EditText postalcodeField = (EditText) findViewById(R.id.postalCodeField2);
        postalcodeField.setText("Postal code"/*TODO*/);

        TextView resultField = (TextView) findViewById(R.id.resultField2);
        resultField.setText("");
    }

    public void update(View view) {
        EditText nameField = (EditText) findViewById(R.id.nameField2);
        String name = nameField.getText().toString();

        EditText firstnameField = (EditText) findViewById(R.id.firstnameField2);
        String firstname = firstnameField.getText().toString();

        EditText postalcodeField = (EditText) findViewById(R.id.postalCodeField2);
        String postalcode = postalcodeField.getText().toString();

        // Validate name
        Pattern namePattern = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE);
        Matcher nameMatcher = namePattern.matcher(name);
        // Only alphabetical caracters, min length of 1 and max length of 40 caracters
        boolean nameIsValid = nameMatcher.find() && name.length() <= 40;
        if (!nameIsValid)
            nameField.setError("Invalid format");

        // Validate first name
        Matcher firstnameMatcher = namePattern.matcher(firstname);
        // Only alphabetical caracters, min length of 1 and max length of 40 caracters
        boolean firstnameIsValid = firstnameMatcher.find() && firstname.length() <= 40;
        if (!firstnameIsValid)
            firstnameField.setError("Invalid format");

        // Validate postal code
        Pattern pcPattern = Pattern.compile("[A-Z]{1}[0-9]{1}[A-Z]{1}-[0-9]{1}[A-Z]{1}[0-9]{1}");
        Matcher pcMatcher = pcPattern.matcher(postalcode);
        boolean postalcodeIsValid = pcMatcher.find();
        if (!postalcodeIsValid)
            postalcodeField.setError("Invalid format"); // Format LNL-NLN

        // Submission confirmation
        boolean isValid = nameIsValid && firstnameIsValid && postalcodeIsValid;
        TextView resultField = (TextView) findViewById(R.id.resultField2);
        resultField.setText(isValid ? "UPDATED" : "");
    }

    public void goToMainMenu(View view) {
        Intent goToMainMenuIntent = new Intent(this, MainActivity.class);
        goToMainMenuIntent.putExtra("theUser", "user" /*TODO*/);
        startActivity(goToMainMenuIntent);
    }

    public void goToLogin() {
        Intent goToLoginIntent = new Intent(this, MainActivity.class);
        goToLoginIntent.putExtra("theUser", "user" /*TODO*/);
        startActivity(goToLoginIntent);
    }
}