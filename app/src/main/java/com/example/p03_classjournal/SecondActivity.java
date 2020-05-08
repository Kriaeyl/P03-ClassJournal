package com.example.p03_classjournal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {
    ArrayList<Week> weeks;
    ListView lv;
    ArrayAdapter aa;
    Button b1, b2, b3;
    Module cat;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv = this.findViewById(R.id.ListView2);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        weeks = new ArrayList<>();
        // Create a few food objects in Food array
        Intent intent = getIntent();
        cat = (Module) intent.getSerializableExtra("thing");

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Info for " + cat.getCode());

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa = new DGAdapter(this, R.layout.row, weeks);
        lv.setAdapter(aa);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/" + cat.getCode()));
                startActivity(rpIntent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                i.putExtra("thing", weeks.size()+1);
                startActivityForResult(i,0);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{cat.getEmail()});
                message = "Hi faci,\n\nI am ...\nPlease see my results so far, thank you!\n\n";
                for (Week w: weeks) {
                    message += "Week " + w.getNumber() + ": DG: " + w.getGrade() + "\n";
                }
                email.putExtra(Intent.EXTRA_TEXT, message);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle this MIME type, which is, email
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                // Get data passed back from 2nd activity
                weeks.add((Week) data.getSerializableExtra("thong"));
                aa.notifyDataSetChanged();
            }
        }
    }
}

