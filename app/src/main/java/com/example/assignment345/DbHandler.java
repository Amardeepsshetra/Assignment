package com.example.assignment345;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {

    private static final String Db_Name = "MealOrders";
    private static final int Db_Version = 1;

    public static final String Table_Name = "Meals";
    public static final String ID = "MealId";
    public static final String Meal = "MealName";
    public static final String Price = "MealPrice";
    public static final String Quantity = "MealQuantity";
    public static final String Tip = "MealTip";
    public static final String Tax = "Tax";
    public static final String Cost = "MealCost";

    private static final String Create_table =
            "CREATE TABLE "+ Table_Name + "( "+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Meal +" VARCHAR," +
                    Price +" INTEGER, " +
                    Quantity + " INTEGER, " +
                    Tip + " DOUBLE," +
                    Tax + " DOUBLE," +
                    Cost +" DOUBLE )";

//            "Create Table " + Table_Name + "(" +
//            ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            Meal + "varchar NOT NULL, " + Price + "integer NOT NULL, " +
//            Quantity + "integer NOT NULL, " + Tip + "double NOT NULL, " +
//            Tax + "double NOT NULL, " + Cost + "double NOT NULL "+");";

    public DbHandler(@Nullable Context context) {
        super(context, Db_Name, null, Db_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table If Exists " + Table_Name);
        db.execSQL(Create_table);
        onCreate(db);
    }

    boolean addOrder(String meal, int price, int quantity, double tip, double tax, double cost) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put(Meal, meal);
        value.put(Price, String.valueOf(Price));
        value.put(Quantity, String.valueOf(Quantity));
        value.put(Tip,String.valueOf(tip));
        value.put(Tax, String.valueOf(Tax));
        value.put(Cost, String.valueOf(Cost));

        return sqLiteDatabase.insert(Table_Name, null ,value) != -1;
    }

    Cursor getAllOrders(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + Table_Name, null);
    }


}
