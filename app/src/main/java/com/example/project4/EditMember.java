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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_member);

        TextView editMemberTitle = (TextView) findViewById(R.id.editMemberTitle);
        editMemberTitle.setText("Edit \"user\" profile"/*TODO*/);

        TextView resultField = (TextView) findViewById(R.id.resultField2);
        resultField.setVisibility(View.INVISIBLE);
    }

    public void update(View view) {
        EditText nameField = (EditText) findViewById(R.id.nameField2);
        String name = nameField.getText().toString();

        EditText firstnameField = (EditText) findViewById(R.id.firstnameField2);
        String firstname = firstnameField.getText().toString();

        EditText postalcodeField = (EditText) findViewById(R.id.postalCodeField2);
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
        isValid = isValid && firstnameMatcher.find() && firstname.length() <= 40;
        firstnameField.setTextColor(isValid ? Color.BLACK : Color.RED);
        firstnameField.setHintTextColor(isValid ? Color.GRAY : Color.RED);

        // Validate postal code
        Pattern pcPattern = Pattern.compile("[A-Z]{1}[0-9]{1}[A-Z]{1}-[0-9]{1}[A-Z]{1}[0-9]{1}");
        Matcher pcMatcher = pcPattern.matcher(postalcode);
        isValid = isValid && pcMatcher.find();
        postalcodeField.setTextColor(isValid ? Color.BLACK : Color.RED); // Format LNL-LNL
        postalcodeField.setHintTextColor(isValid ? Color.GRAY : Color.RED);

        // Submission confirmation
        TextView resultField = (TextView) findViewById(R.id.resultField2);
        resultField.setText(isValid ? "UPDATED" : "INVALID FORMAT");
        resultField.setTextColor(isValid ? Color.GREEN : Color.RED);
        resultField.setVisibility(View.VISIBLE);
    }

    public void goToMainMenu(View view) {
        Intent goToMainMenuIntent = new Intent(this, MainActivity.class);
        goToMainMenuIntent.putExtra("theUser", "user" /*TODO*/);
        startActivity(goToMainMenuIntent);
    }
}