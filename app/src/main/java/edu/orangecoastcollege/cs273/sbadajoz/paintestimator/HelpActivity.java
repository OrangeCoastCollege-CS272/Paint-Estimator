package edu.orangecoastcollege.cs273.sbadajoz.paintestimator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Intent intent = getIntent();
        ((TextView)findViewById(R.id.amountTextView)).setText("Estimated Paint Required: " + intent.getFloatExtra("gallons" , 0) + " gallons");
    }

    protected void goBack(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
