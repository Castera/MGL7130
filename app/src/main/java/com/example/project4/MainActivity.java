package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent loginIntent = getIntent();
        String loggedUser = loginIntent.getStringExtra("theUser");

        TextView title = (TextView) findViewById(R.id.MainTitle);
        title.setText("Welcome " + loggedUser);

        // TMP
        Intent goToRegisterPage = new Intent(this, EditMember.class);
        startActivity(goToRegisterPage);
    }
}