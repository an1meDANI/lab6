package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private DBHelper helper;
    private SQLiteDatabase database;
    private ListView list;
    private Button button, button2, button3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        helper = new DBHelper(getApplicationContext());

        try {
            database = helper.getWritableDatabase();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> products = new ArrayList<>();
                HashMap<String, String> product;
                Cursor cursor = database.rawQuery("SELECT * FROM Products WHERE Categories_id = 1", null);
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {
                    product = new HashMap<>();
                    product.put("name", cursor.getString(0));
                    product.put("info", "price: " + cursor.getString(2) + "\ndescription: " + cursor.getString((1)));
                    products.add(product);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        products,
                        android.R.layout.simple_list_item_2,
                        new String[]{"name", "info"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );
                list.setAdapter(adapter);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> products = new ArrayList<>();
                HashMap<String, String> product;
                Cursor cursor = database.rawQuery("SELECT * FROM Products WHERE Categories_id = 2", null);
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {
                    product = new HashMap<>();
                    product.put("name", cursor.getString(0));
                    product.put("info", "price: " + cursor.getString(2) + "\ndescription: " + cursor.getString((1)));
                    products.add(product);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        products,
                        android.R.layout.simple_list_item_2,
                        new String[]{"name", "info"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );
                list.setAdapter(adapter);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> products = new ArrayList<>();
                HashMap<String, String> product;
                Cursor cursor = database.rawQuery("SELECT * FROM Products WHERE Categories_id = 3", null);
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {
                    product = new HashMap<>();
                    product.put("name", cursor.getString(0));
                    product.put("info", "price: " + cursor.getString(2) + "\ndescription: " + cursor.getString((1)));
                    products.add(product);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        products,
                        android.R.layout.simple_list_item_2,
                        new String[]{"name", "info"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );
                list.setAdapter(adapter);
            }
        });
    }
}