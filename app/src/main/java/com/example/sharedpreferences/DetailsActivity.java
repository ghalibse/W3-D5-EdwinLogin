package com.example.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textView = (TextView) findViewById(R.id.a_details_txt);

        Student student = getIntent()
                .getExtras()
                .getParcelable(MainActivity.STUDENT_BUNDLE_KEY);

        textView.setText("Welcome! " + student.toString());

    }
}
