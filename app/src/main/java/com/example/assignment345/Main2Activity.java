package com.example.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    DbHandler MyDb;
    List<orderInfo> orderList = new ArrayList<>();
    ListView listView;
    TextView TView_MealName,TView_Price,TView_Quantity,TView_Tip,TView_Tax,TView_Cost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TView_MealName=(TextView)findViewById(R.id.MealName);
        TView_Price=(TextView)findViewById(R.id.Price);
        TView_Quantity=(TextView)findViewById(R.id.Quantity);
        TView_Tip=(TextView)findViewById(R.id.Tip);
        TView_Tax=(TextView)findViewById(R.id.Tax);
        TView_Cost=(TextView)findViewById(R.id.Cost);
        listView = (ListView)findViewById(R.id.listView);

        MyDb = new DbHandler(this);
        loadOrders();


    }

    private void loadOrders() {

        Cursor cursor = MyDb.getAllOrders();

        if(cursor.moveToFirst()){
            do {
                orderList.add(new orderInfo(
                        cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getDouble(4),
                        cursor.getDouble(5),
                        cursor.getDouble(6)
                ));
            }while (cursor.moveToNext());
            cursor.close();


            OrderAdapter orderadapter = new OrderAdapter(this,R.layout.list_item, orderList, MyDb);
            listView.setAdapter(orderadapter);
        }
    }
}
