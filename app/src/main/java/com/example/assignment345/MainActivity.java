package com.example.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Spinner spinner;
    SeekBar sBar;
    TextView tView;
    RadioButton rb1,rb2,rb3;
    Button calculate1,submitOrder1;
    CheckBox confirmOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 =(EditText) findViewById(R.id.editText);
        et2 =(EditText) findViewById(R.id.editText2);
        spinner =(Spinner) findViewById(R.id.meals);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        calculate1 = (Button) findViewById(R.id.button);
        submitOrder1 = (Button) findViewById(R.id.button2);
        confirmOrder = (CheckBox) findViewById(R.id.checkBox);

        List<String> meals = new ArrayList<>();
        meals.add("**Select**");
        meals.add("Chowmein");
        meals.add("Egg Maggi");
        meals.add("Veggie Thali");
        meals.add("Chilli Paneer");
        meals.add("Chilli Chicken");
        meals.add("Samosa");
        meals.add("Chole Bhature");
        meals.add("Chilly Potato");
        meals.add("Chowmein Burger");
        meals.add("Chicken Burger");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,meals);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getSelectedItem().toString().equals("Chowmein")){
                    et1.setText("40");
                }else if(spinner.getSelectedItem().toString().equals("Egg Maggi")){
                    et1.setText("30");
                }else if(spinner.getSelectedItem().toString().equals("Veggie Thali")){
                    et1.setText("20");
                }else if(spinner.getSelectedItem().toString().equals("Chilli Paneer")){
                    et1.setText("35");
                }else if(spinner.getSelectedItem().toString().equals("Chilli Chicken")){
                    et1.setText("50");
                }else if(spinner.getSelectedItem().toString().equals("Samosa")){
                    et1.setText("10");
                }else if(spinner.getSelectedItem().toString().equals("Chole Bhature")){
                    et1.setText("40");
                }else if(spinner.getSelectedItem().toString().equals("Chilly Potato")){
                    et1.setText("45");
                }else if(spinner.getSelectedItem().toString().equals("Chowmein Burger")){
                    et1.setText("25");
                }else if(spinner.getSelectedItem().toString().equals("Chicken Burger")){
                    et1.setText("35");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
