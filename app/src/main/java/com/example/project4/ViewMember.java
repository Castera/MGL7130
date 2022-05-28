package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewMember extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO: Check if user is logged in
        boolean isLoggedIn = true;
        if (!isLoggedIn) {
            this.goToLogin();
            return;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_member);

        TextView viewMemberTitle = (TextView) findViewById(R.id.viewMemberTitle);
        viewMemberTitle.setText("\"user\" profile"/*TODO*/);

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView2);
        nameTextView.setText("Name"/*TODO*/);

        TextView firstnameTextView = (TextView) findViewById(R.id.firstnameTextView2);
        firstnameTextView.setText("First name"/*TODO*/);

        TextView postalcodeTextView = (TextView) findViewById(R.id.postalcodeTextView2);
        postalcodeTextView.setText("Postal code"/*TODO*/);
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