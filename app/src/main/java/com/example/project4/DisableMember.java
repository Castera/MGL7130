package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisableMember extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disable_member);

        TextView disableMemberTitle = (TextView) findViewById(R.id.disableMemberTitle);
        disableMemberTitle.setText("Disable \"user\" account"/*TODO*/);

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        nameTextView.setText("Name"/*TODO*/);

        TextView firstnameTextView = (TextView) findViewById(R.id.firstnameTextView);
        firstnameTextView.setText("First name"/*TODO*/);

        TextView postalcodeTextView = (TextView) findViewById(R.id.postalcodeTextView);
        postalcodeTextView.setText("Postal code"/*TODO*/);

        TextView resultField = (TextView) findViewById(R.id.resultField3);
        resultField.setText("");
    }

    public void disable(View view) {
        TextView resultField = (TextView) findViewById(R.id.resultField3);
        resultField.setText("DISABLED");

        Button disableButton = (Button) findViewById(R.id.disableButton);
        disableButton.setEnabled(false);
    }

    public void goToMainMenu(View view) {
        Intent goToMainMenuIntent = new Intent(this, MainActivity.class);
        goToMainMenuIntent.putExtra("theUser", "user" /*TODO*/);
        startActivity(goToMainMenuIntent);
    }
}