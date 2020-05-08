package com.example.p03_classjournal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    TextView tv1;
    Button b1;
    RadioGroup rg1;
    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv1 = findViewById(R.id.textView4);
        b1 = findViewById(R.id.button4);
        rg1 = findViewById(R.id.radioGroup);

        Intent intent = getIntent();
        num = intent.getIntExtra("thing", 0);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Week " + num);

        tv1.setText("Week " + num);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                RadioButton r = (RadioButton) rg1.getChildAt(rg1.indexOfChild(rg1.findViewById(rg1.getCheckedRadioButtonId())));
                i.putExtra("thong", new Week(num, r.getText().toString()));
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
