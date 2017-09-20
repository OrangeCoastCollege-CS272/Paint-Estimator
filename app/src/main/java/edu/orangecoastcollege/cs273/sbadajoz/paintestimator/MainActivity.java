package edu.orangecoastcollege.cs273.sbadajoz.paintestimator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mLengthText;
    private EditText mWidthText;
    private EditText mHeightText;
    private EditText mDoorsText;
    private EditText mWindowsText;

    private TextView mComputeText;

    private InteriorRoom mInteriorRoom = new InteriorRoom();

    private SharedPreferences mPreferences;
    private void initializeViews() {
        mLengthText = (EditText) findViewById(R.id.lengthText);
        mWidthText = (EditText) findViewById(R.id.widthText);
        mHeightText = (EditText) findViewById(R.id.heightText);
        mDoorsText = (EditText) findViewById(R.id.doorsText);
        mWindowsText = (EditText) findViewById(R.id.windowsText);
        mComputeText = (TextView) findViewById(R.id.computeText);
    }

    private void loadSharedPreferences() {
        mPreferences = getSharedPreferences("edu.orangecoastcollege.cs273.sbadajoz.PaintEstimator", MODE_PRIVATE);
        if (mPreferences != null) {
            mInteriorRoom.setLength(mPreferences.getFloat("length", 0.0f));
            mInteriorRoom.setWidth(mPreferences.getFloat("width", 0.0f));
            mInteriorRoom.setHeight(mPreferences.getFloat("height", 0.0f));
            mInteriorRoom.setDoors(mPreferences.getInt("doors", 0));
            mInteriorRoom.setWindows(mPreferences.getInt("windows", 0));

            mLengthText.setText(String.valueOf(mInteriorRoom.getLength()));
            mWidthText.setText(String.valueOf(mInteriorRoom.getWidth()));
            mHeightText.setText(String.valueOf(mInteriorRoom.getHeight()));
            mDoorsText.setText(String.valueOf(mInteriorRoom.getDoors()));
            mWindowsText.setText(String.valueOf(mInteriorRoom.getWindows()));
        }
    }

    private void saveSharedPreferences() {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.clear();

        editor.putFloat("length", mInteriorRoom.getLength());
        editor.putFloat("width", mInteriorRoom.getWidth());
        editor.putFloat("height", mInteriorRoom.getHeight());
        editor.putInt("doors", (int) mInteriorRoom.getDoors());
        editor.putInt("windows", (int) mInteriorRoom.getWindows());

        editor.commit();
    }

    protected void setComputeText(View view) {
        saveSharedPreferences();
        mInteriorRoom.setLength(Float.parseFloat(mLengthText.getText().toString()));
        mInteriorRoom.setWidth(Float.parseFloat(mWidthText.getText().toString()));
        mInteriorRoom.setHeight(Float.parseFloat(mHeightText.getText().toString()));
        mInteriorRoom.setDoors(Float.parseFloat(mDoorsText.getText().toString()));
        mInteriorRoom.setWindows(Float.parseFloat(mWindowsText.getText().toString()));

        StringBuilder str = new StringBuilder("Interior surface area: ");
        str.append(mInteriorRoom.totalSurfaceArea()).append(" feet\n");
        str.append("Gallons needed: ").append(mInteriorRoom.gallonsOfPaintRequires());

        mComputeText.setText(str.toString());
    }

    protected void goToHelp(View view) {
        Intent intent = new Intent(this, HelpActivity.class);
        intent.putExtra("gallons", mInteriorRoom.gallonsOfPaintRequires());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        loadSharedPreferences();
    }
}
