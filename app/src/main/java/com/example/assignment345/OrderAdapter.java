package com.example.assignment345;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class OrderAdapter extends ArrayAdapter{
    Context mContext;
    int layoutRes;
    List<orderInfo> Orders;
    DbHandler MyDb;

    public OrderAdapter(@NonNull Context mContext, int layoutRes, List<orderInfo> Orders, DbHandler MyDb){
        super(mContext,layoutRes,Orders);
        this.mContext = mContext;
        this.layoutRes=layoutRes;
        this.Orders = Orders;
        this.MyDb = MyDb;
    }
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(layoutRes, null);
        TextView tvName = v.findViewById(R.id.MealName);
        TextView tvPrice = v.findViewById(R.id.Price);
        TextView tvQuantity = v.findViewById(R.id.Quantity);
        TextView tvTip = v.findViewById(R.id.Tip);
        TextView tvTax = v.findViewById(R.id.Tax);
        TextView tvCost = v.findViewById(R.id.Cost);

        final orderInfo order = Orders.get(position);

        tvName.setText("Meal: "+order.getMealName());
        tvPrice.setText("Price: "+String.valueOf(order.getPrice()));
        tvQuantity.setText("Qty: "+String.valueOf(order.getQuantity()));
        tvTip.setText("Tip: "+String.valueOf(order.getTip()));
        tvTax.setText("Tax: "+String.valueOf(order.getTax()));
        tvCost.setText("Cost: "+String.valueOf(order.getCost()));

        return v;
    }

    private void loadOrders(){
        Cursor cursor = MyDb.getAllOrders();
        Orders.clear();
        if(cursor.moveToFirst()) {
            do {
                Orders.add(new orderInfo(
                        cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getDouble(4),
                        cursor.getDouble(5),
                        cursor.getDouble(6)
                ));
            } while (cursor.moveToNext());
            cursor.close();
        }
        notifyDataSetChanged();

        }
}
