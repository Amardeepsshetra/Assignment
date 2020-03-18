package com.example.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
    DbHandler MyDb;
    RadioGroup radioG;
    int pval = 0;


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
        radioG = findViewById(R.id.radioGroup);

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

        MyDb = new DbHandler(this);


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
                    et1.setText("80");
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
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tView.setText(pval + "/" + seekBar.getMax());
            }
        });




    }

    public void calculate(View view) {
    String price1 = et1.getText().toString();
    int final_price = Integer.parseInt(price1);
    int quantity = pval;
    double tax = 0.13;
    double tip = 0.0;

    if(rb1.isChecked()){
         tip = 0.10;
    }else if(rb2.isChecked()){
         tip = 0.15;
    }else if(rb3.isChecked()){
         tip = 0.20;
    }

    double price = (final_price * quantity) + (tip * final_price);
    double total_tax = price * tax;
    double total_price = price + total_tax;

    String displayPrice = Double.toString(total_price);
    et2.setText(displayPrice);

    }

    public void submitOrder(View view) {
        if (spinner.getSelectedItem() == null || pval == 0 || radioG.getCheckedRadioButtonId() == -1 || confirmOrder.isChecked() == false) {
            Toast.makeText(this, "All Fields Required.",
                    Toast.LENGTH_SHORT).show();
        }
        String mealName = spinner.getSelectedItem().toString();
        int price = Integer.parseInt(et1.getText().toString());
        int quantity = pval;
        Double tip = 0.0;

        switch (radioG.getCheckedRadioButtonId()) {
            case R.id.radioButton:
                tip = 0.10;
                break;
            case R.id.radioButton2:
                tip = 0.15;
                break;
            case R.id.radioButton3:
                tip = 0.20;
                break;
            default:
                break;
        }
        Double tax = 0.13;
        Double cost = Double.parseDouble(et2.getText().toString());

        if(MyDb.addOrder(mealName,price,quantity,tip,tax,cost)){
            Toast.makeText(this, "Order Added", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Order not added", Toast.LENGTH_SHORT).show();
    }

}
