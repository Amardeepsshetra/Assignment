package com.example.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    EditText etOne;
    SeekBar sbsyst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler seekBarHandler = new Handler();
         sbsyst = (SeekBar) findViewById(R.id.seekBar);
        sbsyst.setMax(0);
        sbsyst.setMax(10);

        etOne = (EditText) findViewById(R.id.editText);

        etOne.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                int i = Integer.parseInt(s.toString());
                if (i >= 0 && i <= 10) {
                    sbsyst.setProgress( i - 0); // This ensures 0-120 value for seekbar
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }


}
