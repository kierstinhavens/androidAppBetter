package com.example.testprogram3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class Activity_display_message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        setSupportActionBar(findViewById(R.id.my_toolbar));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        //onOptionsItemSelected();
        // Retrieve the first and last names from the intent
        Intent intent = getIntent();
        String messageFirstName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_FIRST);
        String messageLastName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_LAST);

        // Create a welcome message
        String finalDisplay = "The following contact has been added!\n" + messageFirstName + " " + messageLastName;

        // Display the welcome message in a TextView or another UI element
        TextView textViewWelcome = findViewById(R.id.contactAdded);
        textViewWelcome.setText(finalDisplay);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
