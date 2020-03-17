package com.example.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Spinner spinner;
    SeekBar sBar;
    TextView tView;
    RadioButton rb1,rb2,rb3;
    Button calculate,submitOrder;
    CheckBox confirmOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sBar = (SeekBar) findViewById(R.id.seekBar1);
        tView = (TextView) findViewById(R.id.textview1);
        tView.setText(sBar.getProgress() + "/" + sBar.getMax());
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pval = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tView.setText(pval + "/" + seekBar.getMax());
            }
        });


    }


    public void submitOrder(View view) {

    }

    public void calculate(View view) {

    }
}
